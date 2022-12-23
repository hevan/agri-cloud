package com.agri.mis.repository;


import com.agri.mis.domain.CmsBlog;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;


public interface CmsBlogRepository extends ReactiveCrudRepository<CmsBlog, Long>, ReactiveQueryByExampleExecutor<CmsBlog> {
  Flux<CmsBlog> findBy(Example cmsBlog, Pageable pageable);
}
