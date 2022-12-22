package com.agri.mis.repository;

import com.agri.mis.domain.MisStock;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface MisStockRepository extends ReactiveCrudRepository<MisStock,Long> , ReactiveQueryByExampleExecutor<MisStock> {

    Flux<MisStock>findBy(Example misstock, Pageable pageable);
}
