package com.agri.mis.controller.secure;


import com.agri.mis.domain.CmsUserActive;
import com.agri.mis.service.CmsUserActiveService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
@RequestMapping("/secure/cmsUserActive")
public class CmsUserActiveController {

    @Autowired
    private CmsUserActiveService cmsUserActiveService;

    @GetMapping("/{id}")
    public Mono<ResponseEntity<CmsUserActive>> find(@PathVariable Long id) {
        return cmsUserActiveService.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mono<CmsUserActive> save( @RequestBody CmsUserActive cmsUserActive) {
        return cmsUserActiveService.add(cmsUserActive);
    }

    @PutMapping("/{id}")
    public Mono<CmsUserActive> update(@PathVariable Long id, @RequestBody CmsUserActive cmsUserActive) {
        return cmsUserActiveService.update(id, cmsUserActive);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable Long id) {
        return cmsUserActiveService.findById(id)
                .flatMap(s ->
                        cmsUserActiveService.delete(s)
                                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
