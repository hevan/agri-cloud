package com.agri.mis.repository;


import com.agri.mis.domain.CheckTrace;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface CheckTraceRepository extends ReactiveCrudRepository<CheckTrace, Long> {
    Flux<CheckTrace> findAllByEntityIdAndEntityNameAndStatus(Long entityId, String entityName, Integer status);
}
