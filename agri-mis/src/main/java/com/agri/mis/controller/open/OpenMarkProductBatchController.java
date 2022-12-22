package com.agri.mis.controller.open;

import com.agri.mis.domain.MarkMarket;
import com.agri.mis.domain.MarkProductBatch;
import com.agri.mis.dto.MarkMarketWithCategoryWithAddress;
import com.agri.mis.dto.MarkProductBatchWithProductWithCreatedUser;
import com.agri.mis.service.MarkMarketService;
import com.agri.mis.service.MarkProductBatchService;
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
@RequestMapping("/open/mark/product/Batch")
public class OpenMarkProductBatchController {
    @Autowired
    private MarkProductBatchService service;

    @GetMapping("/{id}")
    public Mono<ResponseEntity<MarkProductBatch>> findById(@PathVariable Long id){
        return service.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/pageQuery")
    public Mono<Page<MarkProductBatchWithProductWithCreatedUser>> pageQuery(@RequestParam("name") String name, @RequestParam("page") int page, @RequestParam("size") int size){
        return service.pageQuery(name, PageRequest.of(page,size));
    }

    @PostMapping("/add")
    public Mono<MarkProductBatch> add(@RequestBody MarkProductBatch markMarket){
        return service.add(markMarket);
    }

    @PutMapping("/{id}")
    public Mono<MarkProductBatch> update(@PathVariable Long id,@RequestBody MarkProductBatch markMarket){
        return service.update(id,markMarket);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable Long id){
        return service.findById(id).flatMap(s->
                        service.delete(s).then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK))))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
