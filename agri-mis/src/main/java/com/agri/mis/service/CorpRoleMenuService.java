package com.agri.mis.service;

import com.agri.mis.domain.CorpRoleMenu;
import com.agri.mis.repository.CorpRoleMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CorpRoleMenuService {

    @Autowired
    private CorpRoleMenuRepository corpRoleMenuRepository;


    public Mono<CorpRoleMenu> findById(Long id) {

      return corpRoleMenuRepository.findById(id);
    }


    public Flux<CorpRoleMenu> findAllByRoleId(Long roleId) {
        return corpRoleMenuRepository.findAllByRoleId(roleId);
    }

    public Mono<CorpRoleMenu> add(CorpRoleMenu corpRoleMenu) {
        return corpRoleMenuRepository.save(corpRoleMenu);
    }

    public Mono<CorpRoleMenu> update(Long id, CorpRoleMenu corpRoleMenu) {
        return corpRoleMenuRepository.findById(id)
                .flatMap(s -> {
                    corpRoleMenu.setId(s.getId());
                    return corpRoleMenuRepository.save(corpRoleMenu);
                });
    }

    public Mono<Void> delete(CorpRoleMenu corpRoleMenu) {
        return corpRoleMenuRepository.delete(corpRoleMenu);
    }
}
