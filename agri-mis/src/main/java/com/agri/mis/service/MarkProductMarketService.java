package com.agri.mis.service;

import com.agri.mis.db.tables.MarkMarket;
import com.agri.mis.domain.MarkProductBatch;
import com.agri.mis.domain.MarkProductCycle;
import com.agri.mis.domain.MarkProductMarket;
import com.agri.mis.domain.Product;
import com.agri.mis.dto.MarkProductCycleWithPproductBatchWithParent;
import com.agri.mis.dto.MarkProductMarketWithProductWithMarket;
import com.agri.mis.repository.MarkProductMarketRepository;

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

@Service
public class MarkProductMarketService {

    @Autowired
    private MarkProductMarketRepository repository;

    @Autowired
    private DSLContext context;

    public Mono<MarkProductMarket> findById(Long id){
        return repository.findById(id);
    }

    public Mono<MarkProductMarket> add(MarkProductMarket markProductCycle){
        return repository.save(markProductCycle);
    }

    public Mono<MarkProductMarket> update(Long id,MarkProductMarket markProductCycle){
        return repository.findById(id).flatMap(
                r->{
                    markProductCycle.setId(r.getId());
                    return repository.save(markProductCycle);
                }
        );
    }

    public Mono<Void> delete(MarkProductMarket markProductCycle){
        return repository.delete(markProductCycle);
    }

    public Mono<Page<MarkProductMarketWithProductWithMarket>> pageQuery(String unit, PageRequest pageRequest){
            com.agri.mis.db.tables.MarkProductMarket mpb =  com.agri.mis.db.tables.MarkProductMarket.MARK_PRODUCT_MARKET;
        com.agri.mis.db.tables.Product pt = com.agri.mis.db.tables.Product.PRODUCT;
        com.agri.mis.db.tables.MarkMarket us = com.agri.mis.db.tables.MarkMarket.MARK_MARKET;
        Condition where = DSL.trueCondition();
        if(StringUtils.hasLength(unit)){
            where = where.and(mpb.UNIT.eq(unit));
        }
        var dataSql = context.select(
                mpb.PRODUCT_ID,
                mpb.PRICE_WHOLESALE,
                mpb.UNIT,
                mpb.ID,
                mpb.OCCUR_AT,
                mpb.PRICE_RETAL,
                mpb.MARKET_ID,
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
                us.ADDRESS_ID,
                us.CATEGORY_ID,
                us.NAME
        ).from(mpb).leftJoin(pt).on(mpb.PRODUCT_ID.eq(pt.ID)).rightJoin(us).on(mpb.MARKET_ID.eq(us.ID)).where(where).limit(pageRequest.getOffset(),pageRequest.getPageSize());
        var countSql =  context.select(DSL.field("count(*)", SQLDataType.BIGINT))
                .from(mpb)
                .where(where);
        return Mono.zip(Flux.from(dataSql)
                        .map(r->{
                            MarkProductMarket markProductMarket = new MarkProductMarket(
                                    r.getValue(mpb.PRODUCT_ID),r.getValue(mpb.PRICE_WHOLESALE),
                                    r.getValue(mpb.UNIT),r.getValue(mpb.ID),
                                    r.getValue(mpb.OCCUR_AT),r.getValue(mpb.PRICE_RETAL),
                                    r.getValue(mpb.MARKET_ID));
                            if(null!=markProductMarket.getId()){
                                Product product = new Product(
                                        r.getValue(pt.ID),r.getValue(pt.NAME)
                                        ,r.getValue(pt.CODE),r.getValue(pt.CATEGORY_ID),r.getValue(pt.IMAGE_URL),
                                        r.getValue(pt.CALC_UNIT),r.getValue(pt.CORP_ID),
                                        r.getValue(pt.CREATED_AT),r.getValue(pt.CREATED_BY),
                                        r.getValue(pt.UPDATED_AT),r.getValue(pt.UPDATED_BY),
                                        r.getValue(pt.DESCRIPTION)
                                );
                               com.agri.mis.domain.MarkMarket markMarket1 = new com.agri.mis.domain.MarkMarket(r.getValue(us.ID),
                                       r.getValue(us.NAME),
                                       r.getValue(us.ADDRESS_ID),
                                       r.getValue(us.CATEGORY_ID)
                               );
                                return new MarkProductMarketWithProductWithMarket(markProductMarket,product,markMarket1);
                            }else{
                                return new MarkProductMarketWithProductWithMarket(markProductMarket,null,null);
                            }
                        }).collectList(),Mono.from(countSql).map(Record1::value1))
                .map(it -> new PageImpl<>(it.getT1(),pageRequest,it.getT2()));
    }
}
