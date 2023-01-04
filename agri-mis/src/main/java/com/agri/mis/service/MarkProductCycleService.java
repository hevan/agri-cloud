package com.agri.mis.service;

import com.agri.mis.domain.MarkProductBatch;
import com.agri.mis.domain.MarkProductCycle;
import com.agri.mis.domain.Product;
import com.agri.mis.domain.User;
import com.agri.mis.dto.MarkProductBatchWithProductWithCreatedUser;
import com.agri.mis.dto.MarkProductCycleWithPproductBatchWithParent;
import com.agri.mis.repository.MarkProductCycleRepository;
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
public class MarkProductCycleService {
    @Autowired
    private MarkProductCycleRepository repository;

    @Autowired
    private DSLContext context;

    public Mono<MarkProductCycle> findById(Long id){
        return repository.findById(id);
    }

    public Mono<MarkProductCycle> add(MarkProductCycle markProductCycle){
        return repository.save(markProductCycle);
    }

    public Mono<MarkProductCycle> update(Long id,MarkProductCycle markProductCycle){
        return repository.findById(id).flatMap(
                r->{
                    markProductCycle.setId(r.getId());
                    return repository.save(markProductCycle);
                }
        );
    }

    public Mono<Void> delete(MarkProductCycle markProductCycle){
        return repository.delete(markProductCycle);
    }

    public Mono<Page<MarkProductCycleWithPproductBatchWithParent>> pageQuery(String name, PageRequest pageRequest){
        com.agri.mis.db.tables.MarkProductBatch mpb =  com.agri.mis.db.tables.MarkProductBatch.MARK_PRODUCT_BATCH;
        com.agri.mis.db.tables.Product pt = com.agri.mis.db.tables.Product.PRODUCT;
        com.agri.mis.db.tables.MarkProductCycle us = com.agri.mis.db.tables.MarkProductCycle.MARK_PRODUCT_CYCLE;

        Condition where = DSL.trueCondition();

        if(StringUtils.hasLength(name)){
            where = where.and(us.NAME.like("%"+name+"%"));
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
                pt.ID,
                pt.NAME,
                pt.CODE,
                pt.CATEGORY_ID,
                pt.IMAGE_URL,
                pt.CALC_UNIT,
                pt.CORP_ID,
                pt.CREATED_AT,
                pt.CREATED_BY,
                pt.UPDATED_AT,
                pt.UPDATED_BY,
                pt.DESCRIPTION,
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
        ).from(us).leftJoin(mpb).on(us.PRODUCT_BATCH_ID.eq(mpb.ID)).rightJoin(pt).on(us.PARENT_ID.eq(pt.ID)).where(where).limit(pageRequest.getOffset(),pageRequest.getPageSize());
        var countSql =  context.select(DSL.field("count(*)", SQLDataType.BIGINT))
                .from(us)
                .where(where);
        return Mono.zip(Flux.from(dataSql)
                        .map(r->{
                            MarkProductCycle cycle = new MarkProductCycle(
                                    r.getValue(us.ID),r.getValue(us.NAME),
                                    r.getValue(us.DESCRIPTION),r.getValue(us.IMAGE_URL)
                                    ,r.getValue(us.PRODUCT_BATCH_ID),r.getValue(us.DAYS)
                                    ,r.getValue(us.AMOUNT),r.getValue(us.PARENT_ID)
                                    ,r.getValue(us.START_AT),r.getValue(us.END_AT)
                            );
                             if(null!=cycle.getId()){
                                Product product = new Product(
                                        r.getValue(pt.ID),r.getValue(pt.NAME)
                                        ,r.getValue(pt.CODE),r.getValue(pt.CATEGORY_ID),r.getValue(pt.IMAGE_URL),
                                        r.getValue(pt.CALC_UNIT),r.getValue(pt.CORP_ID),
                                        r.getValue(pt.CREATED_AT),r.getValue(pt.CREATED_BY),
                                        r.getValue(pt.UPDATED_AT),r.getValue(pt.UPDATED_BY),
                                        r.getValue(pt.DESCRIPTION)
                                );
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

                                return new MarkProductCycleWithPproductBatchWithParent(cycle,markProduct,product);
                            }else{
                                return new MarkProductCycleWithPproductBatchWithParent(cycle,null,null);
                            }

                        }).collectList(),Mono.from(countSql).map(Record1::value1))
                .map(it -> new PageImpl<>(it.getT1(),pageRequest,it.getT2()));
    }
}
