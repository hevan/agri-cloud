package com.agri.mis.service;

import com.agri.mis.domain.CorpRole;
import com.agri.mis.repository.CorpRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CorpRoleService {

    @Autowired
    private CorpRoleRepository corpRoleRepository;


    public Mono<CorpRole> findById(Long id) {

      return corpRoleRepository.findById(id);
    }


    public Flux<CorpRole> findAllByCorpId(Long corpId) {
        return corpRoleRepository.findAllByCorpId(corpId);
    }

    public Mono<CorpRole> add(CorpRole corpRole) {
        return corpRoleRepository.save(corpRole);
    }

    public Mono<CorpRole> update(Long id, CorpRole corpRole) {
        return corpRoleRepository.findById(id)
                .flatMap(s -> {
                    corpRole.setId(s.getId());
                    return corpRoleRepository.save(corpRole);
                });
    }

    public Mono<Void> delete(CorpRole corpRole) {
        return corpRoleRepository.delete(corpRole);
    }
}
