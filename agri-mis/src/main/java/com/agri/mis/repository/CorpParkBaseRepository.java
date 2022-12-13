package com.agri.mis.repository;


import com.agri.mis.domain.CorpParkBase;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface CorpParkBaseRepository extends ReactiveCrudRepository<CorpParkBase, Long> {
    Flux<CorpParkBase> findAllByParkId(Long parkId);
}
