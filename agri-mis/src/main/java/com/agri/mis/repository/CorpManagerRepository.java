package com.agri.mis.repository;


import com.agri.mis.domain.CorpManager;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface CorpManagerRepository extends ReactiveCrudRepository<CorpManager, Long> {
    Flux<CorpManager> findAllByCorpId(Long corpId);
}
