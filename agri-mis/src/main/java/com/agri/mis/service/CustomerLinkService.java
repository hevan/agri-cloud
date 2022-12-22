package com.agri.mis.service;

import com.agri.mis.domain.CustomerLink;
import com.agri.mis.repository.CustomerLinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerLinkService {

    @Autowired
    private CustomerLinkRepository customerLinkRepository;


    public Mono<CustomerLink> findById(Long id) {

      return customerLinkRepository.findById(id);
    }


    public Flux<CustomerLink> findAllByCustomerId(Long customerId) {
        return customerLinkRepository.findAllByCustomerId(customerId);
    }

    public Mono<CustomerLink> add(CustomerLink customerLink) {
        return customerLinkRepository.save(customerLink);
    }

    public Mono<CustomerLink> update(Long id, CustomerLink customerLink) {
        return customerLinkRepository.findById(id)
                .flatMap(s -> {
                    customerLink.setId(s.getId());
                    return customerLinkRepository.save(customerLink);
                });
    }

    public Mono<Void> delete(CustomerLink customerLink) {
        return customerLinkRepository.delete(customerLink);
    }
}
