package com.agri.mis.repository;

import com.agri.mis.domain.MarkProductCycle;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface MarkProductCycleRepository extends ReactiveCrudRepository<MarkProductCycle,Long>, ReactiveQueryByExampleExecutor<MarkProductCycle> {
    Flux<MarkProductCycle> findBy(Example example, Pageable pageable);//接口
}
