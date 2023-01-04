package com.agri.mis.service;

import com.agri.mis.domain.*;
import com.agri.mis.domain.BatchRisk;
import com.agri.mis.repository.BatchRiskRepository;
import lombok.val;
import lombok.var;
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

@Service
public class BatchRiskService {

    @Autowired
    private BatchRiskRepository batchRiskRepository;

    @Autowired
    private DSLContext dslContext;

    public Mono<BatchRisk> findById(Long id){
        return batchRiskRepository.findById(id);
    }

    public Mono<BatchRisk> add(BatchRisk batchRisk){
        return batchRiskRepository.save(batchRisk);
    }

    public Mono<BatchRisk> update(Long id,BatchRisk batchRisk){
        return batchRiskRepository.findById(id).flatMap(
                r ->{
                    batchRisk.setId(r.getId());
                    return batchRiskRepository.save(batchRisk);
                }
        );
    }

    public Mono<Void> delete(BatchRisk batchRisk){
        return batchRiskRepository.delete(batchRisk);
    }


    public Mono<Page<BatchRisk>> pageQuery(String cycleName, PageRequest pageRequest){
        com.agri.mis.db.tables.BatchRisk br = com.agri.mis.db.tables.BatchRisk.BATCH_RISK;

        com.agri.mis.db.tables.BatchProduct bp = com.agri.mis.db.tables.BatchProduct.BATCH_PRODUCT;

        com.agri.mis.db.tables.Corp c = com.agri.mis.db.tables.Corp.CORP;

        com.agri.mis.db.tables.Address at = com.agri.mis.db.tables.Address.ADDRESS;

        Condition where = DSL.trueCondition();

        if(StringUtils.hasLength(cycleName)){
            where = where.and(br.CYCLE_NAME.like("%" + cycleName +"%"));
        }
        var dataSql = dslContext.select(
                br.ID,
                br.PRODUCT_ID,
                br.BATCH_ID,
                br.CYCLE_NAME,
                br.RISK_CATEGORY,
                br.DISCRIPTION,
                br.SOLUTION,
                br.FEE_AMOUNT,
                br.CREATED_USER_ID,
                br.CREATED_BY,
                br.OCCUR_DATE,
                br.CREATED_AT,
                br.CORP_ID,

                c.ID,
                c.NAME,
                c.CODE,
                c.ADDRESS_ID,
                c.DESCRIPTION,
                c.CREATED_AT,

                bp.ID,
                bp.NAME,
                bp.CODE,
                bp.PRODUCT_ID,
                bp.START_AT,
                bp.END_AT,
                bp.DAYS,
                bp.PRODUCTION_ESTIMATED,
                bp.PRODUCTION_REAL,
                bp.INVEST_ESTIMATED,
                bp.INVEST_REAL,
                bp.CORP_ID,
                bp.CALC_UNIT,
                bp.PARK_ID,
                bp.CREATED_USER_ID,
                bp.CREATED_BY,
                bp.CREATED_AT,
                bp.DESCRIPTION,
                bp.QUANTITY,
                bp.STATUS,

                at.ID,
                at.PROVINCE,
                at.CITY,
                at.REGION,
                at.LINE_DETAIL,
                at.LINK_NAME,
                at.LINK_MOBILE,
                at.CREATED_AT
        ).from(br).leftJoin(bp).on(br.BATCH_ID.eq(bp.ID)).rightJoin(c).on(br.CORP_ID.eq(c.ID)).rightJoin(at).on(c.ADDRESS_ID.eq(at.ID)).where(where).limit(pageRequest.getOffset(),pageRequest.getPageSize());
        val countSql = dslContext.select(DSL.field("count(*)", SQLDataType.BIGINT))
                .from(br)
                .where(where);
        return Mono.zip(
                Flux.from(dataSql)
                        .map(
                                r->{
                                    BatchRisk batchRisk = new BatchRisk(
                                            r.getValue(br.ID),
                                            r.getValue(br.PRODUCT_ID),
                                            r.getValue(br.BATCH_ID),
                                            r.getValue(br.CYCLE_NAME),
                                            r.getValue(br.RISK_CATEGORY),
                                            r.getValue(br.DISCRIPTION),
                                            r.getValue(br.SOLUTION),
                                            r.getValue(br.FEE_AMOUNT),
                                            r.getValue(br.CREATED_USER_ID),
                                            r.getValue(br.CREATED_BY),
                                            r.getValue(br.OCCUR_DATE),
                                            r.getValue(br.CREATED_AT),
                                            r.getValue(br.CORP_ID),
                                            null,
                                            null
                                    );
                                    if(null!=batchRisk.getBatchId()){
                                        BatchProduct batchProduct = new BatchProduct(
                                                r.getValue(bp.ID),
                                                r.getValue(bp.NAME),
                                                r.getValue(bp.CODE),
                                                r.getValue(bp.PRODUCT_ID),
                                                r.getValue(bp.START_AT),
                                                r.getValue(bp.END_AT),
                                                r.getValue(bp.DAYS),
                                                r.getValue(bp.PRODUCTION_ESTIMATED),
                                                r.getValue(bp.PRODUCTION_REAL),
                                                r.getValue(bp.INVEST_ESTIMATED),
                                                r.getValue(bp.INVEST_REAL),
                                                r.getValue(bp.CORP_ID),
                                                r.getValue(bp.CALC_UNIT),
                                                r.getValue(bp.PARK_ID),
                                                r.getValue(bp.CREATED_USER_ID),
                                                r.getValue(bp.CREATED_BY),
                                                r.getValue(bp.CREATED_AT),
                                                r.getValue(bp.DESCRIPTION),
                                                r.getValue(bp.QUANTITY),
                                                r.getValue(bp.STATUS),
                                                null);
                                        batchRisk.setBatchProduct(batchProduct);
                                    }

                                    if(null!=batchRisk.getCorpId()){
                                        Corp corp = new Corp(r.getValue(c.ID), r.getValue(c.NAME), r.getValue(c.CODE), r.getValue(c.DESCRIPTION), r.getValue(c.ADDRESS_ID), r.getValue(c.CREATED_AT), null);
                                        if(null!=corp.getAddressId()){
                                            Address address = new Address(r.getValue(at.ID), r.getValue(at.PROVINCE), r.getValue(at.CITY), r.getValue(at.REGION), r.getValue(at.LINE_DETAIL), r.getValue(at.LINK_NAME), r.getValue(at.LINK_MOBILE), null, r.getValue(at.CREATED_AT));
                                            corp.setAddress(address);
                                        }
                                        batchRisk.setCorp(corp);
                                    }
                                    return batchRisk;
                                }).collectList(),Mono.from(countSql).map(Record1::value1))
                .map(it -> new PageImpl<>(it.getT1(),pageRequest,it.getT2()));
    }

}
