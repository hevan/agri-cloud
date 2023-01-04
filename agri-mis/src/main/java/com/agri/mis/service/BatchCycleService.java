package com.agri.mis.service;


import com.agri.mis.domain.BatchCycle;
import com.agri.mis.domain.BatchProduct;
import com.agri.mis.repository.BatchCycleRepository;
import lombok.val;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Field;
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

import java.time.OffsetDateTime;

@Service
public class BatchCycleService {
    // 接口类
    @Autowired
    private BatchCycleRepository batchCycleRepository;
    // 多表查询
    @Autowired
    private DSLContext dslContext;

    // 根据id查询数据
    public Mono<BatchCycle> findById(Long id) {
        return batchCycleRepository.findById(id);
    }

    // 分页查询
    public Mono<Page<BatchCycle>> pageQuery(String name, PageRequest pageRequest) {

        com.agri.mis.db.tables.BatchCycle bc = com.agri.mis.db.tables.BatchCycle.BATCH_CYCLE;
        com.agri.mis.db.tables.BatchProduct bp = com.agri.mis.db.tables.BatchProduct.BATCH_PRODUCT;
        Condition where = DSL.trueCondition();
        if (StringUtils.hasLength(name)) {
            where = where.and(bc.NAME.like("%" + name + "%"));
        }
        var dataSql = dslContext.select(
                bc.ID,
                bc.NAME,
                bc.DESCRIPTION,
                bc.IMAGE_URL,
                bc.DAYS,
                bc.START_AT,
                bc.END_AT,
                bc.BATCH_ID,
                bc.STATUS,
                bc.PARENT_ID, bc.PROGRESS, bc.CREATED_USER_ID, bc.CREATED_BY, bc.CREATED_AT, bc.CYCLE_TYPE,
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
                bp.STATUS
        ).from(bc).leftJoin(bp).on(bc.BATCH_ID.eq(bp.ID)).where(where).limit(pageRequest.getOffset(), pageRequest.getPageSize());

        val countSql = dslContext.select(DSL.field("count(*)", SQLDataType.BIGINT))
                .from(bc)
                .where(where);
        return Mono.zip(
                Flux.from(dataSql).map(r -> {
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
                            r.getValue( bc.CREATED_AT),
                            r.getValue(bc.CYCLE_TYPE),null);

                    if (null != batchCycle.getBatchId()) {
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
                                r.getValue(bp.STATUS),null);
                        batchCycle.setBatchProduct(batchProduct);
                    }
                    return batchCycle;
                }).collectList(),Mono.from(countSql).map(Record1::value1)
        ).map(it -> new PageImpl<>(it.getT1(),pageRequest, it.getT2()));

    }




    // 根据id删除数据
    public Mono<Void> delete(BatchCycle batchCycle) {
        return batchCycleRepository.delete(batchCycle);
    }

     // 添加数据
    public Mono<BatchCycle> add(BatchCycle batchCycle) {
        return batchCycleRepository.save(batchCycle);
    }

    // 根据id修改数据
    public Mono<BatchCycle> update(Long id, BatchCycle batchCycle) {
        return batchCycleRepository.findById(id).flatMap(
                s ->{
                    batchCycle.setId(s.getId());
                    return batchCycleRepository.save(batchCycle);
                }
        );
    }
}
