package com.agri.mis.service;

import com.agri.mis.domain.BatchProduct;

import com.agri.mis.domain.Corp;
import com.agri.mis.domain.CorpPark;
import com.agri.mis.domain.Product;
import com.agri.mis.repository.BatchProductRepository;
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
        com.agri.mis.db.tables.Product pt =  com.agri.mis.db.tables.Product.PRODUCT;
        com.agri.mis.db.tables.CorpPark pk =  com.agri.mis.db.tables.CorpPark.CORP_PARK;

        Condition where = DSL.trueCondition();
        if (StringUtils.hasLength(name)) {
            where = where.and(bp.NAME.like("%" + name + "%"));
        }
        var dataSql = dslContext.select(
                bp.ID, bp.NAME, bp.CODE, bp.PRODUCT_ID, bp.START_AT, bp.END_AT, bp.DAYS, bp.PRODUCTION_ESTIMATED, bp.PRODUCTION_REAL,
                bp.INVEST_ESTIMATED, bp.INVEST_REAL, bp.CORP_ID, bp.CALC_UNIT, bp.PARK_ID, bp.CREATED_USER_ID,
                bp.CREATED_AT, bp.DESCRIPTION, bp.STATUS,
                ct.ID, ct.NAME, ct.CODE, pt.ID, pt.NAME, pt.CODE, pt.IMAGE_URL, pk.ID, pk.NAME
        ).from(bp).leftJoin(ct).on(bp.CORP_ID.eq(ct.ID)).leftJoin(pt).on(bp.PRODUCT_ID.eq(pt.ID)).leftJoin(pk).on(bp.PARK_ID.eq(pk.ID)).where(where).limit(pageRequest.getOffset(), pageRequest.getPageSize());
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
                                      r.getValue(bp.CREATED_AT),
                                      r.getValue(bp.DESCRIPTION),
                                      r.getValue(bp.STATUS),
                                      null, null, null);

                              if (null != batchProduct.getCorpId()){
                                  Corp corp = new Corp();
                                  corp.setId(batchProduct.getCorpId());
                                  corp.setName(r.getValue(ct.NAME));
                                  corp.setCode(r.getValue(ct.CODE));

                                     batchProduct.setCorp(corp);
                              }
                              if (null != batchProduct.getProductId()){
                                  Product product = new Product();
                                  product.setId(batchProduct.getCorpId());
                                  product.setName(r.getValue(ct.NAME));
                                  product.setCode(r.getValue(ct.CODE));

                                  batchProduct.setProduct(product);
                              }
                              if (null != batchProduct.getParkId()){
                                  CorpPark corpPark = new CorpPark();
                                  corpPark.setId(batchProduct.getParkId());
                                  corpPark.setName(r.getValue(pk.NAME));

                                  batchProduct.setPark(corpPark);
                              }
                              return batchProduct;

                          }).collectList(),Mono.from(countSql).map(Record1::value1)
          ).map(it -> new PageImpl<>(it.getT1(),pageRequest, it.getT2()));


    }
}
