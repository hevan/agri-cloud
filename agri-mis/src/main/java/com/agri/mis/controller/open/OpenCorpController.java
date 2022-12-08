package com.agri.mis.controller.open;


import com.agri.mis.domain.Corp;
import com.agri.mis.service.CorpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
@RequestMapping("/open/corp")
public class OpenCorpController {

    @Autowired
    private CorpService corpService;


    @GetMapping("/{id}")
    public Mono<ResponseEntity<Corp>> find(@PathVariable Long id) {
        return corpService.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/pageQuery")
    public Mono<Page<Corp>> pageQuery(@RequestParam("name") String name, @RequestParam("page") int page, @RequestParam("size") int size) {
        return corpService.pageQuery(name, PageRequest.of(page, size));
    }

    @PutMapping("/{id}")
    public Mono<Corp> update(@PathVariable Long id, @RequestBody Corp corp) {
        return corpService.update(id, corp);
    }
}
