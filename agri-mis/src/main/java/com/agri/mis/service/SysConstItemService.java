package com.agri.mis.service;

import com.agri.mis.domain.SysConstItem;
import com.agri.mis.repository.SysConstItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SysConstItemService {

    @Autowired
    private SysConstItemRepository sysConstItemRepository;


    public Mono<SysConstItem> findById(Long id) {
      return sysConstItemRepository.findById(id);
    }

    public Flux<SysConstItem> findAllByConstId(Long constId) {
        return sysConstItemRepository.findAllByConstId(constId);
    }

    public Mono<SysConstItem> add(SysConstItem sysConstItem) {
        return sysConstItemRepository.save(sysConstItem);
    }

    public Mono<SysConstItem> update(Long id, SysConstItem sysConstItem) {
        return sysConstItemRepository.findById(id)
                .flatMap(s -> {
                    sysConstItem.setId(s.getId());
                    return sysConstItemRepository.save(sysConstItem);
                });
    }

    public Mono<Void> delete(SysConstItem sysConstItem) {
        return sysConstItemRepository.delete(sysConstItem);
    }
}
