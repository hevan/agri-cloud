package com.agri.mis.service;

import com.agri.mis.domain.CheckTrace;
import com.agri.mis.domain.User;
import com.agri.mis.dto.CheckManager;
import com.agri.mis.repository.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.val;
import org.apache.logging.log4j.core.layout.internal.ListChecker;
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

import java.util.List;

import static reactor.core.publisher.Mono.from;
import static reactor.core.publisher.Mono.zip;


@Service
public class CheckTraceService {

    @Autowired
    private CheckTraceRepository checkTraceRepository;

    @Autowired
    private FinanceExpenseRepository financeExpenseRepository;

    @Autowired
    private SaleOrderRepository saleOrderRepository;

    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;

    @Autowired
    private CheckApplyRepository checkApplyRepository;

    @Autowired
    private DSLContext dslContext;

    public Mono<CheckTrace> findById(Long id) {

      return checkTraceRepository.findById(id);
    }


    public Mono<Page<CheckTrace>> pageQuery(CheckTrace checkTraceParam, PageRequest pageRequest) {
        com.agri.mis.db.tables.CheckTrace TB_CHECK_TRACE = com.agri.mis.db.tables.CheckTrace.CHECK_TRACE;
        com.agri.mis.db.tables.Users TB_USERS =  com.agri.mis.db.tables.Users.USERS;

        Condition whereA = DSL.trueCondition();
        if(null != checkTraceParam.getEntityId()) {
            whereA = whereA.and(TB_CHECK_TRACE.ENTITY_ID.eq(checkTraceParam.getEntityId())).and(TB_CHECK_TRACE.ENTITY_NAME.eq(checkTraceParam.getEntityName()));
        }
        if(null != checkTraceParam.getUserId()) {
            whereA = whereA.and(TB_CHECK_TRACE.USER_ID.eq(checkTraceParam.getUserId()));
        }

        if(null != checkTraceParam.getCorpId()) {
            whereA = whereA.and(TB_CHECK_TRACE.CORP_ID.eq(checkTraceParam.getCorpId()));
        }

        if(null != checkTraceParam.getStatus()) {
            whereA = whereA.and(TB_CHECK_TRACE.STATUS.eq(checkTraceParam.getStatus()));
        }

        var dataSQL = dslContext.select(
                TB_CHECK_TRACE.ID,
                TB_CHECK_TRACE.ENTITY_NAME,
                TB_CHECK_TRACE.ENTITY_ID,
                TB_CHECK_TRACE.USER_ID,
                TB_CHECK_TRACE.STATUS,
                TB_CHECK_TRACE.CORP_ID,
                TB_CHECK_TRACE.CREATED_AT,
                TB_CHECK_TRACE.UPDATED_AT,
                TB_CHECK_TRACE.TITLE,
                TB_CHECK_TRACE.DESCRIPTION,
                TB_USERS.NICK_NAME,
                TB_USERS.MOBILE,
                TB_USERS.HEADER_URL
        ).from(TB_CHECK_TRACE).leftJoin(TB_USERS).on(TB_CHECK_TRACE.USER_ID.eq(TB_USERS.ID)).where(whereA).limit(pageRequest.getOffset(), pageRequest.getPageSize());

        val countSql = dslContext.select(DSL.field("count(*)", SQLDataType.BIGINT))
                .from(TB_CHECK_TRACE)
                .where(whereA);

        return zip(
                        Flux.from(dataSQL).map(r-> {
                            CheckTrace checkTrace = new CheckTrace();
                            checkTrace.setId(r.getValue(TB_CHECK_TRACE.ID));
                            checkTrace.setEntityId(r.getValue(TB_CHECK_TRACE.ENTITY_ID));
                            checkTrace.setEntityName(r.getValue(TB_CHECK_TRACE.ENTITY_NAME));
                            checkTrace.setUserId(r.getValue(TB_CHECK_TRACE.USER_ID));
                            checkTrace.setStatus(r.getValue(TB_CHECK_TRACE.STATUS));
                            checkTrace.setCorpId(r.getValue(TB_CHECK_TRACE.CORP_ID));
                            checkTrace.setCreatedAt(r.getValue(TB_CHECK_TRACE.CREATED_AT));
                            checkTrace.setUpdatedAt(r.getValue(TB_CHECK_TRACE.UPDATED_AT));
                            checkTrace.setTitle(r.getValue(TB_CHECK_TRACE.TITLE));
                            checkTrace.setDescription(r.getValue(TB_CHECK_TRACE.DESCRIPTION));

                            if(null != checkTrace.getUserId()){
                                User curUser = new User();
                                curUser.setId(checkTrace.getUserId());
                                curUser.setNickName(r.getValue(TB_USERS.NICK_NAME));
                                curUser.setHeaderUrl(r.getValue(TB_USERS.HEADER_URL));
                                curUser.setMobile(r.getValue(TB_USERS.MOBILE));
                                checkTrace.setCreatedUser(curUser);
                            }

                            return checkTrace;

                        }).collectList(), from(countSql).map(Record1::value1))
                .map(it -> new PageImpl<>(it.getT1(),pageRequest,it.getT2()));
    }

