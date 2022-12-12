package com.agri.mis.repository;

import com.agri.mis.domain.Corp;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;

import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface CorpRepository extends ReactiveCrudRepository<Corp, Long>, ReactiveQueryByExampleExecutor<Corp> {
  Flux<Corp> findBy(Example corp, Pageable pageable);

   /* 按SQL语句去查查询
   @Query("select id, name, code, address_id, description, created_at from corp c where c.lastname = :name")
	Flux<Corp> findByName(String name);

    @Query("select * from corp where name = $1")
    Flux<Corp> findByName(String name);
   */
}
