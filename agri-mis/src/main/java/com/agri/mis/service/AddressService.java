package com.agri.mis.service;

import com.agri.mis.domain.Address;
import com.agri.mis.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;


    public Mono<Address> findById(Long id) {
      return addressRepository.findById(id);
    }


    public Mono<Address> add(Address address) {


        return addressRepository.save(address);
    }

    public Mono<Address> update(Long id, Address address) {
        return addressRepository.findById(id)
                .flatMap(s -> {
                    address.setId(s.getId());
                    return addressRepository.save(address);
                });
    }

    public Mono<Void> delete(Address address) {
        return addressRepository.delete(address);
    }

    public Mono<Page<Address>> pageQueryByExample(Address addr, PageRequest pageRequest){

        ExampleMatcher exampleObjectMatcher = ExampleMatcher.matching()
                .withMatcher("link_name", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("link_mobile", ExampleMatcher.GenericPropertyMatchers.contains());


        return this.addressRepository.findBy(Example.of(addr, exampleObjectMatcher), pageRequest).collectList()
                .zipWith(this.addressRepository.count(Example.of(addr, exampleObjectMatcher)))
                .map(t -> new PageImpl<>(t.getT1(), pageRequest, t.getT2()));


    }
}
