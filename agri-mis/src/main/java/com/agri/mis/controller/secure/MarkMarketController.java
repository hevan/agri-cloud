package com.agri.mis.controller.secure;

import com.agri.mis.domain.MarkMarket;
import com.agri.mis.service.MarkMarketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
@RequestMapping("/secure/mark/market")
public class MarkMarketController {

    @Autowired
    private MarkMarketService service;

    @GetMapping("/{id}")
    public Mono<ResponseEntity<MarkMarket>> findById(@PathVariable Long id){
        return service.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/pageQuery")
    public Mono<Page<MarkMarket>> pageQuery(MarkMarket markMarket, @RequestParam("page") int page, @RequestParam("size") int size){
        return service.pageQuery(markMarket, PageRequest.of(page,size));
    }

    @PostMapping
    public Mono<MarkMarket> add(@RequestBody MarkMarket markMarket){
        return service.add(markMarket);
    }

    @PutMapping("/{id}")
    public Mono<MarkMarket> update(@PathVariable Long id,@RequestBody MarkMarket markMarket){
        return service.update(id,markMarket);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable Long id){
        return service.findById(id).flatMap(s->
            service.dalete(s).then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK))))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
