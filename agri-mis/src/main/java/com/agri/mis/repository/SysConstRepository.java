package com.agri.mis.repository;


import com.agri.mis.domain.SysConst;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface SysConstRepository extends ReactiveCrudRepository<SysConst, Long> {

    Flux<SysConst> findAllByCorpId(Long corpId);
}
