package com.agri.mis.service;

import com.agri.mis.domain.Address;
import com.agri.mis.domain.BatchProduct;

import com.agri.mis.domain.Corp;
import com.agri.mis.repository.BatchProductRepository;
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
public class BatchProductService {
    @Autowired
    private BatchProductRepository batchProductRepository;
    // 多表查询
    @Autowired
    private DSLContext dslContext;

    // 根据id查询数据
    public Mono<BatchProduct> findById(Long id) {
        return batchProductRepository.findById(id);
    }

    // 添加数据
    public Mono<BatchProduct> add(BatchProduct batchProduct) {
        return batchProductRepository.save(batchProduct);
    }

    // 根据id修该数据
    public Mono<BatchProduct> update(Long id, BatchProduct batchProduct) {
        return batchProductRepository.findById(id).flatMap(
                s -> {
                    batchProduct.setId(s.getId());
                    return batchProductRepository.save(batchProduct);
                }
        );
    }

   // 根据id删除数据
    public Mono<Void> delete(BatchProduct batchProduct) {
        return batchProductRepository.delete(batchProduct);
    }

    public Mono<Page<BatchProduct>> pageQuery(String name, PageRequest pageRequest) {
        com.agri.mis.db.tables.BatchProduct bp = com.agri.mis.db.tables.BatchProduct.BATCH_PRODUCT;
        com.agri.mis.db.tables.Corp ct =  com.agri.mis.db.tables.Corp.CORP;
        com.agri.mis.db.tables.Address at = com.agri.mis.db.tables.Address.ADDRESS;
        Condition where = DSL.trueCondition();
        if (StringUtils.hasLength(name)) {
            where = where.and(bp.NAME.like("%" + name + "%"));
        }
        var dataSql = dslContext.select(
                bp.ID, bp.NAME, bp.CODE, bp.PRODUCT_ID, bp.START_AT, bp.END_AT, bp.DAYS, bp.PRODUCTION_ESTIMATED, bp.PRODUCTION_REAL,
                bp.INVEST_ESTIMATED, bp.INVEST_REAL, bp.CORP_ID, bp.CALC_UNIT, bp.PARK_ID, bp.CREATED_USER_ID, bp.CREATED_BY,
                bp.CREATED_AT, bp.DESCRIPTION, bp.QUANTITY, bp.STATUS,
                ct.ID, ct.NAME, ct.CODE, ct.DESCRIPTION, ct.ADDRESS_ID,ct.CREATED_AT,
                at.ID, at.PROVINCE, at.CITY, at.REGION, at.LINE_DETAIL, at.LINK_NAME, at.LINK_MOBILE
        ).from(bp).leftJoin(ct).on(bp.CORP_ID.eq(ct.ID)).rightJoin(at).on(ct.ADDRESS_ID.eq(at.ID)).where(where).limit(pageRequest.getOffset(), pageRequest.getPageSize());
        val countSql = dslContext.select(DSL.field("count(*)", SQLDataType.BIGINT))
                .from(bp)
                .where(where);
          return Mono.zip(
                  Flux.from(dataSql).map(
                          r ->{
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

                              if (null != batchProduct.getCorpId()){
                                  Corp corp = new Corp(r.getValue(ct.ID), r.getValue(ct.NAME), r.getValue(ct.CODE), r.getValue(ct.DESCRIPTION), r.getValue(ct.ADDRESS_ID), r.getValue(ct.CREATED_AT), null);
                                  if(null!=corp.getAddressId()){
                                      Address address = new Address(r.getValue(at.ID), r.getValue(at.PROVINCE), r.getValue(at.CITY), r.getValue(at.REGION), r.getValue(at.LINE_DETAIL), r.getValue(at.LINK_NAME), r.getValue(at.LINK_MOBILE), null, r.getValue(at.CREATED_AT));
                                      corp.setAddress(address);
                                  }
                                     batchProduct.setCorp(corp);
                              }
                              return batchProduct;

                          }).collectList(),Mono.from(countSql).map(Record1::value1)
          ).map(it -> new PageImpl<>(it.getT1(),pageRequest, it.getT2()));


    }
}
