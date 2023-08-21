package com.agri.mis.controller.secure;

import com.agri.mis.domain.CustomerTrace;
import com.agri.mis.service.CustomerTraceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/secure/customerTrace")
public class CustomerTraceController {

    @Autowired
    private CustomerTraceService customerTraceService;

    @GetMapping("/{id}")
    public Mono<ResponseEntity<CustomerTrace>> findById(@PathVariable long id) {
        return customerTraceService.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/findAllByCustomerId")
    public Flux<CustomerTrace> findAllByCustomerId(Long customerId) {
        return customerTraceService.findAllByCustomerId(customerId);
    }

    @PostMapping
    public Mono<CustomerTrace> add(@RequestBody CustomerTrace customerTrace) {
        return customerTraceService.add(customerTrace);
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<CustomerTrace>> update(@PathVariable Long id, @RequestBody CustomerTrace customerTrace) {
        return customerTraceService.update(id, customerTrace)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable Long id) {
        return customerTraceService.findById(id)
                .flatMap(s ->
                        customerTraceService.delete(s)
                                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
