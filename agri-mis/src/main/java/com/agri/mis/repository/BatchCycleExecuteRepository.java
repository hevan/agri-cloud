package com.agri.mis.repository;

import com.agri.mis.domain.BatchCycleExecute;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface BatchCycleExecuteRepository extends ReactiveCrudRepository<BatchCycleExecute,Long>, ReactiveQueryByExampleExecutor<BatchCycleExecute> {
    Flux<BatchCycleExecute> findBy(Example batchCycleExecute, Pageable pageable);
}
