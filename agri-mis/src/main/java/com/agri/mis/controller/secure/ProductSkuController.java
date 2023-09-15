package com.agri.mis.controller.secure;


import com.agri.mis.domain.ProductSku;
import com.agri.mis.service.ProductSkuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
@RequestMapping("/secure/productSku")
public class ProductSkuController {

    @Autowired
    private ProductSkuService categoryService;


    @GetMapping("/{id}")
    public Mono<ResponseEntity<ProductSku>> find(@PathVariable Long id) {
        return categoryService.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/findAll")
    public Flux<ProductSku> findAllByProductId(Long productId) {
        return categoryService.findAllByProductId(productId);
    }

    @PostMapping
    public Mono<ProductSku> save( @RequestBody ProductSku category) {
        return categoryService.add(category);
    }

    @PutMapping("/{id}")
    public Mono<ProductSku> update(@PathVariable Long id, @RequestBody ProductSku category) {
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