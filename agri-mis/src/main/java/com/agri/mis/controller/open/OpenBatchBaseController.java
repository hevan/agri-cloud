package com.agri.mis.controller.open;

import com.agri.mis.domain.Address;
import com.agri.mis.domain.BatchBase;
import com.agri.mis.service.BatchBaseService;
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
@RequestMapping("/open/batch/base")
public class OpenBatchBaseController {

    @Autowired
    private BatchBaseService batchBaseService;

    @GetMapping("/{id}")
    public Mono<ResponseEntity<BatchBase>> find(@PathVariable Long id) {
        return batchBaseService.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }



    @PostMapping("/add")
    public Mono<BatchBase> save( @RequestBody BatchBase batchBase) {
        return batchBaseService.add(batchBase);
    }

    @PutMapping("/{id}")
    public Mono<BatchBase> update(@PathVariable Long id, @RequestBody BatchBase batchBase) {
        return batchBaseService.update(id, batchBase);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable Long id) {
        return batchBaseService.findById(id)
                .flatMap(s ->
                        batchBaseService.delete(s)
                                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
