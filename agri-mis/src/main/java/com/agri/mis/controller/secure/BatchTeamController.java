package com.agri.mis.controller.secure;

import com.agri.mis.domain.BatchTeam;
import com.agri.mis.service.BatchTeamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
@RequestMapping("/secure/batchTeam")
public class BatchTeamController {

    @Autowired
    private BatchTeamService batchTeamService;



    @GetMapping("/{id}")
    public Mono<ResponseEntity<BatchTeam>> find(@PathVariable Long id) {
        return batchTeamService.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }


    @GetMapping("/findAllByBatchId")
    public Flux<BatchTeam> findAllByBatchId(Long batchId) {
        return batchTeamService.findAllByBatchId(batchId);
    }


    @PostMapping
    public Mono<BatchTeam> save( @RequestBody BatchTeam batchTeam) {
        return batchTeamService.add(batchTeam);
    }

    @PutMapping("/{id}")
    public Mono<BatchTeam> update(@PathVariable Long id, @RequestBody BatchTeam batchTeam) {
        return batchTeamService.update(id, batchTeam);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable Long id) {
        return batchTeamService.findById(id)
                .flatMap(s ->
                        batchTeamService.delete(s)
                                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
