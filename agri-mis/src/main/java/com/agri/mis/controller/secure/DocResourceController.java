package com.agri.mis.controller.secure;


import com.agri.mis.domain.DocResource;
import com.agri.mis.service.DocResourceService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObjectBuilder;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.gridfs.ReactiveGridFsTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.UUID;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/secure/docResource")
public class DocResourceController {

    private final DocResourceService docResourceService;

    private final ReactiveGridFsTemplate gridFsTemplate;

    @GetMapping("/{id}")
    public Mono<DocResource> find(@PathVariable Long id) {
        return docResourceService.findById(id);
    }

    @GetMapping("/pageQuery")
    public Mono<Page<DocResource>> findAllByCorpId(DocResource docResource, @RequestParam("page") int page, @RequestParam("size") int size) {
        return docResourceService.pageQuery(docResource, PageRequest.of(page, size));
    }

    @PostMapping
    public Mono<DocResource> save( @RequestBody DocResource docResource) {
        return docResourceService.add(docResource);
    }

    @PostMapping("/upload")
    public Mono<DocResource> upload( @RequestPart("docResource") String docResource, @RequestPart("file") Mono<FilePart> filePart) {

        DocResource docResouceObj;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
             docResouceObj = objectMapper.readValue(docResource, DocResource.class);
        }catch (Exception e){
            e.printStackTrace();
            return Mono.empty();
        }
        return filePart.flatMap( fp->{
            var metadata = BasicDBObjectBuilder
                    .start()
                    .append("original-name", fp.filename())
                    .append("userId", docResouceObj.getCreatedUserId())
                    .append("corpId", docResouceObj.getCorpId())
                    .get();
            return gridFsTemplate.store(fp.content(),  docResouceObj.getCreatedUserId() + "-"+  UUID.randomUUID(), metadata);
        }).flatMap((id) -> {
            docResouceObj.setDocUrl(id.toHexString());
            return docResourceService.add(docResouceObj);
        });
    }

    @PutMapping("/{id}")
    public Mono<DocResource> update(@PathVariable Long id, @RequestBody DocResource docResource) {
        return docResourceService.update(id, docResource);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable Long id) {
        return docResourceService.findById(id)
                .flatMap(s ->
                        gridFsTemplate.delete(query(where("_id").is(s.getDocUrl()))).then(Mono.just(s))

                ).flatMap(t->
                        docResourceService.delete(t)
                                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
