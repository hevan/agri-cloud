package com.agri.mis.repository;

import com.agri.mis.domain.BatchCycle;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BatchCycleRepository extends ReactiveCrudRepository<BatchCycle,Long>, ReactiveQueryByExampleExecutor<BatchCycle> {

    Flux<BatchCycle> findBy(Example batchCycle , Pageable pageable);
    Flux<BatchCycle> findAllByBatchId(Long batchId);
    Flux<BatchCycle> findAllByParentId(Long parentId);
    Mono<Void> deleteAllByParentId(Long parentId);

}
