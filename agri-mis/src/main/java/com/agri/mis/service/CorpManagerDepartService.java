package com.agri.mis.service;

import com.agri.mis.domain.CorpManagerDepart;
import com.agri.mis.repository.CorpManagerDepartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CorpManagerDepartService {

    @Autowired
    private CorpManagerDepartRepository corpManageDepartRepository;


    public Mono<CorpManagerDepart> findById(Long id) {

      return corpManageDepartRepository.findById(id);
    }


    public Flux<CorpManagerDepart> findAllByManagerId(Long managerId) {
        return corpManageDepartRepository.findAllByManagerId(managerId);
    }

    public Mono<CorpManagerDepart> add(CorpManagerDepart corpManageDepart) {
        return corpManageDepartRepository.save(corpManageDepart);
    }

    public Mono<CorpManagerDepart> update(Long id, CorpManagerDepart corpManageDepart) {
        return corpManageDepartRepository.findById(id)
                .flatMap(s -> {
                    corpManageDepart.setId(s.getId());
                    return corpManageDepartRepository.save(corpManageDepart);
                });
    }

    public Mono<Void> delete(CorpManagerDepart corpManageDepart) {
        return corpManageDepartRepository.delete(corpManageDepart);
    }
}
