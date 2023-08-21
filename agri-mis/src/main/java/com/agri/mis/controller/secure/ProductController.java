package com.agri.mis.controller.secure;


import com.agri.mis.domain.Corp;
import com.agri.mis.domain.Product;
import com.agri.mis.service.ProductService;
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
@RequestMapping("/secure/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping("/{id}")
    public Mono<ResponseEntity<Product>> find(@PathVariable Long id) {
        return productService.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/pageQuery")
    public Mono<Page<Product>> pageQuery(Product product, @RequestParam("page") int page, @RequestParam("size") int size) {
        return productService.pageQuery(product, PageRequest.of(page, size));
    }

    @PostMapping
    public Mono<Product> save( @RequestBody Product product) {
        return productService.add(product);
    }

    @PutMapping("/{id}")
    public Mono<Product> update(@PathVariable Long id, @RequestBody Product product) {
        return productService.update(id, product);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable Long id) {
        return productService.findById(id)
                .flatMap(s ->
                        productService.delete(s)
                                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/findAllByCorpId")
    public Flux<Product> findAllByCorpId(Long corpId,String name) {
        return productService.findProductByCorpId(corpId,name);
    }

}
