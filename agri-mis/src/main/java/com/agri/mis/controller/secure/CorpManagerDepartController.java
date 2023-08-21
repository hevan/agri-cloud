package com.agri.mis.controller.secure;


import com.agri.mis.domain.CorpManagerDepart;
import com.agri.mis.service.CorpManagerDepartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
@RequestMapping("/secure/corpManagerDepart")
public class CorpManagerDepartController {

    @Autowired
    private CorpManagerDepartService corpManagerDepartService;


    @GetMapping("/{id}")
    public Mono<CorpManagerDepart> find(@PathVariable Long id) {
        return corpManagerDepartService.findById(id);
    }

    @GetMapping("/findAllByManagerId")
    public Flux<CorpManagerDepart> findAllByManagerId(@RequestParam("managerId") Long managerId) {
        return corpManagerDepartService.findAllByManagerId(managerId);
    }

    @PostMapping
    public Mono<CorpManagerDepart> save( @RequestBody CorpManagerDepart corpManagerDepart) {
        return corpManagerDepartService.add(corpManagerDepart);
    }

    @PutMapping("/{id}")
    public Mono<CorpManagerDepart> update(@PathVariable Long id, @RequestBody CorpManagerDepart corpManagerDepart) {
        return corpManagerDepartService.update(id, corpManagerDepart);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable Long id) {
        return corpManagerDepartService.findById(id)
                .flatMap(s ->
                        corpManagerDepartService.delete(s)
                                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
