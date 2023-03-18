package com.agri.mis.service;

import com.agri.mis.domain.*;
import com.agri.mis.repository.BatchBaseRepository;
import com.agri.mis.repository.BatchCycleExecuteRepository;
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
public class BatchCycleExecuteService {

    @Autowired
    private BatchCycleExecuteRepository repository;

    @Autowired
    private DSLContext dslContext;

    public Mono<BatchCycleExecute> findById(Long id){
        return repository.findById(id);
    }

   public Mono<BatchCycleExecute> add(BatchCycleExecute batchCycleExecute){
       return repository.save(batchCycleExecute);
   }

   public Mono<BatchCycleExecute> update(Long id,BatchCycleExecute batchCycleExecute){
       return repository.findById(id).flatMap(
               r ->{
                   batchCycleExecute.setId(r.getId());
                   return repository.save(batchCycleExecute);
               }
       );
   }

   public Mono<Void> delete(BatchCycleExecute batchCycleExecute){
        return repository.delete(batchCycleExecute);
   }

    public Mono<Page<BatchCycleExecute>> pageQuery(String name, PageRequest pageRequest) {
        com.agri.mis.db.tables.BatchCycleExecute bce = com.agri.mis.db.tables.BatchCycleExecute.BATCH_CYCLE_EXECUTE;

        com.agri.mis.db.tables.BatchCycle bc = com.agri.mis.db.tables.BatchCycle.BATCH_CYCLE;

        com.agri.mis.db.tables.BatchProduct bp =  com.agri.mis.db.tables.BatchProduct.BATCH_PRODUCT;

        Condition where = DSL.trueCondition();

        if(StringUtils.hasLength(name)){
            where = where.and(bce.NAME.like("%" + name +"%"));
        }
        var dataSql = dslContext.select(
                bce.ID,
                bce.NAME,
                bce.START_AT,
                bce.END_AT,
                bce.CREATED_USER_ID,
                bce.CREATED_BY,
                bce.BATCH_CYCLE_ID,
                bce.STATUS,
                bce.DESCRIPTION,
                bce.CREATED_AT,
                bce.PROGRESS,
                bce.CORP_ID,
                bce.BATCH_ID,


                bc.ID,
                bc.NAME,
                bc.DESCRIPTION,
                bc.IMAGE_URL,
                bc.START_AT,
                bc.END_AT,
                bc.STATUS,

                bp.ID,
                bp.NAME,
                bp.CODE,
                bp.STATUS
        ).from(bce).leftJoin(bc).on(bce.BATCH_CYCLE_ID.eq(bc.ID)).rightJoin(bp).on(bce.BATCH_ID.eq(bp.ID)).where(where).limit(pageRequest.getOffset(),pageRequest.getPageSize());
        val countSql = dslContext.select(DSL.field("count(*)", SQLDataType.BIGINT))
                .from(bce)
                .where(where);
        return Mono
                .zip(
                        Flux.from(dataSql)
                                .map(
                                        r->{
                                            BatchCycleExecute batchCycleExecute = new BatchCycleExecute(
                                                    r.getValue(bce.ID),
                                                    r.getValue(bce.NAME),
                                                    r.getValue(bce.START_AT),
                                                    r.getValue(bce.END_AT),
                                                    r.getValue(bce.CREATED_USER_ID),
                                                    r.getValue(bce.CREATED_BY),
                                                    r.getValue(bce.BATCH_CYCLE_ID),
                                                    r.getValue(bce.STATUS),
                                                    r.getValue(bce.DESCRIPTION),
                                                    r.getValue(bce.CREATED_AT),
                                                    r.getValue(bce.PROGRESS),
                                                    r.getValue(bce.CORP_ID),
                                                    r.getValue(bce.BATCH_ID),
                                                    null,
                                                    null);
                                            if(null!=batchCycleExecute.getBatchCycleId()){
                                                BatchCycle batchCycle = new BatchCycle();
                                                batchCycle.setId(batchCycleExecute.getBatchCycleId());
                                                batchCycle.setName(r.getValue(bc.NAME));
                                                batchCycle.setImageUrl(r.getValue(bc.IMAGE_URL));
                                                batchCycle.setDescription(r.getValue(bc.DESCRIPTION));
                                                batchCycle.setStartAt(r.getValue(bc.START_AT));
                                                batchCycle.setEndAt(r.getValue(bc.END_AT));
                                                batchCycle.setStatus(r.getValue(bc.STATUS));
                                                batchCycleExecute.setBatchCycle(batchCycle);
                                            }
                                            if(null!=batchCycleExecute.getBatchId()){
                                                BatchProduct batchProduct = new BatchProduct();
                                                batchProduct.setId(batchCycleExecute.getBatchId());
                                                batchProduct.setName(r.getValue(bp.NAME));
                                                batchProduct.setCode(r.getValue(bp.CODE));
                                                batchProduct.setStatus(r.getValue(bp.STATUS));
                                                batchCycleExecute.setBatchProduct(batchProduct);
                                            }

                                            return batchCycleExecute;
                                        }).collectList(),Mono.from(countSql).map(Record1::value1))
                .map(it -> new PageImpl<>(it.getT1(),pageRequest,it.getT2()));
    }
}
