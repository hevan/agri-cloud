package com.agri.mis.repository;

import com.agri.mis.domain.PurchaseOrderItem;
import com.agri.mis.domain.SaleOrderItem;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface PurchaseOrderItemRepository extends ReactiveCrudRepository<PurchaseOrderItem,Long>, ReactiveQueryByExampleExecutor<PurchaseOrderItem> {

}
