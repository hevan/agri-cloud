package com.agri.mis.service;

import com.agri.mis.domain.CorpParkBase;
import com.agri.mis.repository.CorpParkBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CorpParkBaseService {

    @Autowired
    private CorpParkBaseRepository corpParkBaseRepository;


    public Mono<CorpParkBase> findById(Long id) {

      return corpParkBaseRepository.findById(id);
    }


    public Flux<CorpParkBase> findAllByParkId(Long parkId) {
        return corpParkBaseRepository.findAllByParkId(parkId);
    }

    public Mono<CorpParkBase> add(CorpParkBase corpParkBase) {
        return corpParkBaseRepository.save(corpParkBase);
    }

    public Mono<CorpParkBase> update(Long id, CorpParkBase corpParkBase) {
        return corpParkBaseRepository.findById(id)
                .flatMap(s -> {
                    corpParkBase.setId(s.getId());
                    return corpParkBaseRepository.save(corpParkBase);
                });
    }

    public Mono<Void> delete(CorpParkBase corpParkBase) {
        return corpParkBaseRepository.delete(corpParkBase);
    }
}
