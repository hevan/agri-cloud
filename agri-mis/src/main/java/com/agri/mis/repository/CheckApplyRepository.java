package com.agri.mis.repository;


import com.agri.mis.domain.CheckApply;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface CheckApplyRepository extends ReactiveCrudRepository<CheckApply, Long> {
    Mono<CheckApply> findByEntityIdAndEntityName(Long entityId, String entityName);
}
