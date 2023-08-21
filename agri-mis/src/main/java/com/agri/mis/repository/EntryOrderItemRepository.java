package com.agri.mis.repository;

import com.agri.mis.domain.EntryOrderItem;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface EntryOrderItemRepository extends ReactiveCrudRepository<EntryOrderItem,Long>, ReactiveQueryByExampleExecutor<EntryOrderItem> {
    Flux<EntryOrderItem> findBy(Example entryOrderItem, Pageable pageable);
}
