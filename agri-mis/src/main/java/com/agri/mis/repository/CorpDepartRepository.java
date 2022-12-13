package com.agri.mis.repository;


import com.agri.mis.domain.CorpDepart;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface CorpDepartRepository extends ReactiveCrudRepository<CorpDepart, Long> {
    Flux<CorpDepart> findAllByCorpId(Long corpId);
}
