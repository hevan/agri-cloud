package com.agri.mis.controller.secure;


import com.agri.mis.domain.CmsBlog;
import com.agri.mis.dto.CmsBlogInfo;
import com.agri.mis.service.CmsBlogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
@RequestMapping("/secure/cmsBlog")
public class CmsBlogController {

    @Autowired
    private CmsBlogService cmsBlogService;


    @GetMapping("/{id}")
    public Mono<ResponseEntity<CmsBlog>> find(@PathVariable Long id) {
        return cmsBlogService.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }


    @PostMapping
    public Mono<CmsBlog> save( @RequestBody CmsBlog cmsBlog) {
        return cmsBlogService.add(cmsBlog);
    }

    @PutMapping("/{id}")
    public Mono<CmsBlog> update(@PathVariable Long id, @RequestBody CmsBlog cmsBlog) {
        return cmsBlogService.update(id, cmsBlog);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable Long id) {
        return cmsBlogService.findById(id)
                .flatMap(s ->
                        cmsBlogService.delete(s)
                                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/pageQuery")
    public Mono<Page<CmsBlogInfo>> pageQuery(CmsBlog cmsBlog , @RequestParam("page") int page, @RequestParam("size") int size) {
        return cmsBlogService.pageQuery(cmsBlog, PageRequest.of(page, size));
    }

}
