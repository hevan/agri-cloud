package com.agri.mis.repository;


import com.agri.mis.domain.CorpManagerDepart;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CorpManagerDepartRepository extends ReactiveCrudRepository<CorpManagerDepart, Long> {
    Flux<CorpManagerDepart> findAllByManagerId(Long managerId);
    Mono<Void> deleteAllByManagerId(Long managerId);
}

