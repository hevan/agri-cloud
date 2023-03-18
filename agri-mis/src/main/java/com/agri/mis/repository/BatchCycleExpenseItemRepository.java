package com.agri.mis.repository;

import com.agri.mis.domain.BatchCycleExpenseItem;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface BatchCycleExpenseItemRepository extends ReactiveCrudRepository<BatchCycleExpenseItem,Long>, ReactiveQueryByExampleExecutor<BatchCycleExpenseItem> {
    Flux<BatchCycleExpenseItem> findBy(Example batchCycleExpenseItem, Pageable pageable);
}
