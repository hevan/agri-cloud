package com.agri.mis.repository;

import com.agri.mis.domain.SaleOrder;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface SaleOrderRepository extends ReactiveCrudRepository<SaleOrder,Long>, ReactiveQueryByExampleExecutor<SaleOrder> {
    Flux<SaleOrder> findBy(Example saleOrder, Pageable pageable);
}
