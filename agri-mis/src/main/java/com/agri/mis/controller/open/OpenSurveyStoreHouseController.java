package com.agri.mis.controller.open;

import com.agri.mis.domain.SurveyStoreHouse;
import com.agri.mis.service.SurveyStoreHouseService;
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
@RequestMapping("/open/surveyStoreHouse")
public class OpenSurveyStoreHouseController {
    @Autowired
    private SurveyStoreHouseService surveyStoreHouseService;

    @GetMapping("/pageQuery")
    public Mono<Page<SurveyStoreHouse>> pageQuery(SurveyStoreHouse surveyStoreHouse, @RequestParam("page") int page, @RequestParam("size") int size) {
        return surveyStoreHouseService.pageQuery(surveyStoreHouse, PageRequest.of(page, size));
    }

    @GetMapping("/totalByCounty")
    public Mono<BigDecimal> totalByCounty(String county) {
        return surveyStoreHouseService.sumTotal(county);
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<SurveyStoreHouse>> find(@PathVariable Long id) {
        return surveyStoreHouseService.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }



    @PostMapping
    public Mono<SurveyStoreHouse> save(@RequestBody SurveyStoreHouse surveyStoreHouse) {
        return surveyStoreHouseService.add(surveyStoreHouse);
    }

    @PutMapping("/{id}")
    public Mono<SurveyStoreHouse> update(@PathVariable Long id, @RequestBody SurveyStoreHouse surveyStoreHouse) {
        return surveyStoreHouseService.update(id, surveyStoreHouse);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable Long id) {
        return surveyStoreHouseService.findById(id)
                .flatMap(s ->
                        surveyStoreHouseService.delete(s)
                                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


}
