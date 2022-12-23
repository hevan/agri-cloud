package com.agri.mis.controller.open;


import com.agri.mis.domain.CmsTag;
import com.agri.mis.service.CmsTagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
@RequestMapping("/open/cmsTag")
public class OpenCmsTagController {

    @Autowired
    private CmsTagService cmsTagService;


    @GetMapping("/{id}")
    public Mono<ResponseEntity<CmsTag>> find(@PathVariable Long id) {
        return cmsTagService.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/findAll")
    public Flux<CmsTag> findAll() {
        return cmsTagService.findAll();
    }

    @PostMapping("/add")
    public Mono<CmsTag> save( @RequestBody CmsTag cmsTag) {
        return cmsTagService.add(cmsTag);
    }

    @PutMapping("/{id}")
    public Mono<CmsTag> update(@PathVariable Long id, @RequestBody CmsTag cmsTag) {
        return cmsTagService.update(id, cmsTag);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable Long id) {
        return cmsTagService.findById(id)
                .flatMap(s ->
                        cmsTagService.delete(s)
                                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
