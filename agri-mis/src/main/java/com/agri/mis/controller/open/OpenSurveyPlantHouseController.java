package com.agri.mis.controller.open;

import com.agri.mis.domain.SurveyPlantHouse;
import com.agri.mis.service.SurveyPlantHouseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@RestController
@Slf4j
@RequestMapping("/open/surveyPlantHouse")
public class OpenSurveyPlantHouseController {
    @Autowired
    private SurveyPlantHouseService surveyPlantHouseService;

    @GetMapping("/pageQuery")
    public Mono<Page<SurveyPlantHouse>> pageQuery(SurveyPlantHouse surveyPlantHouse, @RequestParam("page") int page, @RequestParam("size") int size) {
        return surveyPlantHouseService.pageQuery(surveyPlantHouse, PageRequest.of(page, size));
    }

        @GetMapping("/totalByCounty")
    public Mono<BigDecimal> totalByCounty(String county) {
        return surveyPlantHouseService.sumTotal(county);
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<SurveyPlantHouse>> find(@PathVariable Long id) {
        return surveyPlantHouseService.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }



    @PostMapping
    public Mono<SurveyPlantHouse> save(@RequestBody SurveyPlantHouse surveyPlantHouse) {
        return surveyPlantHouseService.add(surveyPlantHouse);
    }

    @PutMapping("/{id}")
    public Mono<SurveyPlantHouse> update(@PathVariable Long id, @RequestBody SurveyPlantHouse surveyPlantHouse) {
        return surveyPlantHouseService.update(id, surveyPlantHouse);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable Long id) {
        return surveyPlantHouseService.findById(id)
                .flatMap(s ->
                        surveyPlantHouseService.delete(s)
                                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


}
