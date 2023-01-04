package com.agri.mis.service;

import com.agri.mis.domain.*;
import com.agri.mis.repository.BatchCycleExpenseRepository;
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
public class BatchCycleExpenseService {
    @Autowired
    private BatchCycleExpenseRepository batchCycleExpenseRepository;

    @Autowired
    private DSLContext dslContext;

    public Mono<BatchCycleExpense> findById(Long id){
        return batchCycleExpenseRepository.findById(id);
    }

    public Mono<BatchCycleExpense> add(BatchCycleExpense batchCycleExpense){
        return batchCycleExpenseRepository.save(batchCycleExpense);
    }

    public Mono<BatchCycleExpense> update(Long id,BatchCycleExpense batchCycleExpense){
        return batchCycleExpenseRepository.findById(id).flatMap(
                r ->{
                    batchCycleExpense.setId(r.getId());
                    return batchCycleExpenseRepository.save(batchCycleExpense);
                }
        );
    }

    public Mono<Void> delete(BatchCycleExpense batchCycleExpense){
        return batchCycleExpenseRepository.delete(batchCycleExpense);
    }

    public Mono<Page<BatchCycleExpense>> pageQuery(String name, PageRequest pageRequest) {
        com.agri.mis.db.tables.BatchCycleExpense bce =  com.agri.mis.db.tables.BatchCycleExpense.BATCH_CYCLE_EXPENSE;

        com.agri.mis.db.tables.BatchCycle bc = com.agri.mis.db.tables.BatchCycle.BATCH_CYCLE;

        com.agri.mis.db.tables.Corp c = com.agri.mis.db.tables.Corp.CORP;

        com.agri.mis.db.tables.BatchProduct bp = com.agri.mis.db.tables.BatchProduct.BATCH_PRODUCT;

        com.agri.mis.db.tables.Address at = com.agri.mis.db.tables.Address.ADDRESS;

        Condition where = DSL.trueCondition();

        if(StringUtils.hasLength(name)){
            where = where.and(bce.INVEST_PRODUCT_NAME.like("%" + name +"%"));
        }
        var dataSql = dslContext.select(
                bce.ID,
                bce.BATCH_CYCLE_ID,
                bce.INVEST_PRODUCT_ID,
                bce.INVEST_PRODUCT_NAME,
                bce.DESCRIPTION,
                bce.INVEST_AMOUNT,
                bce.INVEST_PRICE,
                bce.INVEST_QUANTITY,
                bce.CORP_ID,
                bce.BATCH_ID,
                bce.EXPENSE_TYPE,

                c.ID,
                c.NAME,
                c.CODE,
                c.ADDRESS_ID,
                c.DESCRIPTION,
                c.CREATED_AT,

                bc.ID,
                bc.NAME,
                bc.DESCRIPTION,
                bc.IMAGE_URL,
                bc.DAYS,
                bc.START_AT,
                bc.END_AT,
                bc.BATCH_ID,
                bc.STATUS,
                bc.PARENT_ID,
                bc.PROGRESS,
                bc.CREATED_USER_ID,
                bc.CREATED_BY,
                bc.CREATED_AT,
                bc.CYCLE_TYPE,

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
        ).from(bce).leftJoin(bc).on(bce.BATCH_CYCLE_ID.eq(bc.ID)).rightJoin(c).on(bce.CORP_ID.eq(c.ID)).rightJoin(bp).on(bce.BATCH_ID.eq(bp.ID)).rightJoin(at).on(c.ADDRESS_ID.eq(at.ID)).where(where).limit(pageRequest.getOffset(),pageRequest.getPageSize());
        val countSql = dslContext.select(DSL.field("count(*)", SQLDataType.BIGINT))
                .from(bce)
                .where(where);
        return Mono
                .zip(
                        Flux.from(dataSql)
                                .map(
                                        r->{
                                            BatchCycleExpense batchCycleExecute = new BatchCycleExpense(
                                                    r.getValue(bce.ID),
                                                    r.getValue(bce.BATCH_CYCLE_ID),
                                                    r.getValue(bce.INVEST_PRODUCT_ID),
                                                    r.getValue(bce.INVEST_PRODUCT_NAME),
                                                    r.getValue(bce.DESCRIPTION),
                                                    r.getValue(bce.INVEST_AMOUNT),
                                                    r.getValue(bce.INVEST_PRICE),
                                                    r.getValue(bce.INVEST_QUANTITY),
                                                    r.getValue(bce.CORP_ID),
                                                    r.getValue(bce.BATCH_ID),
                                                    r.getValue(bce.EXPENSE_TYPE),
                                                    null,
                                                    null,
                                                    null);
                                            if(null!=batchCycleExecute.getBatchCycleId()){
                                                BatchCycle batchCycle = new BatchCycle(
                                                        r.getValue(bc.ID),
                                                        r.getValue(bc.NAME),
                                                        r.getValue(bc.DESCRIPTION),
                                                        r.getValue(bc.IMAGE_URL),
                                                        r.getValue(bc.DAYS),
                                                        r.getValue(bc.START_AT),
                                                        r.getValue(bc.END_AT),
                                                        r.getValue(bc.BATCH_ID),
                                                        r.getValue(bc.STATUS),
                                                        r.getValue(bc.PARENT_ID),
                                                        r.getValue(bc.PROGRESS),
                                                        r.getValue(bc.CREATED_USER_ID),
                                                        r.getValue(bc.CREATED_BY),
                                                        r.getValue(bc.CREATED_AT),
                                                        r.getValue(bc.CYCLE_TYPE),
                                                        null
                                                );
                                                batchCycleExecute.setBatchCycle(batchCycle);
                                            }
                                            if(null!=batchCycleExecute.getBatchId()){
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
                                                batchCycleExecute.setBatchProduct(batchProduct);
                                            }
                                            if(null!=batchCycleExecute.getCorpId()){
                                                Corp corp = new Corp(r.getValue(c.ID), r.getValue(c.NAME), r.getValue(c.CODE), r.getValue(c.DESCRIPTION), r.getValue(c.ADDRESS_ID), r.getValue(c.CREATED_AT), null);
                                                if(null!=corp.getAddressId()){
                                                    Address address = new Address(r.getValue(at.ID), r.getValue(at.PROVINCE), r.getValue(at.CITY), r.getValue(at.REGION), r.getValue(at.LINE_DETAIL), r.getValue(at.LINK_NAME), r.getValue(at.LINK_MOBILE), null, r.getValue(at.CREATED_AT));
                                                    corp.setAddress(address);
                                                }
                                                batchCycleExecute.setCorp(corp);
                                            }

                                            return batchCycleExecute;
                                        }).collectList(),Mono.from(countSql).map(Record1::value1))
                .map(it -> new PageImpl<>(it.getT1(),pageRequest,it.getT2()));
    }
}
