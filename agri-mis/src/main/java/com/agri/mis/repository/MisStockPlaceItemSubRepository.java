package com.agri.mis.repository;


import com.agri.mis.domain.MisStockPlaceItemSub;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface MisStockPlaceItemSubRepository extends ReactiveCrudRepository<MisStockPlaceItemSub,Long>, ReactiveQueryByExampleExecutor<MisStockPlaceItemSub> {
    Flux <MisStockPlaceItemSub>findBy(Example misstockplaceitemsub, Pageable pageable);

}
