package com.agri.mis.controller.secure;

import com.agri.mis.domain.EntryOrder;
import com.agri.mis.service.EntryOrderService;
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
@RequestMapping("/secure/entryOrder")
public class EntryOrderController {
    @Autowired
    private EntryOrderService service;

    @GetMapping("/pageQuery")
    public Mono<Page<EntryOrder>> pageQuery(EntryOrder entryOrder, @RequestParam("page") int page, @RequestParam("size") int size) {
        return service.pageQuery(entryOrder, PageRequest.of(page, size));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<EntryOrder>> find(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }



    @PostMapping
    public Mono<EntryOrder> save(@RequestBody EntryOrder entryOrder) {
        return service.add(entryOrder);
    }

    @PutMapping("/{id}")
    public Mono<EntryOrder> update(@PathVariable Long id, @RequestBody EntryOrder entryOrder) {
        return service.update(id, entryOrder);
    }

    @GetMapping("/findAllByBatchId")
    public Flux<EntryOrder> findAllByBatchId(@RequestParam("batchId") Long batchId) {
        return service.findAllByBatchId(batchId);
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
