package com.agri.mis.controller.open;

import com.agri.mis.domain.MarkProductCycleExpense;
import com.agri.mis.domain.MarkProductMarket;
import com.agri.mis.dto.MarkProductCycleExpenseWithProductBatchWithCycle;
import com.agri.mis.dto.MarkProductMarketWithProductWithMarket;
import com.agri.mis.service.MarkProductMarketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@RestController
@Slf4j
@RequestMapping("/open/mark/product/Market")
public class OpenMarkProductMarketController {

    @Autowired
    private MarkProductMarketService service;

    @GetMapping("/{id}")
    public Mono<ResponseEntity<MarkProductMarket>> findById(@PathVariable Long id){
        return service.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/pageQuery")
    public Mono<Page<MarkProductMarketWithProductWithMarket>> pageQuery(@RequestParam("priceWholesale") BigDecimal priceWholesale, @RequestParam("page") int page, @RequestParam("size") int size){
        return service.pageQuery(priceWholesale, PageRequest.of(page,size));
    }

    @PostMapping("/add")
    public Mono<MarkProductMarket> add(@RequestBody MarkProductMarket markMarket){
        return service.add(markMarket);
    }

    @PutMapping("/{id}")
    public Mono<MarkProductMarket> update(@PathVariable Long id,@RequestBody MarkProductMarket markMarket){
        return service.update(id,markMarket);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable Long id){
        return service.findById(id).flatMap(s->
                        service.delete(s).then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK))))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
