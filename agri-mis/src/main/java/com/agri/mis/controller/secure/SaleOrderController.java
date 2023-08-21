package com.agri.mis.controller.secure;

import com.agri.mis.domain.SaleOrder;
import com.agri.mis.service.SaleOrderService;
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
@RequestMapping("/secure/saleOrder")
public class SaleOrderController {
    @Autowired
    private SaleOrderService service;

    @GetMapping("/pageQuery")
    public Mono<Page<SaleOrder>> pageQuery(SaleOrder saleOrder, @RequestParam("page") int page, @RequestParam("size") int size) {
        return service.pageQuery(saleOrder, PageRequest.of(page, size));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<SaleOrder>> find(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }



    @PostMapping
    public Mono<SaleOrder> save(@RequestBody SaleOrder saleOrder) {
        return service.add(saleOrder);
    }

    @PutMapping("/{id}")
    public Mono<SaleOrder> update(@PathVariable Long id, @RequestBody SaleOrder saleOrder) {
        return service.update(id, saleOrder);
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
