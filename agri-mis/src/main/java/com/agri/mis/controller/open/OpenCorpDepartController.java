package com.agri.mis.controller.open;


import com.agri.mis.domain.Corp;
import com.agri.mis.domain.CorpDepart;
import com.agri.mis.dto.CorpWithAddress;
import com.agri.mis.service.CorpDepartService;
import com.agri.mis.service.CorpService;
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
@RequestMapping("/open/corpDepart")
public class OpenCorpDepartController {

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

    @PostMapping("/add")
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
