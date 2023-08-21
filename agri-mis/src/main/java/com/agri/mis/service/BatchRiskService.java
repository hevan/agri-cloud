package com.agri.mis.service;

import com.agri.mis.domain.*;
import com.agri.mis.domain.BatchRisk;
import com.agri.mis.repository.BatchRiskRepository;
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
public class BatchRiskService {

    @Autowired
    private BatchRiskRepository batchRiskRepository;

    @Autowired
    private DSLContext dslContext;

    public Mono<BatchRisk> findById(Long id){
        return batchRiskRepository.findById(id);
    }

    public Flux<BatchRisk> findAllByBatchId(Long batchId){
        return batchRiskRepository.findAllByBatchId(batchId);
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


    public Mono<Page<BatchRisk>> pageQuery(Long batchId, String cycleName, PageRequest pageRequest){
        com.agri.mis.db.tables.BatchRisk br = com.agri.mis.db.tables.BatchRisk.BATCH_RISK;

        com.agri.mis.db.tables.BatchProduct bp = com.agri.mis.db.tables.BatchProduct.BATCH_PRODUCT;

        Condition where = DSL.trueCondition();

        if(StringUtils.hasLength(cycleName)){
            where = where.and(br.CYCLE_NAME.like("%" + cycleName +"%"));
        }
        if(null != batchId){
            where = where.and(br.BATCH_ID.eq(batchId));
        }

        var dataSql = dslContext.select(
                br.ID,
                br.NAME,
                br.PRODUCT_ID,
                br.BATCH_ID,
                br.CYCLE_NAME,
                br.RISK_CATEGORY,
                br.DESCRIPTION,
                br.SOLUTION,
                br.FEE_AMOUNT,
                br.CREATED_USER_ID,
                br.CREATED_BY,
                br.OCCUR_DATE,
                br.CREATED_AT,
                br.CORP_ID,

                bp.ID,
                bp.NAME,
                bp.CODE,
                bp.STATUS
        ).from(br).leftJoin(bp).on(br.BATCH_ID.eq(bp.ID)).where(where).limit(pageRequest.getOffset(),pageRequest.getPageSize());
        val countSql = dslContext.select(DSL.field("count(*)", SQLDataType.BIGINT))
                .from(br)
                .where(where);
        return Mono.zip(
                Flux.from(dataSql)
                        .map(
                                r->{
                                    BatchRisk batchRisk = new BatchRisk();
                                    batchRisk.setId(r.getValue(br.ID));
                                    batchRisk.setProductId(r.getValue(br.PRODUCT_ID));
                                    batchRisk.setBatchId(r.getValue(br.BATCH_ID));
                                    batchRisk.setCycleName(r.getValue(br.CYCLE_NAME));
                                    batchRisk.setRiskCategory(r.getValue(br.RISK_CATEGORY));
                                    batchRisk.setDescription(r.getValue(br.DESCRIPTION));
                                    batchRisk.setSolution(r.getValue(br.SOLUTION));
                                    batchRisk.setFeeAmount(r.getValue(br.FEE_AMOUNT));

                                    batchRisk.setCreatedUserId(r.getValue(br.CREATED_USER_ID));
                                    batchRisk.setCreatedBy(r.getValue(br.CREATED_BY));

                                    batchRisk.setOccurDate(r.getValue(br.OCCUR_DATE));
                                    batchRisk.setCreatedAt(r.getValue(br.CREATED_AT));
                                    batchRisk.setCorpId(r.getValue(br.CORP_ID));

                                    if(null!=batchRisk.getBatchId()){
                                        BatchProduct batchProduct = new BatchProduct();
                                        batchProduct.setId( batchRisk.getBatchId());
                                        batchProduct.setName( r.getValue(bp.NAME));
                                        batchProduct.setCode( r.getValue(bp.CODE));
                                        batchProduct.setStatus( r.getValue(bp.STATUS));
                                        batchRisk.setBatchProduct(batchProduct);
                                    }

                                    return batchRisk;
                                }).collectList(),Mono.from(countSql).map(Record1::value1))
                .map(it -> new PageImpl<>(it.getT1(),pageRequest,it.getT2()));
    }

}
