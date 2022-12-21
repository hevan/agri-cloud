package com.agri.mis.repository;

import com.agri.mis.domain.MarkMarket;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface MarkMarketRepository extends ReactiveCrudRepository<MarkMarket,Long>, ReactiveQueryByExampleExecutor<MarkMarket> {
    Flux<MarkMarket> findBy(Example markMarket, Pageable pageable);//接口
}
