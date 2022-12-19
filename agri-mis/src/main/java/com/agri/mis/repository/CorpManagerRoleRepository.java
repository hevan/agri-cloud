package com.agri.mis.repository;


import com.agri.mis.domain.CorpManagerRole;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface CorpManagerRoleRepository extends ReactiveCrudRepository<CorpManagerRole, Long> {
    Flux<CorpManagerRole> findAllByManagerId(Long managerId);
}

