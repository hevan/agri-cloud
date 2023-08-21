package com.agri.mis.service;

import com.agri.mis.domain.*;
import com.agri.mis.dto.BatchProductDto;
import com.agri.mis.dto.ParkBaseDto;
import com.agri.mis.repository.BatchBaseRepository;
import lombok.val;
import org.jooq.*;
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

import static org.jooq.impl.DSL.select;

@Service
public class BatchBaseService {

    @Autowired
    private BatchBaseRepository repository;

    @Autowired
    private DSLContext dslContext;

    public Mono<BatchBase> findById(Long id){

        com.agri.mis.db.tables.BatchBase bb = com.agri.mis.db.tables.BatchBase.BATCH_BASE;
        com.agri.mis.db.tables.CorpPark c = com.agri.mis.db.tables.CorpPark.CORP_PARK;
        com.agri.mis.db.tables.CorpParkBase cb = com.agri.mis.db.tables.CorpParkBase.CORP_PARK_BASE;
        com.agri.mis.db.tables.BatchProduct bp = com.agri.mis.db.tables.BatchProduct.BATCH_PRODUCT;
        com.agri.mis.db.tables.Product p = com.agri.mis.db.tables.Product.PRODUCT;
        Condition where = DSL.trueCondition();

            where = where.and(bb.ID.eq(id));


        var PARK_BASE_VIEW = dslContext.select(cb.ID, cb.NAME, c.ID, c.NAME).from(cb).leftJoin(c).on(cb.PARK_ID.eq(c.ID)).asTable();
        var BATCH_PRODUCT_VIEW = dslContext.select(bp.ID, bp.NAME, p.ID, p.NAME).from(bp).leftJoin(p).on(bp.PRODUCT_ID.eq(p.ID)).asTable();

        var dataSql = dslContext.select(
                bb.ID,
                bb.BATCH_ID,
                bb.PARK_BASE_ID,
                bb.AREA,
                bb.QUANTITY,
                bb.DESCRIPTION,
                bb.CREATED_AT,
                bb.CORP_ID,
                bb.IMAGE_URL,
                PARK_BASE_VIEW.field(1),
                PARK_BASE_VIEW.field(2),
                PARK_BASE_VIEW.field(3),
                PARK_BASE_VIEW.field(4),
                BATCH_PRODUCT_VIEW.field(1),
                BATCH_PRODUCT_VIEW.field(2),
                BATCH_PRODUCT_VIEW.field(3),
                BATCH_PRODUCT_VIEW.field(4)
        ).from(bb).leftJoin(PARK_BASE_VIEW).on(bb.PARK_BASE_ID.eq((Field<Long>) PARK_BASE_VIEW.field(1))).leftJoin(BATCH_PRODUCT_VIEW).on(bb.BATCH_ID.eq((Field<Long>)  BATCH_PRODUCT_VIEW.field(1))).where(where);

        return
                Mono.from(dataSql).map(r -> {
                    BatchBase batchBase = new BatchBase();
                    batchBase.setId(r.get(bb.ID));
                    batchBase.setBatchId(r.get(bb.BATCH_ID));
                    batchBase.setParkBaseId(r.get(bb.PARK_BASE_ID));
                    batchBase.setArea(r.get(bb.AREA));
                    batchBase.setQuantity(r.get(bb.QUANTITY));
                    batchBase.setDescription(r.get(bb.DESCRIPTION));
                    batchBase.setCreatedAt(r.get(bb.CREATED_AT));
                    batchBase.setCorpId(r.get(bb.CORP_ID));
                    batchBase.setImageUrl(r.get(bb.IMAGE_URL));

                    if (null != batchBase.getBatchId()) {
                        BatchProductDto batchProductDto = new BatchProductDto();
                        batchProductDto.setBatchId((Long) r.get(PARK_BASE_VIEW.field(1)));
                        batchProductDto.setBatchName((String) r.get(PARK_BASE_VIEW.field(2)));
                        batchProductDto.setProductId((Long) r.get(PARK_BASE_VIEW.field(3)));
                        batchProductDto.setProductName((String) r.get(PARK_BASE_VIEW.field(4)));
                        batchBase.setBatchProductDto(batchProductDto);
                    }

                    if (null != batchBase.getParkBaseId()) {
                        ParkBaseDto parkBaseDto = new ParkBaseDto();
                        parkBaseDto.setParkId((Long) r.get(PARK_BASE_VIEW.field(3)));
                        parkBaseDto.setParkName((String) r.get(PARK_BASE_VIEW.field(4)));
                        parkBaseDto.setParkBaseId((Long) r.get(PARK_BASE_VIEW.field(1)));
                        parkBaseDto.setParkBaseName((String) r.get(PARK_BASE_VIEW.field(2)));
                        batchBase.setParkBaseDto(parkBaseDto);
                    }
                    return batchBase;
                });
    }

    public Mono<BatchBase> add(BatchBase batchBase) {
        return repository.save(batchBase);
    }

    public Mono<BatchBase> update(Long id, BatchBase batchBase) {
      return repository.findById(id).flatMap(
              r ->{
                  batchBase.setBatchId(r.getId());
                  return repository.save(batchBase);
              }
      );
    }

    public Mono<Void> delete(BatchBase batchBase) {
        return  repository.delete(batchBase);
    }


