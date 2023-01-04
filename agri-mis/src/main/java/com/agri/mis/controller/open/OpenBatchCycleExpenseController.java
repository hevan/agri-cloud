package com.agri.mis.controller.open;

import com.agri.mis.domain.BatchCycleExecute;
import com.agri.mis.domain.BatchCycleExpense;
import com.agri.mis.service.BatchCycleExpenseService;
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
@RequestMapping("/open/batch/cycle/expense")
public class OpenBatchCycleExpenseController {
    @Autowired
    private BatchCycleExpenseService service;

    @GetMapping("/pageQuery")
    public Mono<Page<BatchCycleExpense>> pageQuery(@RequestParam("name") String name, @RequestParam("page") int page, @RequestParam("size") int size) {
        return service.pageQuery(name, PageRequest.of(page, size));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<BatchCycleExpense>> find(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }



    @PostMapping("/add")
    public Mono<BatchCycleExpense> save( @RequestBody BatchCycleExpense batchCycleExpense) {
        return service.add(batchCycleExpense);
    }

    @PutMapping("/{id}")
    public Mono<BatchCycleExpense> update(@PathVariable Long id, @RequestBody BatchCycleExpense batchCycleExpense) {
        return service.update(id, batchCycleExpense);
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
