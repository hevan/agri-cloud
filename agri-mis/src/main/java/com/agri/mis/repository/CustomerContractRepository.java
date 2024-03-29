package com.agri.mis.repository;


import com.agri.mis.domain.CustomerContract;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;


public interface CustomerContractRepository extends ReactiveCrudRepository<CustomerContract, Long>, ReactiveQueryByExampleExecutor<CustomerContract> {
  Flux<CustomerContract> findAllByCustomerId(Long customerId);
}
