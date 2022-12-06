package com.agri.mis.controller.secure;

import com.agri.mis.domain.SysMenu;
import com.agri.mis.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/secure/sysMenu")
public class SysMenuController {

    @Autowired
    private SysMenuService sysMenuService;

    @GetMapping("/{id}")
    public Mono<ResponseEntity<SysMenu>> getSysMenu(@PathVariable long id) {
        return sysMenuService.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/findAll")
    public Flux<SysMenu> findAll(@RequestParam("corpId") long corpId) {
        return sysMenuService.findAllByCorpId(corpId);
    }


    @PostMapping
    public Mono<SysMenu> add(@RequestBody SysMenu sysMenu) {
        return sysMenuService.add(sysMenu);
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<SysMenu>> update(@PathVariable Long id, @RequestBody SysMenu sysMenu) {
        return sysMenuService.update(id, sysMenu)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable Long id) {
        return sysMenuService.findById(id)
                .flatMap(s ->
                        sysMenuService.delete(s)
                                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
