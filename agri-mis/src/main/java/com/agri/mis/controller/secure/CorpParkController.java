package com.agri.mis.controller.secure;


import com.agri.mis.domain.CorpPark;
import com.agri.mis.service.CorpParkService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
@RequestMapping("/secure/corpPark")
public class CorpParkController {

    @Autowired
    private CorpParkService corpParkService;


    @GetMapping("/{id}")
    public Mono<CorpPark> find(@PathVariable Long id) {
        return corpParkService.findById(id);
    }

    @GetMapping("/findAllByCorpId")
    public Flux<CorpPark> findAllByCorpId(@RequestParam("corpId") Long corpId) {
        return corpParkService.findAllByCorpId(corpId);
    }

    @PostMapping
    public Mono<CorpPark> save( @RequestBody CorpPark corpPark) {
        return corpParkService.add(corpPark);
    }

    @PutMapping("/{id}")
    public Mono<CorpPark> update(@PathVariable Long id, @RequestBody CorpPark corpPark) {
        return corpParkService.update(id, corpPark);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable Long id) {
        return corpParkService.findById(id)
                .flatMap(s ->
                        corpParkService.delete(s)
                                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
