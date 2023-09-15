package com.agri.mis.repository;

import com.agri.mis.domain.ProductionOrderItem;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ProductionOrderItemRepository extends ReactiveCrudRepository<ProductionOrderItem,Long>, ReactiveQueryByExampleExecutor<ProductionOrderItem> {

}
