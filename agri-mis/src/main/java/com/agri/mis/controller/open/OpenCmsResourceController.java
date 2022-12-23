package com.agri.mis.controller.open;


import com.agri.mis.domain.CmsResource;
import com.agri.mis.service.CmsResourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
@RequestMapping("/open/cmsResource")
public class OpenCmsResourceController {

    @Autowired
    private CmsResourceService cmsResourceService;


    @GetMapping("/{id}")
    public Mono<ResponseEntity<CmsResource>> find(@PathVariable Long id) {
        return cmsResourceService.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/findAllByBlogId")
    public Flux<CmsResource> findAllByBlogId(Long blogId) {
        return cmsResourceService.findAllByBlogId(blogId);
    }

    @PostMapping("/add")
    public Mono<CmsResource> save( @RequestBody CmsResource cmsResource) {
        return cmsResourceService.add(cmsResource);
    }

    @PutMapping("/{id}")
    public Mono<CmsResource> update(@PathVariable Long id, @RequestBody CmsResource cmsResource) {
        return cmsResourceService.update(id, cmsResource);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable Long id) {
        return cmsResourceService.findById(id)
                .flatMap(s ->
                        cmsResourceService.delete(s)
                                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
