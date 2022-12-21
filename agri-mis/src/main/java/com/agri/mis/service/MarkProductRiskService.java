package com.agri.mis.service;

import com.agri.mis.domain.MarkProductRisk;
import com.agri.mis.dto.MarkProductRiskWithMarkProductBatch;
import com.agri.mis.repository.MarkProductRiskRepository;
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

@Service
public class MarkProductRiskService {
@Autowired
    private MarkProductRiskRepository markProductRiskRepository;

    @Autowired
    private DSLContext dslContext;

    public Mono<MarkProductRisk> findById(Long id) {
        return markProductRiskRepository.findById(id);
    }

    public Mono<MarkProductRisk> add(MarkProductRisk markProductRisk) {
        return markProductRiskRepository.save(markProductRisk);
    }


    public Mono<MarkProductRisk> update(Long id, MarkProductRisk markProductRisk) {
        return markProductRiskRepository.findById(id).flatMap(s->{
            markProductRisk.setId(s.getId());
            return markProductRiskRepository.save(markProductRisk);
        });
    }


    public Mono<Void> delexte(MarkProductRisk markProductRisk) {
        return markProductRiskRepository.delete(markProductRisk);
    }

    public Mono<Page<MarkProductRiskWithMarkProductBatch>> pageQuery(String name, PageRequest pageRequest) {


        com.agri.mis.db.tables.MarkProductRisk ct = com.agri.mis.db.tables.MarkProductRisk.MARK_PRODUCT_RISK;
        com.agri.mis.db.tables.MarkProductBatch mpb =  com.agri.mis.db.tables.MarkProductBatch.MARK_PRODUCT_BATCH;

        Condition where = DSL.trueCondition();

        if(StringUtils.hasLength(name)){
            where = where.and(ct.NAME.like("%" + name +"%"));
        }
        var dataSql = dslContext.select(
                ct.CYCLE_NAME,
                ct.RISK_CATEGORY,
                ct.DESCRIPTION,
                ct.SOLUTION,
                ct.FEE_AMOUNT,
                ct.NAME,
                ct.ID,
                ct.PRODUCT_BATCH_ID,

                mpb.ID,
                mpb.NAME,
                mpb.CODE,
                mpb.PRODUCT_ID,
                mpb.START_AT,
                mpb.END_AT,
                mpb.DAYS,
                mpb.CREATED_TYPE,
                mpb.PRODUCTION,
                mpb.INVEST,
                mpb.SALE_PRICE,
                mpb.UNIT,
                mpb.CREATED_AT,
                mpb.CREATED_BY,
                mpb.CREATED_USER_ID,
                mpb.DESCRIPTION,
                mpb.STATUS

        ).from(ct).leftJoin(mpb).on(ct.PRODUCT_BATCH_ID.eq(mpb.ID)).where(where).limit(pageRequest.getOffset(), pageRequest.getPageSize());

        val countSql = dslContext.select(DSL.field("count(*)", SQLDataType.BIGINT))
                .from(ct)
                .where(where);

        return Mono
                .zip(
                        Flux.from(dataSql)
                                .map(r -> {
                                    MarkProductRisk markProductRisk = new MarkProductRisk(
                                            r.getValue(ct.CYCLE_NAME), r.getValue(ct.RISK_CATEGORY),
                                            r.getValue(ct.DESCRIPTION), r.getValue(ct.SOLUTION),
                                            r.getValue(ct.FEE_AMOUNT), r.getValue(ct.NAME),
                                            r.getValue(ct.ID), r.getValue(ct.PRODUCT_BATCH_ID)
                                    );

                                    //Address convert from
                                    if(null != markProductRisk.getId()) {
                                        com.agri.mis.domain.MarkProductBatch markProduct = new com.agri.mis.domain.MarkProductBatch(
                                                r.getValue(mpb.ID),r.getValue(mpb.NAME),
                                                r.getValue(mpb.CODE),r.getValue(mpb.PRODUCT_ID)
                                                ,r.getValue(mpb.START_AT),r.getValue(mpb.END_AT)
                                                ,r.getValue(mpb.DAYS),r.getValue(mpb.CREATED_TYPE)
                                                ,r.getValue(mpb.PRODUCTION),r.getValue(mpb.INVEST)
                                                ,r.getValue(mpb.SALE_PRICE),r.getValue(mpb.UNIT)
                                                ,r.getValue(mpb.CREATED_AT),r.getValue(mpb.CREATED_BY)
                                                ,r.getValue(mpb.CREATED_USER_ID),r.getValue(mpb.DESCRIPTION)
                                                ,r.getValue(mpb.STATUS));
                                        return new MarkProductRiskWithMarkProductBatch(markProductRisk, markProduct);
                                    }else{
                                        return new MarkProductRiskWithMarkProductBatch(markProductRisk, null);
                                    }

                                })
                                .collectList(),
                        Mono.from(countSql)
                                .map(Record1::value1)
                )
                .map(it -> new PageImpl<>(it.getT1(), pageRequest, it.getT2()));


    }
}
