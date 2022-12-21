package com.agri.mis.repository;

import com.agri.mis.domain.MarkProductRisk;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface MarkProductRiskRepository extends ReactiveCrudRepository<MarkProductRisk,Long>, ReactiveQueryByExampleExecutor<MarkProductRisk> {
    Flux<MarkProductRisk> findBy(Example example, Pageable pageable);
}
