package com.agri.mis.service;

import com.agri.mis.domain.CheckApply;
import com.agri.mis.domain.CheckTrace;
import com.agri.mis.domain.User;
import com.agri.mis.dto.CheckManager;
import com.agri.mis.dto.CorpManagerInfo;
import com.agri.mis.repository.CheckApplyRepository;
import com.agri.mis.repository.CheckTraceRepository;
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
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class CheckApplyService {

    @Autowired
    private CheckApplyRepository checkApplyRepository;

    @Autowired
    private CheckTraceRepository checkTraceRepository;

    @Autowired
    private DSLContext dslContext;

    public Mono<CheckApply> findById(Long id) {

      return checkApplyRepository.findById(id);
    }


    public Mono<Page<CheckApply>> pageQuery(CheckApply checkApplyParam, PageRequest pageRequest) {
        com.agri.mis.db.tables.CheckApply TB_CHECK_APPLY = com.agri.mis.db.tables.CheckApply.CHECK_APPLY;
        com.agri.mis.db.tables.Users TB_USERS =  com.agri.mis.db.tables.Users.USERS;

        Condition whereA = DSL.trueCondition();
        if(null != checkApplyParam.getEntityId()) {
            whereA = whereA.and(TB_CHECK_APPLY.ENTITY_ID.eq(checkApplyParam.getEntityId())).and(TB_CHECK_APPLY.ENTITY_NAME.eq(checkApplyParam.getEntityName()));
        }
        if(null != checkApplyParam.getUserId()) {
            whereA = whereA.and(TB_CHECK_APPLY.USER_ID.eq(checkApplyParam.getUserId()));
        }

        if(null != checkApplyParam.getCorpId()) {
            whereA = whereA.and(TB_CHECK_APPLY.CORP_ID.eq(checkApplyParam.getCorpId()));
        }

        if(null != checkApplyParam.getStatus()) {
            whereA = whereA.and(TB_CHECK_APPLY.STATUS.eq(checkApplyParam.getStatus()));
        }

        var dataSQL = dslContext.select(
                TB_CHECK_APPLY.ID,
                TB_CHECK_APPLY.ENTITY_NAME,
                TB_CHECK_APPLY.ENTITY_ID,
                TB_CHECK_APPLY.USER_ID,
                TB_CHECK_APPLY.STATUS,
                TB_CHECK_APPLY.CORP_ID,
                TB_CHECK_APPLY.CREATED_AT,
                TB_CHECK_APPLY.UPDATED_AT,
                TB_CHECK_APPLY.TITLE,
                TB_CHECK_APPLY.DESCRIPTION,
                TB_CHECK_APPLY.CHECK_USERS,
                TB_USERS.NICK_NAME,
                TB_USERS.MOBILE,
                TB_USERS.HEADER_URL
        ).from(TB_CHECK_APPLY).leftJoin(TB_USERS).on(TB_CHECK_APPLY.USER_ID.eq(TB_USERS.ID)).where(whereA).limit(pageRequest.getOffset(), pageRequest.getPageSize());

        val countSql = dslContext.select(DSL.field("count(*)", SQLDataType.BIGINT))
                .from(TB_CHECK_APPLY)
                .where(whereA);

        return Mono
                .zip(
                        Flux.from(dataSQL).map(r-> {
                            CheckApply checkApply = new CheckApply();
                            checkApply.setId(r.getValue(TB_CHECK_APPLY.ID));
                            checkApply.setEntityId(r.getValue(TB_CHECK_APPLY.ENTITY_ID));
                            checkApply.setEntityName(r.getValue(TB_CHECK_APPLY.ENTITY_NAME));
                            checkApply.setUserId(r.getValue(TB_CHECK_APPLY.USER_ID));
                            checkApply.setStatus(r.getValue(TB_CHECK_APPLY.STATUS));
                            checkApply.setCorpId(r.getValue(TB_CHECK_APPLY.CORP_ID));
                            checkApply.setCreatedAt(r.getValue(TB_CHECK_APPLY.CREATED_AT));
                            checkApply.setUpdatedAt(r.getValue(TB_CHECK_APPLY.UPDATED_AT));
                            checkApply.setTitle(r.getValue(TB_CHECK_APPLY.TITLE));
                            checkApply.setDescription(r.getValue(TB_CHECK_APPLY.DESCRIPTION));
                            checkApply.setCheckUsers(r.getValue(TB_CHECK_APPLY.CHECK_USERS));

                            if(null != checkApply.getUserId()){
                                User curUser = new User();
                                curUser.setId(checkApply.getUserId());
                                curUser.setNickName(r.getValue(TB_USERS.NICK_NAME));
                                curUser.setHeaderUrl(r.getValue(TB_USERS.HEADER_URL));
                                curUser.setMobile(r.getValue(TB_USERS.MOBILE));
                                checkApply.setCreatedUser(curUser);
                            }

                            return checkApply;

                        }).collectList(),Mono.from(countSql).map(Record1::value1))
                .map(it -> new PageImpl<>(it.getT1(),pageRequest,it.getT2()));
    }

    public Mono<CheckApply> add(CheckApply checkApply) {

        return checkApplyRepository.save(checkApply).flatMap(s->{
            CheckTrace curTemp = new CheckTrace();
           for(CheckManager checkManager : checkApply.getListCheckManager()){
               if(checkManager.getStatus() == 0) {
                   curTemp.setTitle(checkApply.getTitle());
                   curTemp.setStatus(0);
                   curTemp.setEntityId(checkApply.getEntityId());
                   curTemp.setEntityName(checkApply.getEntityName());
                   curTemp.setUserId(checkManager.getUserId());
                   curTemp.setCorpId(checkApply.getCorpId());
                   break;
               }
            }
            return checkTraceRepository.save(curTemp).then(Mono.just(s));
        });
    }

    public Mono<CheckApply> update(Long id, CheckApply checkApply) {
        return checkApplyRepository.findById(id)
                .flatMap(s -> {
                    checkApply.setId(s.getId());
                    return checkApplyRepository.save(checkApply);
                });
    }

    public Mono<Void> delete(CheckApply checkApply) {
        return checkApplyRepository.delete(checkApply);
    }
}
