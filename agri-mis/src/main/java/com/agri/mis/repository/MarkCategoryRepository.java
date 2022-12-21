package com.agri.mis.repository;


import com.agri.mis.domain.MarkCategory;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface MarkCategoryRepository  extends ReactiveCrudRepository<MarkCategory, Long>, ReactiveQueryByExampleExecutor<MarkCategory> {
    Flux<MarkCategory> findBy(Example markCategory, Pageable pageable);//接口
}
