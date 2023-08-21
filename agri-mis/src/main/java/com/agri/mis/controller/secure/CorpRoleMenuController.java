package com.agri.mis.controller.secure;


import com.agri.mis.domain.CorpRoleMenu;
import com.agri.mis.service.CorpRoleMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
@RequestMapping("/secure/corpRoleMenu")
public class CorpRoleMenuController {

    @Autowired
    private CorpRoleMenuService corpRoleMenuService;


    @GetMapping("/{id}")
    public Mono<CorpRoleMenu> find(@PathVariable Long id) {
        return corpRoleMenuService.findById(id);
    }

    @GetMapping("/findAllByRoleId")
    public Flux<CorpRoleMenu> findAllByRoleId(@RequestParam("roleId") Long roleId) {
        return corpRoleMenuService.findAllByRoleId(roleId);
    }

    @PostMapping
    public Mono<CorpRoleMenu> save( @RequestBody CorpRoleMenu corpRoleMenu) {
        return corpRoleMenuService.add(corpRoleMenu);
    }

    @PutMapping("/{id}")
    public Mono<CorpRoleMenu> update(@PathVariable Long id, @RequestBody CorpRoleMenu corpRoleMenu) {
        return corpRoleMenuService.update(id, corpRoleMenu);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable Long id) {
        return corpRoleMenuService.findById(id)
                .flatMap(s ->
                        corpRoleMenuService.delete(s)
                                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
