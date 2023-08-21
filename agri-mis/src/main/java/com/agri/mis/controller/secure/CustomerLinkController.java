package com.agri.mis.controller.secure;

import com.agri.mis.domain.CustomerLink;
import com.agri.mis.service.CustomerLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/secure/customerLink")
public class CustomerLinkController {

    @Autowired
    private CustomerLinkService customerLinkService;

    @GetMapping("/{id}")
    public Mono<ResponseEntity<CustomerLink>> getCustomer(@PathVariable long id) {
        return customerLinkService.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/findAllByCustomerId")
    public Flux<CustomerLink> findAllByCustomerId(Long customerId) {
        return customerLinkService.findAllByCustomerId(customerId);
    }

    @PostMapping
    public Mono<CustomerLink> add(@RequestBody CustomerLink customerLink) {
        return customerLinkService.add(customerLink);
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<CustomerLink>> update(@PathVariable Long id, @RequestBody CustomerLink customerLink) {
        return customerLinkService.update(id, customerLink)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable Long id) {
        return customerLinkService.findById(id)
                .flatMap(s ->
                        customerLinkService.delete(s)
                                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
