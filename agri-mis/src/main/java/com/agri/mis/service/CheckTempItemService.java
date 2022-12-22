package com.agri.mis.service;

import com.agri.mis.domain.CheckTempItem;
import com.agri.mis.repository.CheckTempItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CheckTempItemService {

    @Autowired
    private CheckTempItemRepository checkTempItemRepository;


    public Mono<CheckTempItem> findById(Long id) {

      return checkTempItemRepository.findById(id);
    }


    public Flux<CheckTempItem> findAllByCheckTempId(Long checkTempId) {
        return checkTempItemRepository.findAllByCheckTempId(checkTempId);
    }

    public Mono<CheckTempItem> add(CheckTempItem checkTempItem) {
        return checkTempItemRepository.save(checkTempItem);
    }

    public Mono<CheckTempItem> update(Long id, CheckTempItem checkTempItem) {
        return checkTempItemRepository.findById(id)
                .flatMap(s -> {
                    checkTempItem.setId(s.getId());
                    return checkTempItemRepository.save(checkTempItem);
                });
    }

    public Mono<Void> delete(CheckTempItem checkTempItem) {
        return checkTempItemRepository.delete(checkTempItem);
    }
}
