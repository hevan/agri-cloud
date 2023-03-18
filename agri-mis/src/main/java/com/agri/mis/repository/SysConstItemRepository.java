package com.agri.mis.repository;


import com.agri.mis.domain.SysConstItem;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface SysConstItemRepository extends ReactiveCrudRepository<SysConstItem, Long> {

    Flux<SysConstItem> findAllByConstId(Long constId);
}
