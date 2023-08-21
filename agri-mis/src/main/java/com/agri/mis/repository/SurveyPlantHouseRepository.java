package com.agri.mis.repository;

import com.agri.mis.domain.SurveyPlantHouse;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface SurveyPlantHouseRepository extends ReactiveCrudRepository<SurveyPlantHouse,Long>, ReactiveQueryByExampleExecutor<SurveyPlantHouse> {

}
