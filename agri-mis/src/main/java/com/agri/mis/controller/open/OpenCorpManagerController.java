package com.agri.mis.controller.open;


import com.agri.mis.domain.CorpManager;
import com.agri.mis.dto.CorpManagerInfo;
import com.agri.mis.service.CorpManagerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
@RequestMapping("/open/corpManager")
public class OpenCorpManagerController {

    @Autowired
    private CorpManagerService corpManagerService;


    @GetMapping("/{id}")
    public Mono<CorpManager> find(@PathVariable Long id) {
        return corpManagerService.findById(id);
    }

    @GetMapping("/findAllByCorpId")
    public Flux<CorpManager> findAllByCorpId(@RequestParam("corpId") Long corpId) {
        return corpManagerService.findAllByCorpId(corpId);
    }

    @GetMapping("/findInfoByCorpId")
    public Flux<CorpManagerInfo> findInfoByCorpId(@RequestParam("corpId") Long corpId) {
        return corpManagerService.findAllInfoByCorpId(corpId);
    }

    @PostMapping("/add")
    public Mono<CorpManager> save( @RequestBody CorpManager corpManager) {
        return corpManagerService.add(corpManager);
    }

    @PutMapping("/{id}")
    public Mono<CorpManager> update(@PathVariable Long id, @RequestBody CorpManager corpManager) {
        return corpManagerService.update(id, corpManager);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable Long id) {
        return corpManagerService.findById(id)
                .flatMap(s ->
                        corpManagerService.delete(s)
                                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
