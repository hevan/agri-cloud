package com.agri.mis.repository;


import com.agri.mis.domain.CorpRole;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface CorpRoleRepository extends ReactiveCrudRepository<CorpRole, Long> {
    Flux<CorpRole> findAllByCorpId(Long corpId);
}
