package com.agri.mis.repository;


import com.agri.mis.domain.CustomerTrace;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;


public interface CustomerTraceRepository extends ReactiveCrudRepository<CustomerTrace, Long>, ReactiveQueryByExampleExecutor<CustomerTrace> {
  Flux<CustomerTrace> findAllByCustomerId(Long customerId);
}
