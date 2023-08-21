package com.agri.mis.controller.open;


import com.agri.mis.domain.PlanPark;
import com.agri.mis.service.PlanParkService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
@RequestMapping("/open/planPark")
public class OpenPlanParkController {

    @Autowired
    private PlanParkService planParkService;


    @GetMapping("/{id}")
    public Mono<PlanPark> find(@PathVariable Long id) {
        return planParkService.findById(id);
    }

    @GetMapping("/findAllByCounty")
    public Flux<PlanPark> findAllByCounty(String county) {
        return planParkService.findAllByCounty(county);
    }

    @PostMapping
    public Mono<PlanPark> save( @RequestBody PlanPark planPark) {
        return planParkService.add(planPark);
    }

    @PutMapping("/{id}")
    public Mono<PlanPark> update(@PathVariable Long id, @RequestBody PlanPark planPark) {
        return planParkService.update(id, planPark);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable Long id) {
        return planParkService.findById(id)
                .flatMap(s ->
                        planParkService.delete(s)
                                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
