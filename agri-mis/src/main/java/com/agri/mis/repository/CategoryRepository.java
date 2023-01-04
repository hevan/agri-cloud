package com.agri.mis.repository;

import com.agri.mis.domain.Address;
import com.agri.mis.domain.Category;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface CategoryRepository extends ReactiveCrudRepository<Category, Long>, ReactiveQueryByExampleExecutor<Category> {
    Flux<Category> findAllByCorpId(Long id);
}
