package com.agri.mis.service;

import com.agri.mis.domain.SysMenu;
import com.agri.mis.repository.SysMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SysMenuService {

    @Autowired
    private SysMenuRepository sysMenuRepository;


    public Mono<SysMenu> findById(Long id) {
      return sysMenuRepository.findById(id);
    }


    public Flux<SysMenu> findAllByCorpId(Long corpId) {
        return sysMenuRepository.findAllByCorpIdOrderByParentIdDesc(corpId);
    }

    public Flux<SysMenu> findAllByCorpIdAndSub(Long corpId) {
        return sysMenuRepository.findAllByCorpIdOrderByName(corpId);
    }

    public Mono<SysMenu> add(SysMenu sysMenu) {
        return sysMenuRepository.save(sysMenu);
    }

    public Mono<SysMenu> update(Long id, SysMenu sysMenu) {
        return sysMenuRepository.findById(id)
                .flatMap(s -> {
                    sysMenu.setId(s.getId());
                    return sysMenuRepository.save(sysMenu);
                });
    }

    public Mono<Void> delete(SysMenu sysMenu) {
        return sysMenuRepository.delete(sysMenu);
    }
}