    public Mono<Page<BatchBase>> pageQuery(BatchBase batchBaseParam, PageRequest pageRequest) {

        com.agri.mis.db.tables.BatchBase bb = com.agri.mis.db.tables.BatchBase.BATCH_BASE;
        com.agri.mis.db.tables.CorpPark c = com.agri.mis.db.tables.CorpPark.CORP_PARK;
        com.agri.mis.db.tables.CorpParkBase cb = com.agri.mis.db.tables.CorpParkBase.CORP_PARK_BASE;
        com.agri.mis.db.tables.BatchProduct bp = com.agri.mis.db.tables.BatchProduct.BATCH_PRODUCT;
        com.agri.mis.db.tables.Product p = com.agri.mis.db.tables.Product.PRODUCT;
        Condition where = DSL.trueCondition();

        if (null != batchBaseParam.getBatchId()) {
            where = where.and(bb.BATCH_ID.eq(batchBaseParam.getBatchId()));
        }

        if (null != batchBaseParam.getParkBaseId()) {
            where = where.and(bb.PARK_BASE_ID.eq(batchBaseParam.getParkBaseId()));
        }

        if (null != batchBaseParam.getCorpId()) {
            where = where.and(bb.CORP_ID.eq(batchBaseParam.getCorpId()));
        }

        var PARK_BASE_VIEW = dslContext.select(cb.ID, cb.NAME, c.ID.as("parkId"), c.NAME.as("parkName")).from(cb).leftJoin(c).on(cb.PARK_ID.eq(c.ID)).asTable();
        var BATCH_PRODUCT_VIEW = dslContext.select(bp.ID, bp.NAME, p.ID.as("productId"), p.NAME.as("productName")).from(bp).leftJoin(p).on(bp.PRODUCT_ID.eq(p.ID)).asTable();

        var dataSql = dslContext.select(
                bb.ID,
                bb.BATCH_ID,
                bb.PARK_BASE_ID,
                bb.AREA,
                bb.QUANTITY,
                bb.DESCRIPTION,
                bb.CREATED_AT,
                bb.CORP_ID,
                bb.IMAGE_URL,
                PARK_BASE_VIEW.field(0),
                PARK_BASE_VIEW.field(1),
                PARK_BASE_VIEW.field(2),
                PARK_BASE_VIEW.field(3),
                BATCH_PRODUCT_VIEW.field(0),
                BATCH_PRODUCT_VIEW.field(1),
                BATCH_PRODUCT_VIEW.field(2),
                BATCH_PRODUCT_VIEW.field(3)
        ).from(bb).leftJoin(PARK_BASE_VIEW).on(bb.PARK_BASE_ID.eq((Field<Long>) PARK_BASE_VIEW.field(0))).leftJoin(BATCH_PRODUCT_VIEW).on(bb.BATCH_ID.eq((Field<Long>)  BATCH_PRODUCT_VIEW.field(0))).where(where).limit(pageRequest.getOffset(), pageRequest.getPageSize());

        val countSql = dslContext.select(DSL.field("count(*)", SQLDataType.BIGINT))
                .from(bb)
                .where(where);
        return Mono.zip(
                Flux.from(dataSql).map(r -> {
                    BatchBase batchBase = new BatchBase();
                    batchBase.setId(r.get(bb.ID));
                    batchBase.setBatchId(r.get(bb.BATCH_ID));
                    batchBase.setParkBaseId(r.get(bb.PARK_BASE_ID));
                    batchBase.setArea(r.get(bb.AREA));
                    batchBase.setQuantity(r.get(bb.QUANTITY));
                    batchBase.setDescription(r.get(bb.DESCRIPTION));
                    batchBase.setCreatedAt(r.get(bb.CREATED_AT));
                    batchBase.setCorpId(r.get(bb.CORP_ID));
                    batchBase.setImageUrl(r.get(bb.IMAGE_URL));

                    if (null != batchBase.getBatchId()) {
                        BatchProductDto batchProductDto = new BatchProductDto();
                        batchProductDto.setBatchId((Long) r.get(BATCH_PRODUCT_VIEW.field(0)));
                        batchProductDto.setBatchName((String) r.get(BATCH_PRODUCT_VIEW.field(1)));
                        batchProductDto.setProductId((Long) r.get(BATCH_PRODUCT_VIEW.field(2)));
                        batchProductDto.setProductName((String) r.get(BATCH_PRODUCT_VIEW.field(3)));
                        batchBase.setBatchProductDto(batchProductDto);
                    }

                    if (null != batchBase.getParkBaseId()) {
                        ParkBaseDto parkBaseDto = new ParkBaseDto();
                        parkBaseDto.setParkId((Long) r.get(PARK_BASE_VIEW.field(2)));
                        parkBaseDto.setParkName((String) r.get(PARK_BASE_VIEW.field(3)));
                        parkBaseDto.setParkBaseId((Long) r.get(PARK_BASE_VIEW.field(0)));
                        parkBaseDto.setParkBaseName((String) r.get(PARK_BASE_VIEW.field(1)));
                        batchBase.setParkBaseDto(parkBaseDto);
                    }
                    return batchBase;
                }).collectList(),Mono.from(countSql).map(Record1::value1)
        ).map(it -> new PageImpl<>(it.getT1(),pageRequest, it.getT2()));


    }


}
