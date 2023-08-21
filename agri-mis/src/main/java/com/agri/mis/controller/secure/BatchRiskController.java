package com.agri.mis.controller.secure;

import com.agri.mis.domain.BatchRisk;
import com.agri.mis.service.BatchRiskService;
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
@RequestMapping("/secure/batchRisk")
public class BatchRiskController {

    @Autowired
    private BatchRiskService batchRiskService;

    @GetMapping("/pageQuery")
    public Mono<Page<BatchRisk>> pageQuery(@RequestParam("batchId") Long batchId,  @RequestParam("name") String name, @RequestParam("page") int page, @RequestParam("size") int size) {
        return batchRiskService.pageQuery(batchId, name, PageRequest.of(page, size));
    }


    @GetMapping("/findAllByBatchId")
    public Flux<BatchRisk> findAllByBatchId(@RequestParam("batchId") Long batchId) {
        return batchRiskService.findAllByBatchId(batchId);
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<BatchRisk>> find(@PathVariable Long id) {
        return batchRiskService.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mono<BatchRisk> save( @RequestBody BatchRisk batchRisk) {
        return batchRiskService.add(batchRisk);
    }

    @PutMapping("/{id}")
    public Mono<BatchRisk> update(@PathVariable Long id, @RequestBody BatchRisk batchRisk) {
        return batchRiskService.update(id, batchRisk);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable Long id) {
        return batchRiskService.findById(id)
                .flatMap(s ->
                        batchRiskService.delete(s)
                                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
