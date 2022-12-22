package com.agri.mis.repository;


import com.agri.mis.domain.CheckTemp;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface CheckTempRepository extends ReactiveCrudRepository<CheckTemp, Long> {
    Flux<CheckTemp> findAllByCorpId(Long corpId);
}
