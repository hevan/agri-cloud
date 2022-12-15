package com.agri.mis.repository;


import com.agri.mis.domain.CorpRoleMenu;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface CorpRoleMenuRepository extends ReactiveCrudRepository<CorpRoleMenu, Long> {
    Flux<CorpRoleMenu> findAllByRoleId(Long roleId);
}
