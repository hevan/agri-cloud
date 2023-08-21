package com.agri.mis.controller.secure;

import com.agri.mis.domain.PurchaseOrder;
import com.agri.mis.service.PurchaseOrderService;
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
@RequestMapping("/secure/purchaseOrder")
public class PurchaseOrderController {
    @Autowired
    private PurchaseOrderService service;

    @GetMapping("/pageQuery")
    public Mono<Page<PurchaseOrder>> pageQuery(PurchaseOrder purchaseOrder, @RequestParam("page") int page, @RequestParam("size") int size) {
        return service.pageQuery(purchaseOrder, PageRequest.of(page, size));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<PurchaseOrder>> find(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }



    @PostMapping
    public Mono<PurchaseOrder> save(@RequestBody PurchaseOrder purchaseOrder) {
        return service.add(purchaseOrder);
    }

    @PutMapping("/{id}")
    public Mono<PurchaseOrder> update(@PathVariable Long id, @RequestBody PurchaseOrder purchaseOrder) {
        return service.update(id, purchaseOrder);
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
