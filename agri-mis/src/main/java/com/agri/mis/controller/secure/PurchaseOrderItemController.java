package com.agri.mis.controller.secure;

import com.agri.mis.domain.PurchaseOrderItem;
import com.agri.mis.service.PurchaseOrderItemService;
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
@RequestMapping("/secure/purchaseOrderItem")
public class PurchaseOrderItemController {
    @Autowired
    private PurchaseOrderItemService service;

    @GetMapping("/pageQuery")
    public Mono<Page<PurchaseOrderItem>> pageQuery(@RequestParam("expenseId") Long expenseId, @RequestParam("name") String name, @RequestParam("page") int page, @RequestParam("size") int size) {
        return service.pageQuery(expenseId,name, PageRequest.of(page, size));
    }

    @GetMapping("/findAllByOrderId")
    public Flux<PurchaseOrderItem> pageQuery(@RequestParam("orderId") Long orderId) {
        return service.findAllByOrderId(orderId);
    }
    @GetMapping("/{id}")
    public Mono<ResponseEntity<PurchaseOrderItem>> find(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mono<PurchaseOrderItem> save(@RequestBody PurchaseOrderItem purchaseOrderItem) {
        return service.add(purchaseOrderItem);
    }

    @PutMapping("/{id}")
    public Mono<PurchaseOrderItem> update(@PathVariable Long id, @RequestBody PurchaseOrderItem purchaseOrderItem) {
        return service.update(id, purchaseOrderItem);
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
