package com.agri.mis.repository;

import com.agri.mis.domain.BatchCycleInvest;
import com.agri.mis.domain.BatchRisk;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface BatchCycleInvestRepository extends ReactiveCrudRepository<BatchCycleInvest,Long>, ReactiveQueryByExampleExecutor<BatchCycleInvest> {
}
