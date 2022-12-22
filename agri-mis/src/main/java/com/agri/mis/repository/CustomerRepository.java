package com.agri.mis.repository;

import com.agri.mis.domain.Corp;
import com.agri.mis.domain.Customer;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CustomerRepository extends ReactiveCrudRepository<Customer, Long>, ReactiveQueryByExampleExecutor<Corp> {

}
