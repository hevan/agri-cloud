package com.agri.mis.repository;

import com.agri.mis.domain.MarkProduct;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface MarkProductRepository extends ReactiveCrudRepository<MarkProduct,Long>, ReactiveQueryByExampleExecutor<MarkProduct> {
    Flux<MarkProduct> findBy(Example example, Pageable pageable);//接口
}
