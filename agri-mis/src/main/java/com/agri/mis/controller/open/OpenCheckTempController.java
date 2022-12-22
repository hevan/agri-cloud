package com.agri.mis.controller.open;


import com.agri.mis.domain.CheckTemp;
import com.agri.mis.service.CheckTempService;
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
@RequestMapping("/open/checkTemp")
public class OpenCheckTempController {

    @Autowired
    private CheckTempService checkTempService;


    @GetMapping("/{id}")
    public Mono<ResponseEntity<CheckTemp>> find(@PathVariable Long id) {
        return checkTempService.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/findAll")
    public Flux<CheckTemp> findAll(Long corpId) {
        return checkTempService.findAllByCorpId(corpId);
    }

    @PostMapping("/add")
    public Mono<CheckTemp> save( @RequestBody CheckTemp checkTemp) {
        return checkTempService.add(checkTemp);
    }

    @PutMapping("/{id}")
    public Mono<CheckTemp> update(@PathVariable Long id, @RequestBody CheckTemp checkTemp) {
        return checkTempService.update(id, checkTemp);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable Long id) {
        return checkTempService.findById(id)
                .flatMap(s ->
                        checkTempService.delete(s)
                                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
