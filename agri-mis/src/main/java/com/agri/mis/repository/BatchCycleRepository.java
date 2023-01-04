package com.agri.mis.repository;

import com.agri.mis.domain.BatchCycle;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface BatchCycleRepository extends ReactiveCrudRepository<BatchCycle,Long>, ReactiveQueryByExampleExecutor<BatchCycle> {

    Flux<BatchCycle> findBy(Example batchCycl , Pageable pageable);
}