    public Mono<CheckTrace> add(CheckTrace checkTrace) {
        return checkTraceRepository.save(checkTrace);
    }

    public Mono<String> updateStatusSuccess(Long id,  Integer status) {
        return checkTraceRepository.findById(id)
                .flatMap(s -> {
                    s.setStatus(status);
                    return checkTraceRepository.save(s).flatMap(t-> {
                        //update checkApply
                        return checkApplyRepository.findByEntityIdAndEntityName(t.getEntityId(),t.getEntityName()).flatMap(a->{
                            List<CheckManager> listCheckManager = a.convertCheck();
                            Boolean checkFinish = true;
                            CheckManager nextCheck = null;
                            for(CheckManager curManager : listCheckManager ){
                                if(s.getUserId().compareTo(curManager.getUserId()) == 0){
                                    curManager.setStatus(status);
                                }
                                if(curManager.getStatus() == 0){
                                    checkFinish = false;
                                    nextCheck = curManager;
                                    break;
                                }
                            }
                            try {
                                ObjectMapper objectMapper = new ObjectMapper();
                                a.setCheckUsers(objectMapper.writeValueAsString(listCheckManager));
                               if(checkFinish){
                                   a.setStatus(2);
                                    return checkApplyRepository.save(a).flatMap(at->updateEntityStatus(a.getEntityId(),a.getEntityName(),2));
                                }else {
                                   CheckTrace curCheckTrace = new CheckTrace();
                                   curCheckTrace.setStatus(0);
                                   curCheckTrace.setUserId(nextCheck.getUserId());
                                   curCheckTrace.setEntityName(a.getEntityName());
                                   curCheckTrace.setEntityId(a.getEntityId());
                                   curCheckTrace.setTitle(a.getTitle());
                                   curCheckTrace.setCorpId(a.getCorpId());
                                    return checkTraceRepository.save(curCheckTrace).flatMap(n-> checkApplyRepository.save(a)).then(Mono.just("ok"));
                                }

                            }catch (Exception e){

                            }

                            return Mono.just("OK");
                        });
                    });
                });
    }

    public Mono<String> updateStatusFaile(Long id,  Integer status) {
        return checkTraceRepository.findById(id)
                .flatMap(s -> {
                    s.setStatus(status);
                    return checkTraceRepository.save(s).flatMap(t-> {
                        return checkApplyRepository.findByEntityIdAndEntityName(t.getEntityId(),t.getEntityName()).flatMap(a->{
                            List<CheckManager> listCheckManager = a.convertCheck();

                            for(CheckManager curManager : listCheckManager ){
                                if(s.getUserId().compareTo(curManager.getUserId()) == 0){
                                    curManager.setStatus(status);
                                }

                            }
                            try {
                                ObjectMapper objectMapper = new ObjectMapper();
                                a.setCheckUsers(objectMapper.writeValueAsString(listCheckManager));

                                a.setStatus(status);
                                return checkApplyRepository.save(a).flatMap(at->updateEntityStatus(a.getEntityId(),a.getEntityName(),-1));


                            }catch (Exception e){

                            }

                            return Mono.just("OK");
                        });
                    });
                });
    }

    public Mono<String> updateEntityStatus(Long entityId, String entityName,Integer status){
        System.out.println(entityName);
        if(entityName.equals("financeExpense")){
            return financeExpenseRepository.findById(entityId).flatMap(s->{
                s.setStatus(status);
                s.setCheckStatus(status);
                return financeExpenseRepository.save(s).then(Mono.just("ok"));
            });
        }else if(entityName.equals("saleOrder")){
            return saleOrderRepository.findById(entityId).flatMap(s->{
                s.setStatus(status);
                s.setCheckStatus(status);
                return  saleOrderRepository.save(s).then(Mono.just("ok"));
            });
        }else if(entityName.equals("purchaseOrder")){
            System.out.println("---purchaseOrder------------------");
            return purchaseOrderRepository.findById(entityId).flatMap(s->{
                s.setStatus(status);
                s.setCheckStatus(status);
                return purchaseOrderRepository.save(s).then(Mono.just("ok"));
            });
        }

        return Mono.just("ok");
    }

    public Mono<CheckTrace> update(Long id, CheckTrace checkTrace) {
        return checkTraceRepository.findById(id)
                .flatMap(s -> {
                    checkTrace.setId(s.getId());
                    return checkTraceRepository.save(checkTrace);
                });
    }

    public Mono<Void> delete(CheckTrace checkTrace) {
        return checkTraceRepository.delete(checkTrace);
    }
}
