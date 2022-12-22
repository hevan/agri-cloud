package com.agri.mis.controller.open;


import com.agri.mis.domain.CheckTempItem;
import com.agri.mis.service.CheckTempItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
@RequestMapping("/open/checkTempItem")
public class OpenCheckTempItemController {

    @Autowired
    private CheckTempItemService checkTempItemService;


    @GetMapping("/{id}")
    public Mono<ResponseEntity<CheckTempItem>> find(@PathVariable Long id) {
        return checkTempItemService.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }


    @PostMapping("/add")
    public Mono<CheckTempItem> save( @RequestBody CheckTempItem checkTempItem) {
        return checkTempItemService.add(checkTempItem);
    }

    @PutMapping("/{id}")
    public Mono<CheckTempItem> update(@PathVariable Long id, @RequestBody CheckTempItem checkTempItem) {
        return checkTempItemService.update(id, checkTempItem);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable Long id) {
        return checkTempItemService.findById(id)
                .flatMap(s ->
                        checkTempItemService.delete(s)
                                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
