package com.agri.mis.repository;


import com.agri.mis.domain.Product;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;


public interface ProductRepository extends ReactiveCrudRepository<Product, Long>, ReactiveQueryByExampleExecutor<Product> {
    Flux<Product> findAllByCorpId(Long corpId);
    Flux<Product> findBy(Example product, Pageable pageable);


}
