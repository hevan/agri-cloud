package com.agri.mis.controller.secure;

import com.agri.mis.domain.SaleOrderItem;
import com.agri.mis.service.SaleOrderItemService;
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
@RequestMapping("/secure/saleOrderItem")
public class SaleOrderItemController {
    @Autowired
    private SaleOrderItemService service;

    @GetMapping("/pageQuery")
    public Mono<Page<SaleOrderItem>> pageQuery(@RequestParam("expenseId") Long expenseId, @RequestParam("name") String name, @RequestParam("page") int page, @RequestParam("size") int size) {
        return service.pageQuery(expenseId,name, PageRequest.of(page, size));
    }

    @GetMapping("/findAllByOrderId")
    public Flux<SaleOrderItem> pageQuery(@RequestParam("orderId") Long orderId) {
        return service.findAllByOrderId(orderId);
    }
    @GetMapping("/{id}")
    public Mono<ResponseEntity<SaleOrderItem>> find(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mono<SaleOrderItem> save(@RequestBody SaleOrderItem saleOrderItem) {
        return service.add(saleOrderItem);
    }

    @PutMapping("/{id}")
    public Mono<SaleOrderItem> update(@PathVariable Long id, @RequestBody SaleOrderItem saleOrderItem) {
        return service.update(id, saleOrderItem);
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
