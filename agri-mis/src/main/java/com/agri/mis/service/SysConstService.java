package com.agri.mis.service;

import com.agri.mis.domain.SysConst;
import com.agri.mis.domain.SysConstItem;
import com.agri.mis.repository.SysConstItemRepository;
import com.agri.mis.repository.SysConstRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class SysConstService {

    @Autowired
    private SysConstRepository sysConstRepository;
    @Autowired
    private SysConstItemRepository sysConstItemRepository;

    public Mono<Object> findById(Long id) {

        return sysConstRepository.findById(id).zipWith(Mono.from(sysConstItemRepository.findAllByConstId(id))).map(
                t -> {
                    t.getT1().setListItem((List<SysConstItem>) t.getT2());
                    return t;
                }
        );
    }

    public Flux<SysConst> findAllByCorpId(Long corpId) {
        return sysConstRepository.findAllByCorpId(corpId);
    }

    public Mono<SysConst> add(SysConst sysConst) {
        return sysConstRepository.save(sysConst);
    }

    public Mono<SysConst> update(Long id, SysConst sysConst) {
        return sysConstRepository.findById(id)
                .flatMap(s -> {
                    sysConst.setId(s.getId());
                    return sysConstRepository.save(sysConst);
                });
    }

    public Mono<Void> delete(SysConst sysConst) {
        return sysConstRepository.delete(sysConst);
    }
}
