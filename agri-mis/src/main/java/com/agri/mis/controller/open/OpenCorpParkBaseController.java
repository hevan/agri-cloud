package com.agri.mis.controller.open;


import com.agri.mis.domain.CorpParkBase;
import com.agri.mis.service.CorpParkBaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
@RequestMapping("/open/corpParkBase")
public class OpenCorpParkBaseController {

    @Autowired
    private CorpParkBaseService corpParkBaseService;


    @GetMapping("/{id}")
    public Mono<CorpParkBase> find(@PathVariable Long id) {
        return corpParkBaseService.findById(id);
    }

    @GetMapping("/findAllByParkId")
    public Flux<CorpParkBase> findAllByCorpId(@RequestParam("parkId") Long parkId) {
        return corpParkBaseService.findAllByParkId(parkId);
    }

    @PostMapping("/add")
    public Mono<CorpParkBase> save( @RequestBody CorpParkBase corpParkBase) {
        return corpParkBaseService.add(corpParkBase);
    }

    @PutMapping("/{id}")
    public Mono<CorpParkBase> update(@PathVariable Long id, @RequestBody CorpParkBase corpParkBase) {
        return corpParkBaseService.update(id, corpParkBase);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable Long id) {
        return corpParkBaseService.findById(id)
                .flatMap(s ->
                        corpParkBaseService.delete(s)
                                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
