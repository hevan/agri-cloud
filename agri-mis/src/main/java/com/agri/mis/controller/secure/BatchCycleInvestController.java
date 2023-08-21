package com.agri.mis.controller.secure;

import com.agri.mis.domain.BatchCycleInvest;
import com.agri.mis.service.BatchCycleInvestService;
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
@RequestMapping("/secure/batchCycleInvest")
public class BatchCycleInvestController {

    @Autowired
    private BatchCycleInvestService batchCycleInvestService;


    @GetMapping("/findAllByBatchCycleId")
    public Flux<BatchCycleInvest> findAllByBatchCycleId(@RequestParam("batchCycleId") Long batchCycleId) {
        return batchCycleInvestService.findAllByBatchCycleId(batchCycleId);
    }

    @GetMapping("/pageQuery")
    public Mono<Page<BatchCycleInvest>> pageQuery( BatchCycleInvest batchCycleInvest,  @RequestParam("page") int page, @RequestParam("size") int size) {
        return batchCycleInvestService.pageQuery(batchCycleInvest,PageRequest.of(page, size));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<BatchCycleInvest>> find(@PathVariable Long id) {
        return batchCycleInvestService.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mono<BatchCycleInvest> save( @RequestBody BatchCycleInvest batchCycleInvest) {
        return batchCycleInvestService.add(batchCycleInvest);
    }

    @PutMapping("/{id}")
    public Mono<BatchCycleInvest> update(@PathVariable Long id, @RequestBody BatchCycleInvest batchCycleInvest) {
        return batchCycleInvestService.update(id, batchCycleInvest);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable Long id) {
        return batchCycleInvestService.findById(id)
                .flatMap(s ->
                        batchCycleInvestService.delete(s)
                                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
