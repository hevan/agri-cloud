package com.agri.mis.repository;

import com.agri.mis.domain.MarkProductMarket;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface MarkProductMarketRepository extends ReactiveCrudRepository<MarkProductMarket,Long>, ReactiveQueryByExampleExecutor<MarkProductMarket> {
    Flux<MarkProductMarket> findBy(Example example, Pageable pageable);
}
