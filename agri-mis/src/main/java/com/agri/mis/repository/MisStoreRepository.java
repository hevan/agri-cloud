package com.agri.mis.repository;

import com.agri.mis.domain.MisStore;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface MisStoreRepository extends ReactiveCrudRepository<MisStore,Long>, ReactiveQueryByExampleExecutor<MisStore> {
    Flux<MisStore> findBy(Example misstore , Pageable pageable);
}
