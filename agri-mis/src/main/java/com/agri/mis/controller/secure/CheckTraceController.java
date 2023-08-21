package com.agri.mis.controller.secure;


import com.agri.mis.domain.CheckTrace;
import com.agri.mis.service.CheckTraceService;
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
@RequestMapping("/secure/checkTrace")
public class CheckTraceController {

    @Autowired
    private CheckTraceService checkTraceService;


    @GetMapping("/{id}")
    public Mono<ResponseEntity<CheckTrace>> find(@PathVariable Long id) {
        return checkTraceService.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/pageQuery")
    public Mono<Page<CheckTrace>> pageQuery(CheckTrace checkTrace, @RequestParam("page") int page, @RequestParam("size") int size) {
        return checkTraceService.pageQuery(checkTrace, PageRequest.of(page, size));
    }

    @PostMapping
    public Mono<CheckTrace> save(@RequestBody CheckTrace checkTrace) {
        return checkTraceService.add(checkTrace);
    }

    @PostMapping("/updateStatus")
    public Mono<String> updateStatus(@RequestParam("id")  Long id, @RequestParam("status") Integer status) {
        log.info("status" + status);

        if(null != status  && status == 1){
            return checkTraceService.updateStatusSuccess(id,status);
        }else {
            return checkTraceService.updateStatusFaile(id,status);
        }
     }

    @PutMapping("/{id}")
    public Mono<CheckTrace> update(@PathVariable Long id, @RequestBody CheckTrace checkTrace) {
        return checkTraceService.update(id, checkTrace);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable Long id) {
        return checkTraceService.findById(id)
                .flatMap(s ->
                        checkTraceService.delete(s)
                                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
