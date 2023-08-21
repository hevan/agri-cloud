package com.agri.mis.repository;


import com.agri.mis.domain.SysMenu;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface SysMenuRepository extends ReactiveCrudRepository<SysMenu, Long> {
    Flux<SysMenu> findAllByCorpIdOrderByParentIdDesc(Long corpId);

    Flux<SysMenu> findAllByCorpIdOrderByName(Long corpId);

    Flux<SysMenu> findAllByCorpId(Long corpId);

}
