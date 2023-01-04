package com.agri.mis.service;

import com.agri.mis.domain.CheckTemp;
import com.agri.mis.dto.UserInfo;
import com.agri.mis.repository.CheckTempRepository;
import lombok.var;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.jooq.Records.mapping;
import static org.jooq.impl.DSL.multiset;
import static org.jooq.impl.DSL.select;

@Service
public class CheckTempService {

    @Autowired
    private CheckTempRepository checkTempRepository;

    @Autowired
    private DSLContext dslContext;

    public Mono<CheckTemp> findById(Long id) {
        com.agri.mis.db.tables.CheckTemp TB_CHECK_TEMP = com.agri.mis.db.tables.CheckTemp.CHECK_TEMP;
        com.agri.mis.db.tables.CheckTempItem TB_CHECK_TEMP_ITEM =  com.agri.mis.db.tables.CheckTempItem.CHECK_TEMP_ITEM;
        com.agri.mis.db.tables.Users TB_USERS =  com.agri.mis.db.tables.Users.USERS;

        Condition whereA = DSL.trueCondition();


        whereA = whereA.and(TB_CHECK_TEMP.ID.eq(id));

        var dataSQL = dslContext.select(
                TB_CHECK_TEMP.ID,
                TB_CHECK_TEMP.NAME
                ,TB_CHECK_TEMP.CORP_ID,
                multiset(
                       select(TB_USERS.ID,
                        TB_USERS.NICK_NAME,
                        TB_USERS.MOBILE,
                        TB_USERS.HEADER_URL,
                        TB_USERS.DESCRIPTION).from(TB_CHECK_TEMP_ITEM).join(TB_USERS).on(TB_USERS.ID.eq(TB_CHECK_TEMP_ITEM.USER_ID)).where(TB_CHECK_TEMP_ITEM.CHECK_TEMP_ID.eq(TB_CHECK_TEMP.ID)).orderBy(TB_CHECK_TEMP_ITEM.ID)
               ).as("listUserInfo").convertFrom(r -> r.map(mapping(UserInfo::new)))).from(TB_CHECK_TEMP).where(whereA);

        return Mono.from(dataSQL).map(r -> new CheckTemp(r.value1(),r.value2(),r.value3(), r.value4()));

    }


    public Flux<CheckTemp> findAllByCorpId(Long corpId) {
        com.agri.mis.db.tables.CheckTemp TB_CHECK_TEMP = com.agri.mis.db.tables.CheckTemp.CHECK_TEMP;
        com.agri.mis.db.tables.CheckTempItem TB_CHECK_TEMP_ITEM =  com.agri.mis.db.tables.CheckTempItem.CHECK_TEMP_ITEM;
        com.agri.mis.db.tables.Users TB_USERS =  com.agri.mis.db.tables.Users.USERS;

        Condition whereA = DSL.trueCondition();


        whereA = whereA.and(TB_CHECK_TEMP.CORP_ID.eq(corpId));

        var dataSQL = dslContext.select(
                TB_CHECK_TEMP.ID,
                TB_CHECK_TEMP.NAME
                ,TB_CHECK_TEMP.CORP_ID,
                multiset(
                        select(TB_USERS.ID,
                                TB_USERS.NICK_NAME,
                                TB_USERS.MOBILE,
                                TB_USERS.HEADER_URL,
                                TB_USERS.DESCRIPTION).from(TB_CHECK_TEMP_ITEM).join(TB_USERS).on(TB_USERS.ID.eq(TB_CHECK_TEMP_ITEM.USER_ID)).where(TB_CHECK_TEMP_ITEM.CHECK_TEMP_ID.eq(TB_CHECK_TEMP.ID)).orderBy(TB_CHECK_TEMP_ITEM.ID)
                ).as("listUserInfo").convertFrom(r -> r.map(mapping(UserInfo::new)))).from(TB_CHECK_TEMP).where(whereA);

        return Flux.from(dataSQL).map(r -> new CheckTemp(r.value1(),r.value2(),r.value3(), r.value4()));
    }

    public Mono<CheckTemp> add(CheckTemp checkTemp) {
        return checkTempRepository.save(checkTemp);
    }

    public Mono<CheckTemp> update(Long id, CheckTemp checkTemp) {
        return checkTempRepository.findById(id)
                .flatMap(s -> {
                    checkTemp.setId(s.getId());
                    return checkTempRepository.save(checkTemp);
                });
    }

    public Mono<Void> delete(CheckTemp checkTemp) {
        return checkTempRepository.delete(checkTemp);
    }
}
