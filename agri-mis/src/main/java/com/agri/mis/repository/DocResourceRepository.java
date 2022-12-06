package com.agri.mis.repository;


import com.agri.mis.domain.DocResource;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface DocResourceRepository extends ReactiveCrudRepository<DocResource, Long> {
     Flux<DocResource> findAllByEntityIdAndEntityName(Long entityId, String entityName);
}
