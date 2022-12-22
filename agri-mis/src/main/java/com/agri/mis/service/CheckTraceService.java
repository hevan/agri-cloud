package com.agri.mis.service;

import com.agri.mis.domain.CheckTrace;
import com.agri.mis.dto.CheckTraceInfo;
import com.agri.mis.repository.CheckTraceRepository;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CheckTraceService {

    @Autowired
    private CheckTraceRepository checkTraceRepository;

    @Autowired
    private DSLContext dslContext;

    public Mono<CheckTrace> findById(Long id) {

      return checkTraceRepository.findById(id);
    }


    public Flux<CheckTraceInfo> findAllByEntityIdAndEntityName(Long entityId, String entityName) {
        com.agri.mis.db.tables.CheckTrace TB_CHECK_TRACE = com.agri.mis.db.tables.CheckTrace.CHECK_TRACE;
        com.agri.mis.db.tables.Users TB_USERS =  com.agri.mis.db.tables.Users.USERS;

        Condition whereA = DSL.trueCondition();
        whereA = whereA.and(TB_CHECK_TRACE.ENTITY_ID.eq(entityId)).and(TB_CHECK_TRACE.ENTITY_NAME.eq(entityName));

        var dataSQL = dslContext.select(
                TB_CHECK_TRACE.ID,
                TB_CHECK_TRACE.ENTITY_NAME,
                TB_CHECK_TRACE.ENTITY_ID,
                TB_CHECK_TRACE.USER_ID,
                TB_CHECK_TRACE.STATUS,
                TB_CHECK_TRACE.CORP_ID,
                TB_CHECK_TRACE.CREATED_AT,
                TB_CHECK_TRACE.TITLE,
                TB_CHECK_TRACE.DESCRIPTION,
                TB_USERS.NICK_NAME,
                TB_USERS.MOBILE,
                TB_USERS.HEADER_URL
        ).from(TB_CHECK_TRACE).leftJoin(TB_USERS).on(TB_CHECK_TRACE.USER_ID.eq(TB_USERS.ID)).where(whereA);

        return Flux.from(dataSQL).map(r-> new CheckTraceInfo(r.value1(),r.value2(),r.value3(),r.value4(),r.value5(),r.value6(),r.value7(),r.value8(),r.value9(),r.value10(),r.value11(),r.value12()));
    }

    public Mono<CheckTrace> add(CheckTrace checkTrace) {
        return checkTraceRepository.save(checkTrace);
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
