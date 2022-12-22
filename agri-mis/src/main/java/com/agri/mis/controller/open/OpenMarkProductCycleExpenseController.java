package com.agri.mis.controller.open;

import com.agri.mis.domain.MarkProductCycle;
import com.agri.mis.domain.MarkProductCycleExpense;
import com.agri.mis.dto.MarkProductCycleExpenseWithProductBatchWithCycle;
import com.agri.mis.dto.MarkProductCycleWithPproductBatchWithParent;
import com.agri.mis.service.MarkProductCycleExpenseService;
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
@RequestMapping("/open/mark/product/Cycle/Expense")
public class OpenMarkProductCycleExpenseController {
    @Autowired
    private MarkProductCycleExpenseService service;

    @GetMapping("/{id}")
    public Mono<ResponseEntity<MarkProductCycleExpense>> findById(@PathVariable Long id){
        return service.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/pageQuery")
    public Mono<Page<MarkProductCycleExpenseWithProductBatchWithCycle>> pageQuery(@RequestParam("name") String name, @RequestParam("page") int page, @RequestParam("size") int size){
        return service.pageQuery(name, PageRequest.of(page,size));
    }

    @PostMapping("/add")
    public Mono<MarkProductCycleExpense> add(@RequestBody MarkProductCycleExpense markMarket){
        return service.add(markMarket);
    }

    @PutMapping("/{id}")
    public Mono<MarkProductCycleExpense> update(@PathVariable Long id,@RequestBody MarkProductCycleExpense markMarket){
        return service.update(id,markMarket);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable Long id){
        return service.findById(id).flatMap(s->
                        service.delete(s).then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK))))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
