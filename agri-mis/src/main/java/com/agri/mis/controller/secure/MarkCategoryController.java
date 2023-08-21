package com.agri.mis.controller.secure;

import com.agri.mis.domain.MarkCategory;
import com.agri.mis.service.MarkCategoryService;
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
@RequestMapping("/secure/mark/category")
public class MarkCategoryController {

    @Autowired
    private MarkCategoryService markCategoryService;

    @GetMapping("/{id}")
    public Mono<ResponseEntity<MarkCategory>> find(@PathVariable Long id){
        return markCategoryService.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/pageQuery")
    public Mono<Page<MarkCategory>> pageQuery(MarkCategory markCategory, @RequestParam("page") int page,@RequestParam("size") int size){
        return markCategoryService.pageQuery(markCategory, PageRequest.of(page,size));
    }

    @PostMapping
    public Mono<MarkCategory> save(@RequestBody MarkCategory markCategory){
        return markCategoryService.add(markCategory);
    }

    @PutMapping("/{id}")
    public Mono<MarkCategory> update(@PathVariable Long id,@RequestBody MarkCategory markCategory){
        return markCategoryService.update(id,markCategory);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable Long id){
        return markCategoryService.findById(id)
                .flatMap(s ->
                        markCategoryService.delete(s)
                                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK))))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}