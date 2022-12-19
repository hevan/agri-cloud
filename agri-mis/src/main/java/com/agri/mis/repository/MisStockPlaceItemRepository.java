package com.agri.mis.repository;

import com.agri.mis.domain.MisStockPlaceItem;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface MisStockPlaceItemRepository extends ReactiveCrudRepository<MisStockPlaceItem,Long>, ReactiveQueryByExampleExecutor<MisStockPlaceItem> {
    Flux<MisStockPlaceItem>findBy(Example misstockplaceitem, Pageable pageable);

}
