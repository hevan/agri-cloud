package com.agri.mis.controller.secure;

import com.agri.mis.domain.BatchBase;
import com.agri.mis.domain.BatchCycleExecute;
import com.agri.mis.domain.Corp;
import com.agri.mis.service.BatchCycleExecuteService;
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
@RequestMapping("/secure/batchCycleExecute")
public class BatchCycleExecuteController {

    @Autowired
    private BatchCycleExecuteService service;


    @GetMapping("/pageQuery")
    public Mono<Page<BatchCycleExecute>> pageQuery(BatchCycleExecute batchCycleExecute, @RequestParam("page") int page, @RequestParam("size") int size) {
        return service.pageQuery(batchCycleExecute, PageRequest.of(page, size));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<BatchCycleExecute>> find(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mono<BatchCycleExecute> save( @RequestBody BatchCycleExecute batchCycleExecute) {
        return service.add(batchCycleExecute);
    }

    @PutMapping("/{id}")
    public Mono<BatchCycleExecute> update(@PathVariable Long id, @RequestBody BatchCycleExecute batchCycleExecute) {
        return service.update(id, batchCycleExecute);
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
