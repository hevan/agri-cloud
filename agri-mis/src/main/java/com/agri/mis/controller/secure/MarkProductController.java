package com.agri.mis.controller.secure;


import com.agri.mis.domain.MarkProduct;
import com.agri.mis.service.MarkProductService;
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
@RequestMapping("/secure/mark/product")
public class MarkProductController {
    @Autowired
    private MarkProductService service;

    @GetMapping("/{id}")
    public Mono<ResponseEntity<MarkProduct>> findById(@PathVariable Long id){
        return service.findById(id).map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/pageQuery")
    public Mono<Page<MarkProduct>> pageQuery(MarkProduct markProduct, int page, int size){
        return service.pageQuery(markProduct, PageRequest.of(page,size));
    }

    @PostMapping
    public Mono<MarkProduct> add(@RequestBody MarkProduct markProduct){
        return service.add(markProduct);
    }

    @PutMapping("/{id}")
    public Mono<MarkProduct> update(@PathVariable Long id,@RequestBody MarkProduct markMarket){
        return service.update(id,markMarket);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable Long id){
        return service.findById(id).flatMap(s->
                        service.delete(s).then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK))))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
