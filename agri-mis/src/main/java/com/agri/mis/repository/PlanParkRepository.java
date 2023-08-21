package com.agri.mis.repository;

import com.agri.mis.domain.PlanPark;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface PlanParkRepository extends ReactiveCrudRepository<PlanPark,Long>, ReactiveQueryByExampleExecutor<PlanPark> {
   Flux<PlanPark> findAllByCounty(String county);
}
