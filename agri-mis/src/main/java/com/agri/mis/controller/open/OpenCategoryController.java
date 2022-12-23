package com.agri.mis.controller.open;


import com.agri.mis.domain.Category;
import com.agri.mis.service.CategoryService;
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
@RequestMapping("/open/category")
public class OpenCategoryController {

    @Autowired
    private CategoryService categoryService;


    @GetMapping("/{id}")
    public Mono<ResponseEntity<Category>> find(@PathVariable Long id) {
        return categoryService.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/findAll")
    public Flux<Category> findAll(Long corpId) {
        return categoryService.findAllByCorpId(corpId);
    }

    @PostMapping("/add")
    public Mono<Category> save( @RequestBody Category category) {
        return categoryService.add(category);
    }

    @PutMapping("/{id}")
    public Mono<Category> update(@PathVariable Long id, @RequestBody Category category) {
        return categoryService.update(id, category);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable Long id) {
        return categoryService.findById(id)
                .flatMap(s ->
                        categoryService.delete(s)
                                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
