package com.agri.mis.service;

import com.agri.mis.domain.MarkProductBatch;
import com.agri.mis.domain.MarkProductCycle;
import com.agri.mis.domain.MarkProductCycleExpense;
import com.agri.mis.domain.Product;
import com.agri.mis.dto.MarkProductCycleExpenseWithProductBatchWithCycle;
import com.agri.mis.dto.MarkProductCycleWithPproductBatchWithParent;
import com.agri.mis.repository.MarkProductCycleExpenseRepository;
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
public class MarkProductCycleExpenseService {
    @Autowired
    private MarkProductCycleExpenseRepository repository;

    @Autowired
    private DSLContext context;

    public Mono<MarkProductCycleExpense> findById(Long id){
        return repository.findById(id);
    }

    public Mono<MarkProductCycleExpense> add(MarkProductCycleExpense markProductCycle){
        return repository.save(markProductCycle);
    }

    public Mono<MarkProductCycleExpense> update(Long id,MarkProductCycleExpense markProductCycle){
        return repository.findById(id).flatMap(
                r->{
                    markProductCycle.setId(r.getId());
                    return repository.save(markProductCycle);
                }
        );
    }

    public Mono<Void> delete(MarkProductCycleExpense markProductCycle){
        return repository.delete(markProductCycle);
    }

    public Mono<Page<MarkProductCycleExpenseWithProductBatchWithCycle>> pageQuery(String name, PageRequest pageRequest){
        com.agri.mis.db.tables.MarkProductBatch mpb =  com.agri.mis.db.tables.MarkProductBatch.MARK_PRODUCT_BATCH;
        com.agri.mis.db.tables.MarkProductCycleExpense pce = com.agri.mis.db.tables.MarkProductCycleExpense.MARK_PRODUCT_CYCLE_EXPENSE;
        com.agri.mis.db.tables.MarkProductCycle us = com.agri.mis.db.tables.MarkProductCycle.MARK_PRODUCT_CYCLE;

        Condition where = DSL.trueCondition();

        if(StringUtils.hasLength(name)){
            where = where.and(pce.CALC_UNIT.eq(name));
        }
        var dataSql = context.select(
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
                mpb.STATUS,
                pce.CYCLE_ID,
                pce.INVEST_PRODUCT_NAME,
                pce.DESCRIPTION,
                pce.AMOUNT,
                pce.PRICE,
                pce.QUANTITY,
                pce.PRODUCT_BATCH_ID,
                pce.ID,
                pce.CALC_UNIT,
                pce.EXPENSE_TYPE,
                us.ID,
                us.NAME,
                us.DESCRIPTION,
                us.IMAGE_URL,
                us.PRODUCT_BATCH_ID,
                us.DAYS,
                us.AMOUNT,
                us.PARENT_ID,
                us.START_AT,
                us.END_AT
        ).from(pce).leftJoin(mpb).on(pce.PRODUCT_BATCH_ID.eq(mpb.ID)).rightJoin(us).on(pce.CYCLE_ID.eq(us.ID)).where(where).limit(pageRequest.getOffset(),pageRequest.getPageSize());
        var countSql =  context.select(DSL.field("count(*)", SQLDataType.BIGINT))
                .from(pce)
                .where(where);
        return Mono.zip(Flux.from(dataSql)
                        .map(r->{

                           MarkProductCycleExpense markProductCycleExpense = new MarkProductCycleExpense(
                                   r.getValue(pce.CYCLE_ID) ,
                                   r.getValue(pce.INVEST_PRODUCT_NAME),
                                   r.getValue(pce.DESCRIPTION) ,
                                   r.getValue(pce.AMOUNT),
                                   r.getValue(pce.PRICE),
                                   r.getValue(pce.QUANTITY),
                                   r.getValue(pce.PRODUCT_BATCH_ID),
                                   r.getValue(pce.ID),
                                   r.getValue(pce.CALC_UNIT),
                                   r.getValue(pce.EXPENSE_TYPE)
                           );

                            if(null!=markProductCycleExpense.getId()){
                                MarkProductCycle cycle = new MarkProductCycle(
                                        r.getValue(us.ID),r.getValue(us.NAME),
                                        r.getValue(us.DESCRIPTION),r.getValue(us.IMAGE_URL)
                                        ,r.getValue(us.PRODUCT_BATCH_ID),r.getValue(us.DAYS)
                                        ,r.getValue(us.AMOUNT),r.getValue(us.PARENT_ID)
                                        ,r.getValue(us.START_AT),r.getValue(us.END_AT));
                                MarkProductBatch markProduct = new MarkProductBatch(
                                        r.getValue(mpb.ID),r.getValue(mpb.NAME),
                                        r.getValue(mpb.CODE),r.getValue(mpb.PRODUCT_ID)
                                        ,r.getValue(mpb.START_AT),r.getValue(mpb.END_AT)
                                        ,r.getValue(mpb.DAYS),r.getValue(mpb.CREATED_TYPE)
                                        ,r.getValue(mpb.PRODUCTION),r.getValue(mpb.INVEST)
                                        ,r.getValue(mpb.SALE_PRICE),r.getValue(mpb.UNIT)
                                        ,r.getValue(mpb.CREATED_AT),r.getValue(mpb.CREATED_BY)
                                        ,r.getValue(mpb.CREATED_USER_ID),r.getValue(mpb.DESCRIPTION)
                                        ,r.getValue(mpb.STATUS));

                                return new MarkProductCycleExpenseWithProductBatchWithCycle(markProductCycleExpense,cycle,markProduct);
                            }else{
                                return new MarkProductCycleExpenseWithProductBatchWithCycle(markProductCycleExpense,null,null);
                            }

                        }).collectList(),Mono.from(countSql).map(Record1::value1))
                .map(it -> new PageImpl<>(it.getT1(),pageRequest,it.getT2()));
    }

}
