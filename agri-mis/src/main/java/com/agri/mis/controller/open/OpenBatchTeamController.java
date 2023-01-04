package com.agri.mis.controller.open;

import com.agri.mis.domain.BatchRisk;
import com.agri.mis.domain.BatchTeam;
import com.agri.mis.service.BatchTeamService;
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
@RequestMapping("/open/batch/team")
public class OpenBatchTeamController {

    @Autowired
    private BatchTeamService batchTeamService;

    @GetMapping("/pageQuery")
    public Mono<Page<BatchTeam>> pageQuery(@RequestParam("name") String name, @RequestParam("page") int page, @RequestParam("size") int size) {
        return batchTeamService.pageQuery(name, PageRequest.of(page, size));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<BatchTeam>> find(@PathVariable Long id) {
        return batchTeamService.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }



    @PostMapping("/add")
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
