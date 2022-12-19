package com.agri.mis.repository;


import com.agri.mis.domain.Address;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;


public interface AddressRepository extends ReactiveCrudRepository<Address, Long>, ReactiveQueryByExampleExecutor<Address> {
  Flux<Address> findBy(Example address, Pageable pageable);
}
