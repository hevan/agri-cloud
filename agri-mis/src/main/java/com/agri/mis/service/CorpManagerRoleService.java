package com.agri.mis.service;

import com.agri.mis.domain.CorpManagerRole;
import com.agri.mis.repository.CorpManagerRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CorpManagerRoleService {

    @Autowired
    private CorpManagerRoleRepository corpManageRoleRepository;


    public Mono<CorpManagerRole> findById(Long id) {

      return corpManageRoleRepository.findById(id);
    }


    public Flux<CorpManagerRole> findAllByManagerId(Long managerId) {
        return corpManageRoleRepository.findAllByManagerId(managerId);
    }

    public Mono<CorpManagerRole> add(CorpManagerRole corpManageRole) {
        return corpManageRoleRepository.save(corpManageRole);
    }

    public Mono<CorpManagerRole> update(Long id, CorpManagerRole corpManageRole) {
        return corpManageRoleRepository.findById(id)
                .flatMap(s -> {
                    corpManageRole.setId(s.getId());
                    return corpManageRoleRepository.save(corpManageRole);
                });
    }

    public Mono<Void> delete(CorpManagerRole corpManageRole) {
        return corpManageRoleRepository.delete(corpManageRole);
    }
}
