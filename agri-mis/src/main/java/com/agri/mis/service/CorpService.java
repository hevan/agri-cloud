package com.agri.mis.service;

import com.agri.mis.domain.Corp;
import com.agri.mis.repository.CorpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CorpService {

    @Autowired
    private CorpRepository corpRepository;


    public Mono<Corp> findById(Long id) {
        return corpRepository.findById(id);
    }


    public Mono<Corp> add(Corp corp) {
        return corpRepository.save(corp);
    }

    public Mono<Corp> update(Long id, Corp corp) {
        return corpRepository.findById(id)
                .flatMap(s -> {
                    corp.setId(s.getId());
                    corp.setName(s.getName());
                    corp.setCode(s.getCode());
                    corp.setDescription(s.getDescription());
                    return corpRepository.save(corp);
                });
    }

    public Mono<Void> delete(Corp corp) {
        return corpRepository.delete(corp);
    }

    public Mono<Page<Corp>> pageQuery(String name, PageRequest pageRequest) {

        Corp corp = new Corp();
        corp.setName(name);
        ExampleMatcher exampleObjectMatcher = ExampleMatcher.matching()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains());


        return this.corpRepository.findAllBy(Example.of(corp, exampleObjectMatcher), pageRequest)
                .collectList()
                .zipWith(this.corpRepository.count(Example.of(corp, exampleObjectMatcher)))
                .map(t -> new PageImpl<>(t.getT1(), pageRequest, t.getT2()));

    }
}
