package com.agri.mis.repository;

import com.agri.mis.domain.PurchaseOrder;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PurchaseOrderRepository extends ReactiveCrudRepository<PurchaseOrder,Long>, ReactiveQueryByExampleExecutor<PurchaseOrder> {

}
