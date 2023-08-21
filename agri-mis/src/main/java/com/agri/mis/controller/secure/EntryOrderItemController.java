package com.agri.mis.controller.secure;

import com.agri.mis.domain.EntryOrderItem;
import com.agri.mis.service.EntryOrderItemService;
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
@RequestMapping("/secure/entryOrderItem")
public class EntryOrderItemController {
    @Autowired
    private EntryOrderItemService service;

    @GetMapping("/pageQuery")
    public Mono<Page<EntryOrderItem>> pageQuery(EntryOrderItem entryOrderItem, @RequestParam("page") int page, @RequestParam("size") int size) {
        return service.pageQuery(entryOrderItem, PageRequest.of(page, size));
    }

    @GetMapping("/findAllByOrderId")
    public Flux<EntryOrderItem> findAllByExpenseId(@RequestParam("orderId") Long orderId) {
        return service.findAllByOrderId(orderId);
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<EntryOrderItem>> find(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mono<EntryOrderItem> save(@RequestBody EntryOrderItem entryOrderItem) {
        return service.add(entryOrderItem);
    }

    @PutMapping("/{id}")
    public Mono<EntryOrderItem> update(@PathVariable Long id, @RequestBody EntryOrderItem entryOrderItem) {
        return service.update(id, entryOrderItem);
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
