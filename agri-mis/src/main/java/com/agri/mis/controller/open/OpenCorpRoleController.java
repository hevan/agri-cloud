package com.agri.mis.controller.open;


import com.agri.mis.domain.CorpRole;
import com.agri.mis.service.CorpRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
@RequestMapping("/open/corpRole")
public class OpenCorpRoleController {

    @Autowired
    private CorpRoleService corpRoleService;


    @GetMapping("/{id}")
    public Mono<CorpRole> find(@PathVariable Long id) {
        return corpRoleService.findById(id);
    }

    @GetMapping("/findAllByCorpId")
    public Flux<CorpRole> findAllByCorpId(@RequestParam("corpId") Long corpId) {
        return corpRoleService.findAllByCorpId(corpId);
    }

    @PostMapping("/add")
    public Mono<CorpRole> save( @RequestBody CorpRole corpRole) {
        return corpRoleService.add(corpRole);
    }

    @PutMapping("/{id}")
    public Mono<CorpRole> update(@PathVariable Long id, @RequestBody CorpRole corpRole) {
        return corpRoleService.update(id, corpRole);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable Long id) {
        return corpRoleService.findById(id)
                .flatMap(s ->
                        corpRoleService.delete(s)
                                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
