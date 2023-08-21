package com.agri.mis.controller.open;


import com.agri.mis.domain.City;
import com.agri.mis.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
@RequestMapping("/open/city")
public class OpenCityController {

    @Autowired
    private CityService cityService;


    @GetMapping("/{id}")
    public Mono<City> find(@PathVariable Long id) {
        return cityService.findById(id);
    }

    @GetMapping("/findAllByCode")
    public Flux<City> findAllByCode(@RequestParam("code") String code) {
        return cityService.findAllByCode(code + '%');
    }

    @GetMapping("/findByName")
    public Mono<City> findByName( String name) {
        return cityService.findByName(name);
    }

    @PostMapping
    public Mono<City> save( @RequestBody City city) {
        return cityService.add(city);
    }

    @PutMapping("/{id}")
    public Mono<City> update(@PathVariable Long id, @RequestBody City city) {
        return cityService.update(id, city);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable Long id) {
        return cityService.findById(id)
                .flatMap(s ->
                        cityService.delete(s)
                                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
