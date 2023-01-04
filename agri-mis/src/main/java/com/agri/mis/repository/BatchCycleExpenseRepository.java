package com.agri.mis.repository;

import com.agri.mis.domain.BatchCycleExpense;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface BatchCycleExpenseRepository extends ReactiveCrudRepository<BatchCycleExpense,Long>, ReactiveQueryByExampleExecutor<BatchCycleExpense> {
    Flux<BatchCycleExpense> findBy(Example batchCycleExpense, Pageable pageable);
}
