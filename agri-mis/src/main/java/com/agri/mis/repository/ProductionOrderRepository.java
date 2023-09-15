package com.agri.mis.repository;

import com.agri.mis.domain.ProductionOrder;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ProductionOrderRepository extends ReactiveCrudRepository<ProductionOrder,Long>, ReactiveQueryByExampleExecutor<ProductionOrder> {

}
