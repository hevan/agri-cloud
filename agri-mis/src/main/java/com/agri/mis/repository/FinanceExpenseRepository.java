package com.agri.mis.repository;

import com.agri.mis.domain.FinanceExpense;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface FinanceExpenseRepository extends ReactiveCrudRepository<FinanceExpense,Long>, ReactiveQueryByExampleExecutor<FinanceExpense> {
    Flux<FinanceExpense> findBy(Example financeExpense, Pageable pageable);

    Flux<FinanceExpense> findAllByBatchId(Long batchId);
}
