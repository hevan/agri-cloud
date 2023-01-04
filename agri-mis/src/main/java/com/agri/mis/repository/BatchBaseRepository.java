package com.agri.mis.repository;

import com.agri.mis.domain.BatchBase;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface BatchBaseRepository extends ReactiveCrudRepository<BatchBase,Long>, ReactiveQueryByExampleExecutor<BatchBase> {
    Flux<BatchBase> findBy(Example batchBase, Pageable pageable);
}
