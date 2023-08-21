package com.agri.mis.controller.secure;

import com.agri.mis.domain.CustomerContract;
import com.agri.mis.service.CustomerContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/secure/customerContract")
public class CustomerContractController {

    @Autowired
    private CustomerContractService customerContractService;

    @GetMapping("/{id}")
    public Mono<ResponseEntity<CustomerContract>> findById(@PathVariable long id) {
        return customerContractService.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/findAllByCustomerId")
    public Flux<CustomerContract> findAllByCustomerId(Long customerId) {
        return customerContractService.findAllByCustomerId(customerId);
    }

    @GetMapping("/pageQuery")
    public Mono<Page<CustomerContract>> pageQuery(CustomerContract customerContract, @RequestParam("page") int page, @RequestParam("size") int size) {
        return customerContractService.pageQuery(customerContract, PageRequest.of(page, size));
    }

    @PostMapping
    public Mono<CustomerContract> add(@RequestBody CustomerContract customerContract) {
        return customerContractService.add(customerContract);
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<CustomerContract>> update(@PathVariable Long id, @RequestBody CustomerContract customerContract) {
        return customerContractService.update(id, customerContract)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable Long id) {
        return customerContractService.findById(id)
                .flatMap(s ->
                        customerContractService.delete(s)
                                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
