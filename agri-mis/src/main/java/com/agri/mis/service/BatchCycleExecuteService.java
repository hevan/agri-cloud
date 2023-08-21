package com.agri.mis.service;

import com.agri.mis.domain.*;
import com.agri.mis.dto.CheckManager;
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

import static org.jooq.impl.DSL.select;

@Service
public class BatchCycleExecuteService {

    @Autowired
    private BatchCycleExecuteRepository repository;

    @Autowired
    private DSLContext dslContext;

    public Mono<BatchCycleExecute> findById(Long id){
        com.agri.mis.db.tables.BatchCycleExecute bce = com.agri.mis.db.tables.BatchCycleExecute.BATCH_CYCLE_EXECUTE;

        com.agri.mis.db.tables.BatchCycle bc = com.agri.mis.db.tables.BatchCycle.BATCH_CYCLE;
        com.agri.mis.db.tables.Users bu = com.agri.mis.db.tables.Users.USERS;

        Condition where = DSL.trueCondition();

        if(null != id){
            where = where.and(bce.ID.eq(id));
        }
        var dataSql = dslContext.select(
                bce.ID,
                bce.NAME,
                bce.START_AT,
                bce.END_AT,
                bce.CREATED_USER_ID,
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

                bu.ID,
                bu.NICK_NAME,
                bu.HEADER_URL,
                bu.MOBILE
        ).from(bce).leftJoin(bc).on(bce.BATCH_CYCLE_ID.eq(bc.ID)).rightJoin(bu).on(bce.CREATED_USER_ID.eq(bu.ID)).where(where);


        return   Mono.from(dataSql)
                .map(
                        r->{
            BatchCycleExecute batchCycleExecute = new BatchCycleExecute();
            batchCycleExecute.setId(r.getValue(bce.ID));
            batchCycleExecute.setName(r.getValue(bce.NAME));
            batchCycleExecute.setStartAt(r.getValue(bce.START_AT));
            batchCycleExecute.setEndAt(r.getValue(bce.END_AT));
            batchCycleExecute.setCreatedUserId(r.getValue(bce.CREATED_USER_ID));
            batchCycleExecute.setBatchCycleId(r.getValue(bce.BATCH_CYCLE_ID));
            batchCycleExecute.setStatus(r.getValue(bce.STATUS));
            batchCycleExecute.setDescription(r.getValue(bce.DESCRIPTION));
            batchCycleExecute.setCreatedAt(r.getValue(bce.CREATED_AT));
            batchCycleExecute.setProgress(r.getValue(bce.PROGRESS));
            batchCycleExecute.setCorpId(r.getValue(bce.CORP_ID));
            batchCycleExecute.setBatchId(r.getValue(bce.BATCH_ID));

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
            if(null!=batchCycleExecute.getCreatedUserId()){
                CheckManager checkManager = new CheckManager();
                checkManager.setUserId(batchCycleExecute.getCreatedUserId());
                checkManager.setNickName(r.getValue(bu.NICK_NAME));
                checkManager.setHeaderUrl(r.getValue(bu.HEADER_URL));
                checkManager.setMobile(r.getValue(bu.MOBILE));
                batchCycleExecute.setCreatedUser(checkManager);
            }

            return batchCycleExecute;
        });

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

    public Mono<Page<BatchCycleExecute>> pageQuery(BatchCycleExecute batchCycleExecuteParam, PageRequest pageRequest) {
        com.agri.mis.db.tables.BatchCycleExecute bce = com.agri.mis.db.tables.BatchCycleExecute.BATCH_CYCLE_EXECUTE;

        com.agri.mis.db.tables.BatchCycle bc = com.agri.mis.db.tables.BatchCycle.BATCH_CYCLE;
        com.agri.mis.db.tables.Users bu = com.agri.mis.db.tables.Users.USERS;

        Condition where = DSL.trueCondition();

        if(null != batchCycleExecuteParam.getBatchCycleId()){
            where = where.and(bce.BATCH_CYCLE_ID.eq(batchCycleExecuteParam.getBatchCycleId()).or(bce.BATCH_CYCLE_ID.in(select(bc.ID).from(bc).where(bc.PARENT_ID.eq(batchCycleExecuteParam.getBatchCycleId())))));
        }

        if(null != batchCycleExecuteParam.getBatchId()){
            where = where.and(bce.BATCH_ID.eq(batchCycleExecuteParam.getBatchId()));
        }

        if(null != batchCycleExecuteParam.getCreatedUserId()){
            where = where.and(bce.CREATED_USER_ID.eq(batchCycleExecuteParam.getCreatedUserId()));
        }

        if(null != batchCycleExecuteParam.getStatus()){
            where = where.and(bce.STATUS.eq(batchCycleExecuteParam.getStatus()));
        }

        var dataSql = dslContext.select(
                bce.ID,
                bce.NAME,
                bce.START_AT,
                bce.END_AT,
                bce.CREATED_USER_ID,
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

                bu.ID,
                bu.NICK_NAME,
                bu.HEADER_URL,
                bu.MOBILE
        ).from(bce).leftJoin(bc).on(bce.BATCH_CYCLE_ID.eq(bc.ID)).leftJoin(bu).on(bce.CREATED_USER_ID.eq(bu.ID)).where(where).limit(pageRequest.getOffset(),pageRequest.getPageSize());
        val countSql = dslContext.select(DSL.field("count(*)", SQLDataType.BIGINT))
                .from(bce)
                .where(where);
        return Mono
                .zip(
                        Flux.from(dataSql)
                                .map(
                                        r->{
                                            BatchCycleExecute batchCycleExecute = new BatchCycleExecute();
                                            batchCycleExecute.setId(r.getValue(bce.ID));
                                            batchCycleExecute.setName(r.getValue(bce.NAME));
                                            batchCycleExecute.setStartAt(r.getValue(bce.START_AT));
                                            batchCycleExecute.setEndAt(r.getValue(bce.END_AT));
                                            batchCycleExecute.setCreatedUserId(r.getValue(bce.CREATED_USER_ID));
                                            batchCycleExecute.setBatchCycleId(r.getValue(bce.BATCH_CYCLE_ID));
                                            batchCycleExecute.setStatus(r.getValue(bce.STATUS));
                                            batchCycleExecute.setDescription(r.getValue(bce.DESCRIPTION));
                                            batchCycleExecute.setCreatedAt(r.getValue(bce.CREATED_AT));
                                            batchCycleExecute.setProgress(r.getValue(bce.PROGRESS));
                                            batchCycleExecute.setCorpId(r.getValue(bce.CORP_ID));
                                            batchCycleExecute.setBatchId(r.getValue(bce.BATCH_ID));

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
                                            if(null!=batchCycleExecute.getCreatedUserId()){
                                                CheckManager checkManager = new CheckManager();
                                                checkManager.setUserId(batchCycleExecute.getCreatedUserId());
                                                checkManager.setNickName(r.getValue(bu.NICK_NAME));
                                                checkManager.setHeaderUrl(r.getValue(bu.HEADER_URL));
                                                checkManager.setMobile(r.getValue(bu.MOBILE));
                                                batchCycleExecute.setCreatedUser(checkManager);
                                            }
                                            return batchCycleExecute;
                                        }).collectList(),Mono.from(countSql).map(Record1::value1))
                .map(it -> new PageImpl<>(it.getT1(),pageRequest,it.getT2()));
    }
}
