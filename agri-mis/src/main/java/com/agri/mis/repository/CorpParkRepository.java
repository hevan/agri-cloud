package com.agri.mis.repository;


import com.agri.mis.domain.CorpPark;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface CorpParkRepository extends ReactiveCrudRepository<CorpPark, Long> {
    Flux<CorpPark> findAllByCorpId(Long corpId);
}
