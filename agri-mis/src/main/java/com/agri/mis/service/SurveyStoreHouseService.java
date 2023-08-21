package com.agri.mis.service;

import com.agri.mis.domain.SurveyStoreHouse;
import com.agri.mis.repository.SurveyStoreHouseRepository;
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
public class SurveyStoreHouseService {

    @Autowired
    private SurveyStoreHouseRepository surveyStoreHouseRepository;

    @Autowired
    private DSLContext dslContext;

    public Mono<SurveyStoreHouse> findById(Long id) {

      return surveyStoreHouseRepository.findById(id);
    }


    public Mono<SurveyStoreHouse> add(SurveyStoreHouse surveyStoreHouse) {
        return surveyStoreHouseRepository.save(surveyStoreHouse);
    }

    public Mono<SurveyStoreHouse> update(Long id, SurveyStoreHouse surveyStoreHouse) {
        return surveyStoreHouseRepository.findById(id)
                .flatMap(s -> {
                    surveyStoreHouse.setId(s.getId());
                    return surveyStoreHouseRepository.save(surveyStoreHouse);
                });
    }

    public Mono<Void> delete(SurveyStoreHouse surveyStoreHouse) {
        return surveyStoreHouseRepository.delete(surveyStoreHouse);
    }
    public Mono<BigDecimal> sumTotal(String county){
        com.agri.mis.db.tables.SurveyStoreHouse TB_SURVEY_STORE =  com.agri.mis.db.tables.SurveyStoreHouse.SURVEY_STORE_HOUSE;
        Condition where = DSL.trueCondition();

        if(StringUtils.hasLength(county)){
            where = where.and(TB_SURVEY_STORE.COUNTY.eq(county));
        }
        var dataSql  = dslContext.select(sum(TB_SURVEY_STORE.CAPACITY)).from(TB_SURVEY_STORE).where(where);

        return  Mono.from(dataSql)
                .map(r -> {
                    if(null == r.getValue(0)){
                        return new BigDecimal(0.0);
                    }else {
                        return r.getValue(0, BigDecimal.class);
                    }
                });
    }
    public Mono<Page<SurveyStoreHouse>> pageQuery(SurveyStoreHouse surveyStoreHouseParam, PageRequest pageRequest) {
        com.agri.mis.db.tables.SurveyStoreHouse TB_SURVEY_STORE =  com.agri.mis.db.tables.SurveyStoreHouse.SURVEY_STORE_HOUSE;

        Condition where = DSL.trueCondition();

        if(StringUtils.hasLength(surveyStoreHouseParam.getCounty())){
            where = where.and(TB_SURVEY_STORE.COUNTY.like("%" + surveyStoreHouseParam.getCounty() +"%"));
        }

        if(StringUtils.hasLength(surveyStoreHouseParam.getTown())){
            where = where.and(TB_SURVEY_STORE.TOWN.like("%" + surveyStoreHouseParam.getTown() +"%"));
        }

        var dataSql = dslContext.select(
                TB_SURVEY_STORE.ID,
                TB_SURVEY_STORE.TOWN,
                TB_SURVEY_STORE.VILLAGE,
                TB_SURVEY_STORE.LATITUDE,
                TB_SURVEY_STORE.LONGITUDE,
                TB_SURVEY_STORE.OWNER,
                TB_SURVEY_STORE.CAPACITY,
                TB_SURVEY_STORE.AREA,
                TB_SURVEY_STORE.CATEGORY,
                TB_SURVEY_STORE.BUILD_YEAR,
                TB_SURVEY_STORE.PURPOSE,
                TB_SURVEY_STORE.DESCRIPTION,
                TB_SURVEY_STORE.LATITUDE,
                TB_SURVEY_STORE.LONGITUDE,
                TB_SURVEY_STORE.CREATED_AT
        ).from(TB_SURVEY_STORE).where(where).orderBy(TB_SURVEY_STORE.TOWN,TB_SURVEY_STORE.TOWN, TB_SURVEY_STORE.VILLAGE).limit(pageRequest.getOffset(),pageRequest.getPageSize());
        val countSql = dslContext.select(DSL.field("count(*)", SQLDataType.BIGINT))
                .from(TB_SURVEY_STORE)
                .where(where);
        return Mono
                .zip(
                        Flux.from(dataSql)
                                .map(
                                        r->{
                                            SurveyStoreHouse surveyStoreHouse = new SurveyStoreHouse();
                                            surveyStoreHouse.setId(r.getValue(TB_SURVEY_STORE.ID));
                                            surveyStoreHouse.setTown(r.getValue(TB_SURVEY_STORE.TOWN));
                                            surveyStoreHouse.setVillage(r.getValue(TB_SURVEY_STORE.VILLAGE));
                                            surveyStoreHouse.setLatitude(r.getValue(TB_SURVEY_STORE.LATITUDE));
                                            surveyStoreHouse.setLongitude(r.getValue(TB_SURVEY_STORE.LONGITUDE));
                                            surveyStoreHouse.setOwner(r.getValue(TB_SURVEY_STORE.OWNER));
                                            surveyStoreHouse.setCapacity(r.getValue(TB_SURVEY_STORE.CAPACITY));
                                            surveyStoreHouse.setArea(r.getValue(TB_SURVEY_STORE.AREA));
                                            surveyStoreHouse.setBuildYear(r.getValue(TB_SURVEY_STORE.BUILD_YEAR));
                                            surveyStoreHouse.setCategory(r.getValue(TB_SURVEY_STORE.CATEGORY));
                                            surveyStoreHouse.setPurpose(r.getValue(TB_SURVEY_STORE.PURPOSE));
                                            surveyStoreHouse.setCreatedAt(r.getValue(TB_SURVEY_STORE.CREATED_AT));
                                            surveyStoreHouse.setDescription(r.getValue(TB_SURVEY_STORE.DESCRIPTION));

                                            return surveyStoreHouse;
                                        }).collectList(),Mono.from(countSql).map(Record1::value1))
                .map(it -> new PageImpl<>(it.getT1(),pageRequest,it.getT2()));
    }

}
