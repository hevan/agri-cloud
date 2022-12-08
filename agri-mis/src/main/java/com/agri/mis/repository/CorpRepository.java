package com.agri.mis.repository;

import com.agri.mis.domain.Corp;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface CorpRepository extends ReactiveCrudRepository<Corp, Long>, ReactiveQueryByExampleExecutor<Corp> {
  Flux<Corp> findAllBy(Example corp, Pageable pageable);
}
