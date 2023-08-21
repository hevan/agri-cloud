package com.agri.mis.controller.secure;

import com.agri.mis.domain.BatchRisk;
import com.agri.mis.domain.FinanceExpense;
import com.agri.mis.service.FinanceExpenseService;
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
@RequestMapping("/secure/financeExpense")
public class FinanceExpenseController {
    @Autowired
    private FinanceExpenseService service;

    @GetMapping("/pageQuery")
    public Mono<Page<FinanceExpense>> pageQuery(FinanceExpense financeExpense, @RequestParam("page") int page, @RequestParam("size") int size) {
        return service.pageQuery(financeExpense, PageRequest.of(page, size));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<FinanceExpense>> find(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }



    @PostMapping
    public Mono<FinanceExpense> save(@RequestBody FinanceExpense financeExpense) {
        return service.add(financeExpense);
    }

    @PutMapping("/{id}")
    public Mono<FinanceExpense> update(@PathVariable Long id, @RequestBody FinanceExpense financeExpense) {
        return service.update(id, financeExpense);
    }

    @GetMapping("/findAllByBatchId")
    public Flux<FinanceExpense> findAllByBatchId(@RequestParam("batchId") Long batchId) {
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
