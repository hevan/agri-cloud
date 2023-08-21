package com.agri.mis.service;

import com.agri.mis.domain.MarkMarket;
import com.agri.mis.domain.MarkProduct;
import com.agri.mis.domain.MarkProductMarket;
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
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MarkProductMarketService {

    @Autowired
    private MarkProductMarketRepository repository;

    @Autowired
    private DSLContext context;

    public Mono<MarkProductMarket> findById(Long id){

        com.agri.mis.db.tables.MarkProductMarket mpb =  com.agri.mis.db.tables.MarkProductMarket.MARK_PRODUCT_MARKET;
        com.agri.mis.db.tables.MarkProduct pt = com.agri.mis.db.tables.MarkProduct.MARK_PRODUCT;
        com.agri.mis.db.tables.MarkMarket us = com.agri.mis.db.tables.MarkMarket.MARK_MARKET;
        Condition where = DSL.trueCondition();
        where = where.and(mpb.ID.eq(id));


        var dataSql = context.select(
                mpb.PRODUCT_ID,
                mpb.PRICE_WHOLESALE,
                mpb.CALC_UNIT,
                mpb.ID,
                mpb.OCCUR_AT,
                mpb.PRICE_RETAL,
                mpb.MARKET_ID,
                mpb.QUANTITY,
                pt.ID,
                pt.NAME,
                pt.CODE,
                pt.CATEGORY_ID,
                pt.IMAGE_URL,
                pt.CALC_UNIT,
                pt.DESCRIPTION,
                us.ID,
                us.ADDRESS_ID,
                us.MARKET_TYPE,
                us.NAME
        ).from(mpb).leftJoin(pt).on(mpb.PRODUCT_ID.eq(pt.ID)).rightJoin(us).on(mpb.MARKET_ID.eq(us.ID)).where(where);


        return Mono.from(dataSql)
                .map(r->{
                    MarkProductMarket markProductMarket = new MarkProductMarket();
                    markProductMarket.setId(r.getValue(mpb.ID));
                    markProductMarket.setProductId(r.getValue(mpb.PRODUCT_ID));
                    markProductMarket.setCalcUnit(r.getValue(mpb.CALC_UNIT));
                    markProductMarket.setOccurAt(r.getValue(mpb.OCCUR_AT));
                    markProductMarket.setPriceRetal(r.getValue(mpb.PRICE_RETAL));
                    markProductMarket.setQuantity(r.getValue(mpb.QUANTITY));
                    markProductMarket.setPriceWholesale(r.getValue(mpb.PRICE_WHOLESALE));
                    markProductMarket.setMarketId(r.getValue(mpb.MARKET_ID));

                    if(null!=markProductMarket.getProductId()) {
                        MarkProduct markProduct = new MarkProduct();
                        markProduct.setId(r.getValue(pt.ID));
                        markProduct.setName(r.getValue(pt.NAME));
                        markProduct.setCalcUnit(r.getValue(pt.CALC_UNIT));
                        markProduct.setCategoryId(r.getValue(pt.CATEGORY_ID));
                        markProduct.setImageUrl(r.getValue(pt.IMAGE_URL));
                        markProduct.setDescription(r.getValue(pt.DESCRIPTION));

                        markProductMarket.setProduct(markProduct);
                    }
                    if(null!=markProductMarket.getMarketId()) {
                        MarkMarket markMarket1 = new MarkMarket();
                        markMarket1.setMarketType(r.getValue(us.MARKET_TYPE));
                        markMarket1.setId(r.getValue(us.ID));
                        markMarket1.setName(r.getValue(us.NAME));
                        markMarket1.setAddressId(r.getValue(us.ADDRESS_ID));

                        markProductMarket.setMarket(markMarket1);

                    }

                    return markProductMarket;

                });
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

    public Mono<Page<MarkProductMarket>> pageQuery(MarkProductMarket markProductMarketParam, PageRequest pageRequest){
            com.agri.mis.db.tables.MarkProductMarket mpb =  com.agri.mis.db.tables.MarkProductMarket.MARK_PRODUCT_MARKET;
        com.agri.mis.db.tables.MarkProduct pt = com.agri.mis.db.tables.MarkProduct.MARK_PRODUCT;
        com.agri.mis.db.tables.MarkMarket us = com.agri.mis.db.tables.MarkMarket.MARK_MARKET;
        Condition where = DSL.trueCondition();
        if(null != markProductMarketParam.getProductId()){
            where = where.and(mpb.PRODUCT_ID.eq(markProductMarketParam.getProductId()));
        }
        if(null != markProductMarketParam.getMarketId()){
            where = where.and(mpb.MARKET_ID.eq(markProductMarketParam.getMarketId()));
        }
        var dataSql = context.select(
                mpb.PRODUCT_ID,
                mpb.PRICE_WHOLESALE,
                mpb.CALC_UNIT,
                mpb.ID,
                mpb.OCCUR_AT,
                mpb.PRICE_RETAL,
                mpb.MARKET_ID,
                mpb.QUANTITY,
                pt.ID,
                pt.NAME,
                pt.CODE,
                pt.CATEGORY_ID,
                pt.IMAGE_URL,
                pt.CALC_UNIT,
                pt.DESCRIPTION,
                us.ID,
                us.ADDRESS_ID,
                us.MARKET_TYPE,
                us.NAME
        ).from(mpb).leftJoin(pt).on(mpb.PRODUCT_ID.eq(pt.ID)).rightJoin(us).on(mpb.MARKET_ID.eq(us.ID)).where(where).limit(pageRequest.getOffset(),pageRequest.getPageSize());
        var countSql =  context.select(DSL.field("count(*)", SQLDataType.BIGINT))
                .from(mpb)
                .where(where);
        return Mono.zip(Flux.from(dataSql)
                        .map(r->{
                            MarkProductMarket markProductMarket = new MarkProductMarket();
                            markProductMarket.setId(r.getValue(mpb.ID));
                            markProductMarket.setProductId(r.getValue(mpb.PRODUCT_ID));
                            markProductMarket.setCalcUnit(r.getValue(mpb.CALC_UNIT));
                            markProductMarket.setOccurAt(r.getValue(mpb.OCCUR_AT));
                            markProductMarket.setPriceRetal(r.getValue(mpb.PRICE_RETAL));
                            markProductMarket.setQuantity(r.getValue(mpb.QUANTITY));
                            markProductMarket.setPriceWholesale(r.getValue(mpb.PRICE_WHOLESALE));
                            markProductMarket.setMarketId(r.getValue(mpb.MARKET_ID));

                            if(null!=markProductMarket.getProductId()) {
                                MarkProduct markProduct = new MarkProduct();
                                markProduct.setId(r.getValue(pt.ID));
                                markProduct.setName(r.getValue(pt.NAME));
                                markProduct.setCalcUnit(r.getValue(pt.CALC_UNIT));
                                markProduct.setCategoryId(r.getValue(pt.CATEGORY_ID));
                                markProduct.setImageUrl(r.getValue(pt.IMAGE_URL));
                                markProduct.setDescription(r.getValue(pt.DESCRIPTION));

                                markProductMarket.setProduct(markProduct);
                            }
                            if(null!=markProductMarket.getMarketId()) {
                                MarkMarket markMarket1 = new MarkMarket();
                                markMarket1.setMarketType(r.getValue(us.MARKET_TYPE));
                                markMarket1.setId(r.getValue(us.ID));
                                markMarket1.setName(r.getValue(us.NAME));
                                markMarket1.setAddressId(r.getValue(us.ADDRESS_ID));

                                markProductMarket.setMarket(markMarket1);

                            }

                      return markProductMarket;

                        }).collectList(),Mono.from(countSql).map(Record1::value1))
                .map(it -> new PageImpl<>(it.getT1(),pageRequest,it.getT2()));
    }
}
