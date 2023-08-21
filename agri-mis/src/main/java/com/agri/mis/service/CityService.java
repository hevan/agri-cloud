package com.agri.mis.service;

import com.agri.mis.domain.City;
import com.agri.mis.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;


    public Mono<City> findById(Long id) {

      return cityRepository.findById(id);
    }


    public Flux<City> findAllByCode(String code) {
        return cityRepository.findAllByCodeLikeOrderByCode(code);
    }

    public Mono<City> findByName(String name) {
        return cityRepository.findByName(name);
    }

    public Mono<City> add(City city) {
        return cityRepository.save(city);
    }

    public Mono<City> update(Long id, City city) {
        return cityRepository.findById(id)
                .flatMap(s -> {
                    city.setId(s.getId());
                    return cityRepository.save(city);
                });
    }

    public Mono<Void> delete(City city) {
        return cityRepository.delete(city);
    }
}
