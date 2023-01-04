package com.agri.mis.repository;

import com.agri.mis.domain.BatchProduct;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.awt.print.Pageable;

public interface BatchProductRepository extends ReactiveCrudRepository<BatchProduct,Long>, ReactiveQueryByExampleExecutor<BatchProduct> {
    Flux<BatchProduct>findBy(Exception batchProduct, Pageable pageable);
}
