package com.agri.mis.controller.open;

import com.agri.mis.domain.BatchCycleExpense;
import com.agri.mis.domain.BatchCycleExpenseItem;
import com.agri.mis.service.BatchCycleExpenseItemService;
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
@RequestMapping("/open/batch/cycle/expenseItem")
public class OpenBatchCycleExpenseItemController {
    @Autowired
    private BatchCycleExpenseItemService service;

    @GetMapping("/pageQuery")
    public Mono<Page<BatchCycleExpenseItem>> pageQuery(@RequestParam("expenseId") Long expenseId, @RequestParam("name") String name, @RequestParam("page") int page, @RequestParam("size") int size) {
        return service.pageQuery(expenseId,name, PageRequest.of(page, size));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<BatchCycleExpenseItem>> find(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public Mono<BatchCycleExpenseItem> save( @RequestBody BatchCycleExpenseItem batchCycleExpenseItem) {
        return service.add(batchCycleExpenseItem);
    }

    @PutMapping("/{id}")
    public Mono<BatchCycleExpenseItem> update(@PathVariable Long id, @RequestBody BatchCycleExpenseItem batchCycleExpenseItem) {
        return service.update(id, batchCycleExpenseItem);
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
