package com.agri.mis.controller.secure;

import com.agri.mis.domain.ProductionOrder;
import com.agri.mis.service.ProductionOrderService;
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
@RequestMapping("/secure/productionOrder")
public class ProductionOrderController {
    @Autowired
    private ProductionOrderService service;

    @GetMapping("/pageQuery")
    public Mono<Page<ProductionOrder>> pageQuery(ProductionOrder productionOrder, @RequestParam("page") int page, @RequestParam("size") int size) {
        return service.pageQuery(productionOrder, PageRequest.of(page, size));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<ProductionOrder>> find(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }



    @PostMapping
    public Mono<ProductionOrder> save(@RequestBody ProductionOrder productionOrder) {
        return service.add(productionOrder);
    }

    @PutMapping("/{id}")
    public Mono<ProductionOrder> update(@PathVariable Long id, @RequestBody ProductionOrder productionOrder) {
        return service.update(id, productionOrder);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable Long id) {
        return service.findById(id)
                .flatMap(s ->
                        service.delete(s)
                                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


}
