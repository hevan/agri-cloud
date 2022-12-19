package com.agri.mis.controller.open;


import com.agri.mis.domain.Address;
import com.agri.mis.service.AddressService;
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
@RequestMapping("/open/address")
public class OpenAddressController {

    @Autowired
    private AddressService addressService;


    @GetMapping("/{id}")
    public Mono<ResponseEntity<Address>> find(@PathVariable Long id) {
        return addressService.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/pageQuery")
    public Mono<Page<Address>> pageQuery(@RequestBody Address addr, @RequestParam("page") int page, @RequestParam("size") int size) {
        return addressService.pageQueryByExample(addr, PageRequest.of(page, size));
    }

    @PostMapping("/add")
    public Mono<Address> save( @RequestBody Address address) {
        return addressService.add(address);
    }

    @PutMapping("/{id}")
    public Mono<Address> update(@PathVariable Long id, @RequestBody Address address) {
        return addressService.update(id, address);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable Long id) {
        return addressService.findById(id)
                .flatMap(s ->
                        addressService.delete(s)
                                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
