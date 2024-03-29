package com.agri.mis.controller.secure;


import com.agri.mis.domain.CmsCategory;
import com.agri.mis.service.CmsCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
@RequestMapping("/secure/cmsCategory")
public class CmsCategoryController {

    @Autowired
    private CmsCategoryService cmsCategoryService;


    @GetMapping("/{id}")
    public Mono<ResponseEntity<CmsCategory>> find(@PathVariable Long id) {
        return cmsCategoryService.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/findAllByCorpId")
    public Flux<CmsCategory> findAllByCorpId(Long corpId) {
        return cmsCategoryService.findAllByCorpId(corpId);
    }

    @PostMapping
    public Mono<CmsCategory> save( @RequestBody CmsCategory cmsCategory) {
        return cmsCategoryService.add(cmsCategory);
    }

    @PutMapping("/{id}")
    public Mono<CmsCategory> update(@PathVariable Long id, @RequestBody CmsCategory cmsCategory) {
        return cmsCategoryService.update(id, cmsCategory);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable Long id) {
        return cmsCategoryService.findById(id)
                .flatMap(s ->
                        cmsCategoryService.delete(s)
                                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
