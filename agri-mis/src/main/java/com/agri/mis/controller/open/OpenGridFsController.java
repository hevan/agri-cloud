package com.agri.mis.controller.open;

import com.agri.mis.service.DocResourceService;
import com.mongodb.BasicDBObjectBuilder;

import org.springframework.data.mongodb.gridfs.ReactiveGridFsTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ZeroCopyHttpOutputMessage;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URLConnection;
import java.util.Map;
import java.util.UUID;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/open/gridfs")
public class OpenGridFsController {

    private final ReactiveGridFsTemplate gridFsTemplate;
    private final DocResourceService docResourceService;

    public OpenGridFsController(ReactiveGridFsTemplate gridFsTemplate, DocResourceService docResourceService) {
        this.gridFsTemplate = gridFsTemplate;
        this.docResourceService = docResourceService;
    }

    @PostMapping
    public Mono<ResponseEntity> upload( String userId, String corpId, @RequestPart("file") Mono<FilePart> filePart) {
        return filePart.flatMap( fp->{
            var metadata = BasicDBObjectBuilder
                    .start()
                    .append("original-name", fp.filename())
                    .append("userId", userId)
                    .append("corpId", corpId)
                    .get();
             return gridFsTemplate.store(fp.content(), userId+ "-" + UUID.randomUUID(), metadata);
        }).map((id) -> ok().body(Map.of("id", id.toHexString())));
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity> delete(@PathVariable String id) {
        return gridFsTemplate.delete(query(where("_id").is(id))).map(ResponseEntity::ok);
    }


    @GetMapping("/{id}")
    public Flux<Void> read(@PathVariable String id, ServerHttpResponse response) {
        ZeroCopyHttpOutputMessage zeroCopyResponse = (ZeroCopyHttpOutputMessage) response;
        //response.getHeaders().set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=parallel.png");
        //zeroCopyResponse.getHeaders().setContentType(MediaType.IMAGE_JPEG);
        return this.gridFsTemplate.findOne(query(where("_id").is(id)))
                .log()
                .doOnSuccess(gridFSFile -> {
                    if(null != gridFSFile) {
                        String contextType = (String) gridFSFile.getMetadata().get("original-name");
                        String mimeType = URLConnection.guessContentTypeFromName(contextType);

                        zeroCopyResponse.getHeaders().setContentType(MediaType.parseMediaType(mimeType));
                    }
                })
                .flatMap(gridFsTemplate::getResource)
                .flatMapMany(r -> zeroCopyResponse.writeWith(r.getDownloadStream()));
    }
}
