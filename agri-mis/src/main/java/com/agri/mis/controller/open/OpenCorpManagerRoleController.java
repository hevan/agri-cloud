package com.agri.mis.controller.open;


import com.agri.mis.domain.CorpManagerRole;
import com.agri.mis.service.CorpManagerRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
@RequestMapping("/open/corpManagerRole")
public class OpenCorpManagerRoleController {

    @Autowired
    private CorpManagerRoleService corpManagerRoleService;


    @GetMapping("/{id}")
    public Mono<CorpManagerRole> find(@PathVariable Long id) {
        return corpManagerRoleService.findById(id);
    }

    @GetMapping("/findAllByManagerId")
    public Flux<CorpManagerRole> findAllByManagerId(@RequestParam("managerId") Long managerId) {
        return corpManagerRoleService.findAllByManagerId(managerId);
    }

    @PostMapping("/add")
    public Mono<CorpManagerRole> save( @RequestBody CorpManagerRole corpManagerRole) {
        return corpManagerRoleService.add(corpManagerRole);
    }

    @PutMapping("/{id}")
    public Mono<CorpManagerRole> update(@PathVariable Long id, @RequestBody CorpManagerRole corpManagerRole) {
        return corpManagerRoleService.update(id, corpManagerRole);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable Long id) {
        return corpManagerRoleService.findById(id)
                .flatMap(s ->
                        corpManagerRoleService.delete(s)
                                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
