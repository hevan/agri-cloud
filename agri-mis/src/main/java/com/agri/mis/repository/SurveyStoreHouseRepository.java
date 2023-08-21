package com.agri.mis.repository;

import com.agri.mis.domain.SurveyStoreHouse;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface SurveyStoreHouseRepository extends ReactiveCrudRepository<SurveyStoreHouse,Long>, ReactiveQueryByExampleExecutor<SurveyStoreHouse> {

}
