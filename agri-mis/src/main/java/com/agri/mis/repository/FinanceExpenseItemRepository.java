package com.agri.mis.repository;

import com.agri.mis.domain.FinanceExpenseItem;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface FinanceExpenseItemRepository extends ReactiveCrudRepository<FinanceExpenseItem,Long>, ReactiveQueryByExampleExecutor<FinanceExpenseItem> {
    Flux<FinanceExpenseItem> findBy(Example financeExpenseItem, Pageable pageable);
}
