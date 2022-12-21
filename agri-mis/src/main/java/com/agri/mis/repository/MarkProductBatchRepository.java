package com.agri.mis.repository;

import com.agri.mis.domain.MarkProductBatch;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface MarkProductBatchRepository extends ReactiveCrudRepository<MarkProductBatch,Long>, ReactiveQueryByExampleExecutor<MarkProductBatch> {
    Flux<MarkProductBatch> findBy(Example example, Pageable pageable);
}
