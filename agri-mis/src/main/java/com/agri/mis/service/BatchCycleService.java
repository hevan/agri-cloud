package com.agri.mis.service;


import com.agri.mis.domain.BatchCycle;
import com.agri.mis.domain.BatchProduct;
import com.agri.mis.repository.BatchCycleRepository;
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

    public Flux<BatchCycle> findAllByBatchId(Long batchId) {
        return batchCycleRepository.findAllByBatchId(batchId);
    }

    public Flux<BatchCycle> findAllByParentId(Long parentId) {
        return batchCycleRepository.findAllByParentId(parentId);
    }

    // 分页查询
    public Mono<Page<BatchCycle>> pageQuery(BatchCycle batchCycleParam, PageRequest pageRequest) {

        com.agri.mis.db.tables.BatchCycle bc = com.agri.mis.db.tables.BatchCycle.BATCH_CYCLE;
        com.agri.mis.db.tables.BatchProduct bp = com.agri.mis.db.tables.BatchProduct.BATCH_PRODUCT;
        Condition where = DSL.trueCondition();

        if (null != batchCycleParam.getBatchId()) {
            where = where.and(bc.BATCH_ID.eq(batchCycleParam.getBatchId()));
        }

        if (null != batchCycleParam.getCreatedUserId()) {
            where = where.and(bc.CREATED_USER_ID.eq(batchCycleParam.getCreatedUserId()));
        }

        if (null != batchCycleParam.getCorpId()) {
            where = where.and(bc.CORP_ID.eq(batchCycleParam.getCorpId()));
        }

        if (null != batchCycleParam.getStatus()) {
            where = where.and(bc.STATUS.eq(batchCycleParam.getStatus()));
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
                bc.PARENT_ID, bc.PROGRESS, bc.INVEST_ESTIMATED, bc.CREATED_USER_ID, bc.CREATED_AT, bc.CYCLE_TYPE, bc.CORP_ID,
                bp.ID,
                bp.NAME,
                bp.CODE
        ).from(bc).leftJoin(bp).on(bc.BATCH_ID.eq(bp.ID)).where(where).limit(pageRequest.getOffset(), pageRequest.getPageSize());

        val countSql = dslContext.select(DSL.field("count(*)", SQLDataType.BIGINT))
                .from(bc)
                .where(where);
        return Mono.zip(
                Flux.from(dataSql).map(r -> {
                    BatchCycle batchCycle = new BatchCycle();

                    batchCycle.setId(r.getValue(bc.ID));
                    batchCycle.setName(r.getValue(bc.NAME));
                    batchCycle.setDescription(r.getValue(bc.DESCRIPTION));
                    batchCycle.setImageUrl(r.getValue(bc.IMAGE_URL));
                    batchCycle.setDays(r.getValue(bc.DAYS));
                    batchCycle.setStartAt(r.getValue(bc.START_AT));
                    batchCycle.setEndAt(r.getValue(bc.END_AT));
                    batchCycle.setBatchId(r.getValue(bc.BATCH_ID));
                    batchCycle.setStatus(r.getValue(bc.STATUS));
                    batchCycle.setInvestEstimated(r.getValue(bc.INVEST_ESTIMATED));
                    batchCycle.setParentId(r.getValue(bc.PARENT_ID));
                    batchCycle.setProgress(r.getValue(bc.PROGRESS));
                    batchCycle.setCreatedUserId(r.getValue(bc.CREATED_USER_ID));
                    batchCycle.setCreatedAt(r.getValue( bc.CREATED_AT));
                    batchCycle.setCycleType(r.getValue(bc.CYCLE_TYPE));
                    batchCycle.setCorpId(r.getValue(bc.CORP_ID));

                    if (null != batchCycle.getBatchId()) {
                        BatchProduct batchProduct = new BatchProduct();
                        batchProduct.setId(batchCycle.getBatchId());
                        batchProduct.setName(r.getValue(bp.NAME));
                        batchProduct.setCode(r.getValue(bp.CODE));
                        batchCycle.setBatchProduct(batchProduct);
                    }
                    return batchCycle;
                }).collectList(),Mono.from(countSql).map(Record1::value1)
        ).map(it -> new PageImpl<>(it.getT1(),pageRequest, it.getT2()));

    }


    // 根据id删除数据
    public Mono<Void> delete(BatchCycle batchCycle) {

        return batchCycleRepository.delete(batchCycle).flatMap(s->{
             return batchCycleRepository.deleteAllByParentId(batchCycle.getId());
        });
    }

     // 添加数据
    public Mono<BatchCycle> add(BatchCycle batchCycle) {
        batchCycle.setEndAt(batchCycle.getStartAt().plusDays(batchCycle.getDays()));
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
