package com.agri.mis.controller.secure;

import com.agri.mis.domain.Customer;
import com.agri.mis.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/secure/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Customer>> getCustomer(@PathVariable long id) {
        return customerService.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/pageQuery")
    public Mono<Page<Customer>> pageQuery( @RequestParam("name") String name, @RequestParam("corpId") Long corpId, @RequestParam("page") int page, @RequestParam("size") int size) {
        return customerService.pageQuery(name, corpId, PageRequest.of(page, size));
    }

    @PostMapping
    public Mono<Customer> add(@RequestBody Customer sysMenu) {
        return customerService.add(sysMenu);
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<Customer>> update(@PathVariable Long id, @RequestBody Customer sysMenu) {
        return customerService.update(id, sysMenu)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable Long id) {
        return customerService.findById(id)
                .flatMap(s ->
                        customerService.delete(s)
                                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
