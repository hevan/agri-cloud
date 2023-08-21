package com.agri.mis.repository;

import com.agri.mis.domain.BatchTeam;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BatchTeamRepository extends ReactiveCrudRepository<BatchTeam,Long>, ReactiveQueryByExampleExecutor<BatchTeam> {
    Flux<BatchTeam> findBy(Example batchTeam, Pageable pageable);

    Flux<BatchTeam> findAllByBatchId(Long batchId);

    Mono<BatchTeam> findByBatchIdAndUserId(Long batchId, Long userId);
}
