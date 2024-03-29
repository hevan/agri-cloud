package com.agri.mis.controller.secure;


import com.agri.mis.domain.CorpDepart;
import com.agri.mis.service.CorpDepartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
@RequestMapping("/secure/corpDepart")
public class CorpDepartController {

    @Autowired
    private CorpDepartService corpDepartService;


    @GetMapping("/{id}")
    public Mono<CorpDepart> find(@PathVariable Long id) {
        return corpDepartService.findById(id);
    }

    @GetMapping("/findAllByCorpId")
    public Flux<CorpDepart> findAllByCorpId(@RequestParam("corpId") Long corpId) {
        return corpDepartService.findAllByCorpId(corpId);
    }

    @PostMapping
    public Mono<CorpDepart> save( @RequestBody CorpDepart corpDepart) {
        return corpDepartService.add(corpDepart);
    }

    @PutMapping("/{id}")
    public Mono<CorpDepart> update(@PathVariable Long id, @RequestBody CorpDepart corpDepart) {
        return corpDepartService.update(id, corpDepart);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable Long id) {
        return corpDepartService.findById(id)
                .flatMap(s ->
                        corpDepartService.delete(s)
                                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
