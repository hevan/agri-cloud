package com.agri.mis.repository;


import com.agri.mis.domain.City;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface CityRepository extends ReactiveCrudRepository<City, Long>, ReactiveQueryByExampleExecutor<City> {

    Flux<City> findAllByCodeLikeOrderByCode(String code);

    Mono<City> findByName(String name);
}
