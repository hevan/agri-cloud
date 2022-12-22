package com.agri.mis.service;

import com.agri.mis.domain.*;
import com.agri.mis.db.tables.Users;
import com.agri.mis.dto.MarkProductBatchWithProductWithCreatedUser;

import com.agri.mis.repository.MarkProductBatchRepository;
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
public class MarkProductBatchService {

    @Autowired
    private MarkProductBatchRepository repository;

    @Autowired
    private DSLContext context;

    public Mono<MarkProductBatch> findById(Long id){
        return repository.findById(id);
    }

    public Mono<MarkProductBatch> add(MarkProductBatch markProductBatch){
        return repository.save(markProductBatch);
    }

    public Mono<MarkProductBatch> update(Long id,MarkProductBatch productBatch){
        return repository.findById(id).flatMap(
                r->{
                    productBatch.setId(r.getId());
                    return repository.save(productBatch);
                }
        );
    }

    public Mono<Void> delete(MarkProductBatch markProductBatch){
        return repository.delete(markProductBatch);
    }

    public Mono<Page<MarkProductBatchWithProductWithCreatedUser>> pageQuery(String name, PageRequest pageRequest){
        com.agri.mis.db.tables.MarkProductBatch mpb =  com.agri.mis.db.tables.MarkProductBatch.MARK_PRODUCT_BATCH;
        com.agri.mis.db.tables.Product pt = com.agri.mis.db.tables.Product.PRODUCT;
        com.agri.mis.db.tables.Users us = com.agri.mis.db.tables.Users.USERS;

        Condition where = DSL.trueCondition();

        if(StringUtils.hasLength(name)){
            where = where.and(mpb.NAME.like("%"+name+"%"));
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
                us.USERNAME,
                us.PASSWORD,
                us.MOBILE,
                us.SIGN_TEXT,
                us.ENABLED,
                us.CREATED_AT,
                us.HEADER_URL,
                us.NICK_NAME,
                us.DESCRIPTION
        ).from(mpb).leftJoin(pt).on(mpb.PRODUCT_ID.eq(pt.ID)).rightJoin(us).on(mpb.CREATED_USER_ID.eq(us.ID)).where(where).limit(pageRequest.getOffset(),pageRequest.getPageSize());
        var countSql =  context.select(DSL.field("count(*)", SQLDataType.BIGINT))
                .from(mpb)
                .where(where);
        return Mono.zip(Flux.from(dataSql)
                        .map(r->{
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
                            if(null!=markProduct.getId()){
                                Product product = new Product(
                                        r.getValue(pt.ID),r.getValue(pt.NAME)
                                        ,r.getValue(pt.CODE),r.getValue(pt.CATEGORY_ID),r.getValue(pt.IMAGE_URL),
                                        r.getValue(pt.CALC_UNIT),r.getValue(pt.CORP_ID),
                                        r.getValue(pt.CREATED_AT),r.getValue(pt.CREATED_BY),
                                        r.getValue(pt.UPDATED_AT),r.getValue(pt.UPDATED_BY),
                                        r.getValue(pt.DESCRIPTION)
                                        );
                                User user = new User(
                                        r.getValue(us.ID),r.getValue(us.USERNAME),
                                        r.getValue(us.PASSWORD),r.getValue(us.MOBILE),
                                        r.getValue(us.NICK_NAME),r.getValue(us.HEADER_URL),
                                        r.getValue(us.DESCRIPTION),r.getValue(us.ENABLED),
                                        r.getValue(us.SIGN_TEXT),
                                        r.getValue(us.CREATED_AT)
                                   );
                                return new MarkProductBatchWithProductWithCreatedUser(markProduct,product,user);
                            }else{
                                return new MarkProductBatchWithProductWithCreatedUser(markProduct,null,null);
                            }

                        }).collectList(),Mono.from(countSql).map(Record1::value1))
                .map(it -> new PageImpl<>(it.getT1(),pageRequest,it.getT2()));
    }
}
