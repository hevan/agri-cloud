package com.agri.mis.controller.open;


import com.agri.mis.domain.CheckTrace;
import com.agri.mis.dto.CheckTraceInfo;
import com.agri.mis.service.CheckTraceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
@RequestMapping("/open/checkTrace")
public class OpenCheckTraceController {

    @Autowired
    private CheckTraceService checkTraceService;


    @GetMapping("/{id}")
    public Mono<ResponseEntity<CheckTrace>> find(@PathVariable Long id) {
        return checkTraceService.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/findAll")
    public Flux<CheckTraceInfo> findAll(Long enityId, String entityName) {
        return checkTraceService.findAllByEntityIdAndEntityName(enityId,entityName);
    }

    @PostMapping("/add")
    public Mono<CheckTrace> save( @RequestBody CheckTrace checkTrace) {
        return checkTraceService.add(checkTrace);
    }

    @PutMapping("/{id}")
    public Mono<CheckTrace> update(@PathVariable Long id, @RequestBody CheckTrace checkTrace) {
        return checkTraceService.update(id, checkTrace);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable Long id) {
        return checkTraceService.findById(id)
                .flatMap(s ->
                        checkTraceService.delete(s)
                                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
