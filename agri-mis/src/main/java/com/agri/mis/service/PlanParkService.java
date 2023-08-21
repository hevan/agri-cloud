package com.agri.mis.service;

import com.agri.mis.domain.PlanPark;
import com.agri.mis.repository.PlanParkRepository;
import com.agri.mis.repository.PlanParkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PlanParkService {

    @Autowired
    private PlanParkRepository planParkRepository;


    public Mono<PlanPark> findById(Long id) {

      return planParkRepository.findById(id);
    }


    public Flux<PlanPark> findAllByCounty(String county) {
        return planParkRepository.findAllByCounty(county);
    }

    public Mono<PlanPark> add(PlanPark planPark) {
        return planParkRepository.save(planPark);
    }

    public Mono<PlanPark> update(Long id, PlanPark planPark) {
        return planParkRepository.findById(id)
                .flatMap(s -> {
                    planPark.setId(s.getId());
                    return planParkRepository.save(planPark);
                });
    }

    public Mono<Void> delete(PlanPark planPark) {
        return planParkRepository.delete(planPark);
    }
}
