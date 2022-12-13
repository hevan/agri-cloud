package com.agri.mis.service;

import com.agri.mis.domain.CorpDepart;
import com.agri.mis.repository.CorpDepartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CorpDepartService {

    @Autowired
    private CorpDepartRepository corpDepartRepository;


    public Mono<CorpDepart> findById(Long id) {

      return corpDepartRepository.findById(id);
    }


    public Flux<CorpDepart> findAllByCorpId(Long corpId) {
        return corpDepartRepository.findAllByCorpId(corpId);
    }

    public Mono<CorpDepart> add(CorpDepart corpDepart) {
        return corpDepartRepository.save(corpDepart);
    }

    public Mono<CorpDepart> update(Long id, CorpDepart corpDepart) {
        return corpDepartRepository.findById(id)
                .flatMap(s -> {
                    corpDepart.setId(s.getId());
                    return corpDepartRepository.save(corpDepart);
                });
    }

    public Mono<Void> delete(CorpDepart corpDepart) {
        return corpDepartRepository.delete(corpDepart);
    }
}
