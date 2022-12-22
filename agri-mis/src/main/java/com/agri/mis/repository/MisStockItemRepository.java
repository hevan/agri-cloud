package com.agri.mis.repository;

import com.agri.mis.domain.MisStockItem;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface MisStockItemRepository extends ReactiveCrudRepository<MisStockItem,Long>, ReactiveQueryByExampleExecutor<MisStockItem> {

    Flux<MisStockItem>findBy(Example misstockitem, Pageable pageable);

}
