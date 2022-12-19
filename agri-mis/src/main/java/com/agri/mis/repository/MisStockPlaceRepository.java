package com.agri.mis.repository;


import com.agri.mis.domain.MisStockPlace;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface MisStockPlaceRepository extends ReactiveCrudRepository<MisStockPlace,Long>, ReactiveQueryByExampleExecutor<MisStockPlace> {
    Flux<MisStockPlace>findBy(Example misstockplace, Pageable pageable);
}
