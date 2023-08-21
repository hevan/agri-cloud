package com.agri.mis.service;

import com.agri.mis.domain.SurveyPlantHouse;
import com.agri.mis.repository.SurveyPlantHouseRepository;
import lombok.val;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

import static org.jooq.impl.DSL.sum;

@Service
public class SurveyPlantHouseService {

    @Autowired
    private SurveyPlantHouseRepository surveyPlantHouseRepository;

    @Autowired
    private DSLContext dslContext;

    public Mono<SurveyPlantHouse> findById(Long id) {

      return surveyPlantHouseRepository.findById(id);
    }


    public Mono<SurveyPlantHouse> add(SurveyPlantHouse surveyPlantHouse) {
        return surveyPlantHouseRepository.save(surveyPlantHouse);
    }

    public Mono<SurveyPlantHouse> update(Long id, SurveyPlantHouse surveyPlantHouse) {
        return surveyPlantHouseRepository.findById(id)
                .flatMap(s -> {
                    surveyPlantHouse.setId(s.getId());
                    return surveyPlantHouseRepository.save(surveyPlantHouse);
                });
    }

    public Mono<Void> delete(SurveyPlantHouse surveyPlantHouse) {
        return surveyPlantHouseRepository.delete(surveyPlantHouse);
    }

    public Mono<BigDecimal> sumTotal(String county){
        com.agri.mis.db.tables.SurveyPlantHouse TB_SURVEY_PLANT =  com.agri.mis.db.tables.SurveyPlantHouse.SURVEY_PLANT_HOUSE;
        Condition where = DSL.trueCondition();

        if(StringUtils.hasLength(county)){
            where = where.and(TB_SURVEY_PLANT.COUNTY.eq(county));
        }
        var dataSql  = dslContext.select(sum(TB_SURVEY_PLANT.AREA)).from(TB_SURVEY_PLANT).where(where);

       return  Mono.from(dataSql)
                .map(r -> {
                    if(null == r.getValue(0)){
                        return new BigDecimal(0.0);
                    }else {
                        return r.getValue(0, BigDecimal.class);
                    }
                });
    }

    public Mono<Page<SurveyPlantHouse>> pageQuery(SurveyPlantHouse surveyPlantHouseParam, PageRequest pageRequest) {
        com.agri.mis.db.tables.SurveyPlantHouse TB_SURVEY_PLANT =  com.agri.mis.db.tables.SurveyPlantHouse.SURVEY_PLANT_HOUSE;

        Condition where = DSL.trueCondition();

        if(StringUtils.hasLength(surveyPlantHouseParam.getCounty())){
            where = where.and(TB_SURVEY_PLANT.COUNTY.like("%" + surveyPlantHouseParam.getCounty() +"%"));
        }

        if(StringUtils.hasLength(surveyPlantHouseParam.getTown())){
            where = where.and(TB_SURVEY_PLANT.TOWN.like("%" + surveyPlantHouseParam.getTown() +"%"));
        }

        var dataSql = dslContext.select(
                TB_SURVEY_PLANT.ID,
                TB_SURVEY_PLANT.TOWN,
                TB_SURVEY_PLANT.VILLAGE,
                TB_SURVEY_PLANT.LATITUDE,
                TB_SURVEY_PLANT.LONGITUDE,
                TB_SURVEY_PLANT.OWNER,
                TB_SURVEY_PLANT.QUANTITY,
                TB_SURVEY_PLANT.AREA,
                TB_SURVEY_PLANT.CATEGORY,
                TB_SURVEY_PLANT.IRRIGATE_TYPE,
                TB_SURVEY_PLANT.PURPOSE,
                TB_SURVEY_PLANT.DESCRIPTION,
                TB_SURVEY_PLANT.LATITUDE,
                TB_SURVEY_PLANT.LONGITUDE,
                TB_SURVEY_PLANT.CREATED_AT
        ).from(TB_SURVEY_PLANT).where(where).orderBy(TB_SURVEY_PLANT.TOWN,TB_SURVEY_PLANT.TOWN, TB_SURVEY_PLANT.VILLAGE).limit(pageRequest.getOffset(),pageRequest.getPageSize());
        val countSql = dslContext.select(DSL.field("count(*)", SQLDataType.BIGINT))
                .from(TB_SURVEY_PLANT)
                .where(where);
        return Mono
                .zip(
                        Flux.from(dataSql)
                                .map(
                                        r->{
                                            SurveyPlantHouse surveyPlantHouse = new SurveyPlantHouse();
                                            surveyPlantHouse.setId(r.getValue(TB_SURVEY_PLANT.ID));
                                            surveyPlantHouse.setTown(r.getValue(TB_SURVEY_PLANT.TOWN));
                                            surveyPlantHouse.setVillage(r.getValue(TB_SURVEY_PLANT.VILLAGE));
                                            surveyPlantHouse.setLatitude(r.getValue(TB_SURVEY_PLANT.LATITUDE));
                                            surveyPlantHouse.setLongitude(r.getValue(TB_SURVEY_PLANT.LONGITUDE));
                                            surveyPlantHouse.setOwner(r.getValue(TB_SURVEY_PLANT.OWNER));
                                            surveyPlantHouse.setQuantity(r.getValue(TB_SURVEY_PLANT.QUANTITY));
                                            surveyPlantHouse.setArea(r.getValue(TB_SURVEY_PLANT.AREA));
                                            surveyPlantHouse.setCategory(r.getValue(TB_SURVEY_PLANT.CATEGORY));
                                            surveyPlantHouse.setPurpose(r.getValue(TB_SURVEY_PLANT.PURPOSE));
                                            surveyPlantHouse.setIrrigateType(r.getValue(TB_SURVEY_PLANT.IRRIGATE_TYPE));
                                            surveyPlantHouse.setCreatedAt(r.getValue(TB_SURVEY_PLANT.CREATED_AT));
                                            surveyPlantHouse.setDescription(r.getValue(TB_SURVEY_PLANT.DESCRIPTION));

                                            return surveyPlantHouse;
                                        }).collectList(),Mono.from(countSql).map(Record1::value1))
                .map(it -> new PageImpl<>(it.getT1(),pageRequest,it.getT2()));
    }

}
