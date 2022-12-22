package com.agri.mis.service;

import com.agri.mis.domain.CustomerTrace;
import com.agri.mis.repository.CustomerTraceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerTraceService {

    @Autowired
    private CustomerTraceRepository customerTraceRepository;


    public Mono<CustomerTrace> findById(Long id) {

      return customerTraceRepository.findById(id);
    }


    public Flux<CustomerTrace> findAllByCustomerId(Long customerId) {
        return customerTraceRepository.findAllByCustomerId(customerId);
    }

    public Mono<CustomerTrace> add(CustomerTrace customerTrace) {
        return customerTraceRepository.save(customerTrace);
    }

    public Mono<CustomerTrace> update(Long id, CustomerTrace customerTrace) {
        return customerTraceRepository.findById(id)
                .flatMap(s -> {
                    customerTrace.setId(s.getId());
                    return customerTraceRepository.save(customerTrace);
                });
    }

    public Mono<Void> delete(CustomerTrace customerTrace) {
        return customerTraceRepository.delete(customerTrace);
    }
}
