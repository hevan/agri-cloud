package com.agri.mis.controller.secure;

import com.agri.mis.domain.FinanceExpenseItem;
import com.agri.mis.service.FinanceExpenseItemService;
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
@RequestMapping("/secure/financeExpenseItem")
public class FinanceExpenseItemController {
    @Autowired
    private FinanceExpenseItemService service;

    @GetMapping("/pageQuery")
    public Mono<Page<FinanceExpenseItem>> pageQuery(@RequestParam("expenseId") Long expenseId, @RequestParam("name") String name, @RequestParam("page") int page, @RequestParam("size") int size) {
        return service.pageQuery(expenseId,name, PageRequest.of(page, size));
    }

    @GetMapping("/findAllByExpenseId")
    public Flux<FinanceExpenseItem> findAllByExpenseId(@RequestParam("expenseId") Long expenseId) {
        return service.findAllByExpenseId(expenseId);
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<FinanceExpenseItem>> find(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mono<FinanceExpenseItem> save(@RequestBody FinanceExpenseItem financeExpenseItem) {
        return service.add(financeExpenseItem);
    }

    @PutMapping("/{id}")
    public Mono<FinanceExpenseItem> update(@PathVariable Long id, @RequestBody FinanceExpenseItem financeExpenseItem) {
        return service.update(id, financeExpenseItem);
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
