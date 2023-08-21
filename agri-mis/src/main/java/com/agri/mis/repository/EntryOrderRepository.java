package com.agri.mis.repository;

import com.agri.mis.domain.EntryOrder;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface EntryOrderRepository extends ReactiveCrudRepository<EntryOrder,Long>, ReactiveQueryByExampleExecutor<EntryOrder> {
    Flux<EntryOrder> findBy(Example entryOrder, Pageable pageable);

    Flux<EntryOrder> findAllByBatchId(Long batchId);
}
