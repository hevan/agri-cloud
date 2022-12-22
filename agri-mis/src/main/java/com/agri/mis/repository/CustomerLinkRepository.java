package com.agri.mis.repository;


import com.agri.mis.domain.CustomerLink;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;


public interface CustomerLinkRepository extends ReactiveCrudRepository<CustomerLink, Long>, ReactiveQueryByExampleExecutor<CustomerLink> {
  Flux<CustomerLink> findAllByCustomerId(Long customerId);
}
