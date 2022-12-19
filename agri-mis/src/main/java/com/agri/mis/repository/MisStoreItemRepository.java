package com.agri.mis.repository;

import com.agri.mis.domain.MisStoreItem;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface MisStoreItemRepository extends ReactiveCrudRepository<MisStoreItem,Long>, ReactiveQueryByExampleExecutor<MisStoreItem> {
    Flux<MisStoreItem> findBy(Example misstoreitem , Pageable pageable);
}
