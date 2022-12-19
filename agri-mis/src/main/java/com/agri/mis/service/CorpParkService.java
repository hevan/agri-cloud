package com.agri.mis.service;

import com.agri.mis.domain.CorpPark;
import com.agri.mis.repository.CorpParkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CorpParkService {

    @Autowired
    private CorpParkRepository corpParkRepository;


    public Mono<CorpPark> findById(Long id) {

      return corpParkRepository.findById(id);
    }


    public Flux<CorpPark> findAllByCorpId(Long corpId) {
        return corpParkRepository.findAllByCorpId(corpId);
    }

    public Mono<CorpPark> add(CorpPark corpPark) {
        return corpParkRepository.save(corpPark);
    }

    public Mono<CorpPark> update(Long id, CorpPark corpPark) {
        return corpParkRepository.findById(id)
                .flatMap(s -> {
                    corpPark.setId(s.getId());
                    return corpParkRepository.save(corpPark);
                });
    }

    public Mono<Void> delete(CorpPark corpPark) {
        return corpParkRepository.delete(corpPark);
    }
}
