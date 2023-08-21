package com.agri.mis.controller.secure;


import com.agri.mis.domain.CheckApply;
import com.agri.mis.service.CheckApplyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
@RequestMapping("/secure/checkApply")
public class CheckApplyController {

    @Autowired
    private CheckApplyService checkApplyService;


    @GetMapping("/{id}")
    public Mono<ResponseEntity<CheckApply>> find(@PathVariable Long id) {
        return checkApplyService.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/pageQuery")
    public Mono<Page<CheckApply>> pageQuery(CheckApply checkApply, @RequestParam("page") int page, @RequestParam("size") int size) {
        return checkApplyService.pageQuery(checkApply, PageRequest.of(page, size));
    }

    @PostMapping
    public Mono<CheckApply> save( @RequestBody CheckApply checkApply) {
        return checkApplyService.add(checkApply);
    }

    @PutMapping("/{id}")
    public Mono<CheckApply> update(@PathVariable Long id, @RequestBody CheckApply checkApply) {
        return checkApplyService.update(id, checkApply);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable Long id) {
        return checkApplyService.findById(id)
                .flatMap(s ->
                        checkApplyService.delete(s)
                                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
