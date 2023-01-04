package com.agri.mis.repository;

import com.agri.mis.domain.BatchRisk;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface BatchRiskRepository extends ReactiveCrudRepository<BatchRisk,Long>, ReactiveQueryByExampleExecutor<BatchRisk> {
    Flux<BatchRisk> findBy(Example batchRisk, Pageable pageable);
}
