package com.agri.mis.repository;


import com.agri.mis.domain.CheckTempItem;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface CheckTempItemRepository extends ReactiveCrudRepository<CheckTempItem, Long> {
    Flux<CheckTempItem> findAllByCheckTempId(Long checkTempItem);
}
