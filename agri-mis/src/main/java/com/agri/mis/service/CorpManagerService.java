package com.agri.mis.service;


import com.agri.mis.domain.*;
import com.agri.mis.dto.CorpManagerInfo;
import com.agri.mis.exception.BusiNotFoundException;
import com.agri.mis.repository.CorpManagerDepartRepository;
import com.agri.mis.repository.CorpManagerRepository;
import com.agri.mis.repository.CorpManagerRoleRepository;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import static org.jooq.Records.mapping;
import static org.jooq.impl.DSL.*;

@Service
public class CorpManagerService {

    @Autowired
    private DSLContext dslContext;

    @Autowired
    private CorpManagerRepository corpManagerRepository;

    @Autowired
    private CorpManagerDepartRepository corpManagerDepartRepository;


    @Autowired
    private CorpManagerRoleRepository corpManagerRoleRepository;


    public Mono<CorpManager> findById(Long id) {

      return corpManagerRepository.findById(id);

    }


    public Mono<CorpManagerInfo> findInfoById(Long id) {

        com.agri.mis.db.tables.CorpManager TB_CORP_MANAGER = com.agri.mis.db.tables.CorpManager.CORP_MANAGER;
        com.agri.mis.db.tables.Users  TB_USERS = com.agri.mis.db.tables.Users.USERS;

        com.agri.mis.db.tables.CorpRole  TB_CORP_ROLE = com.agri.mis.db.tables.CorpRole.CORP_ROLE;
        com.agri.mis.db.tables.CorpDepart  TB_CORP_DEPART = com.agri.mis.db.tables.CorpDepart.CORP_DEPART;
        com.agri.mis.db.tables.CorpManagerRole  TB_CORP_MANAGER_ROLE = com.agri.mis.db.tables.CorpManagerRole.CORP_MANAGER_ROLE;
        com.agri.mis.db.tables.CorpManagerDepart  TB_CORP_MANAGER_DEPART = com.agri.mis.db.tables.CorpManagerDepart.CORP_MANAGER_DEPART;



        var dataSql = dslContext.select(
                TB_CORP_MANAGER.ID,
                TB_CORP_MANAGER.CORP_ID,
                TB_CORP_MANAGER.USER_ID,
                TB_CORP_MANAGER.POSITION,
                TB_USERS.NICK_NAME,
                TB_USERS.MOBILE,
                TB_USERS.HEADER_URL,
                TB_USERS.DESCRIPTION,

                multiset(
                        selectDistinct(
                                TB_CORP_DEPART.ID,
                                TB_CORP_DEPART.NAME,
                                TB_CORP_DEPART.CORP_ID
                        ).from(TB_CORP_DEPART).join(TB_CORP_MANAGER_DEPART).on(TB_CORP_MANAGER_DEPART.DEPART_ID.eq(TB_CORP_DEPART.ID))
                                .where(TB_CORP_MANAGER_DEPART.MANAGER_ID.eq(TB_CORP_MANAGER.ID))
                ).as("departs").convertFrom(r -> r.map(mapping(CorpDepart::new))),
                multiset(
                        selectDistinct(
                                TB_CORP_ROLE.ID,
                                TB_CORP_ROLE.NAME,
                                TB_CORP_ROLE.CORP_ID
                        ).from(TB_CORP_ROLE).join(TB_CORP_MANAGER_ROLE).on(TB_CORP_MANAGER_ROLE.ROLE_ID.eq(TB_CORP_ROLE.ID))
                                .where(TB_CORP_MANAGER_ROLE.MANAGER_ID.eq(TB_CORP_MANAGER.ID))
                ).as("roles").convertFrom(r -> r.map(mapping(CorpRole::new)))

        ).from(TB_CORP_MANAGER).leftJoin(TB_USERS).on(TB_CORP_MANAGER.USER_ID.eq(TB_USERS.ID)).where(TB_CORP_MANAGER.ID.eq(id));

        return  Mono.from(dataSql)
                .map(r -> new CorpManagerInfo(r.getValue(TB_CORP_MANAGER.ID), r.getValue(TB_CORP_MANAGER.CORP_ID), r.getValue(TB_CORP_MANAGER.USER_ID),r.getValue(TB_CORP_MANAGER.POSITION),
                        r.getValue(TB_USERS.NICK_NAME), r.getValue(TB_USERS.MOBILE), r.getValue(TB_USERS.HEADER_URL),r.getValue(TB_USERS.DESCRIPTION), r.value9(), r.value10()));

    }

    public Flux<CorpManager> findAllByCorpId(Long corpId) {
        return corpManagerRepository.findAllByCorpId(corpId);
    }

    public Mono<CorpManager> add(CorpManagerInfo corpManagerInfo) {

        return corpManagerRepository.save(new CorpManager(null, corpManagerInfo.getUserId(), corpManagerInfo.getCorpId(), LocalDateTime.now(), corpManagerInfo.getPosition(), null, null))
                .flatMap(s ->
                    corpManagerDepartRepository.saveAll(corpManagerInfo.getListCorpDepart().stream().map(item -> new CorpManagerDepart(null ,s.getId(), item.getId() )).collect(Collectors.toSet())).then(Mono.just(s))
        ).flatMap(d ->corpManagerRoleRepository.saveAll(corpManagerInfo.getListCorpRole().stream().map(item -> new CorpManagerRole(null ,d.getId(), item.getId() )).collect(Collectors.toSet())).then(Mono.just(d)));
    }

    public Mono<CorpManager> update(Long id, CorpManager corpManager) {
        return verifyExistence(id)
                .then(corpManagerRoleRepository.deleteAllByManagerId(id)).then(corpManagerDepartRepository.deleteAllByManagerId(id)).then(corpManagerRoleRepository.saveAll(corpManager.getListManagerRole()).collectList())
                .then(corpManagerDepartRepository.saveAll(corpManager.getListManagerDepart()).collectList()).then(corpManagerRepository.save(corpManager));
    }

    private Mono<Boolean> verifyExistence(Long id) {
        return corpManagerRepository.existsById(id).handle((exists, sink) -> {
            if (Boolean.FALSE.equals(exists)) {
                sink.error(new BusiNotFoundException(id, "corpManager", "没有发现业务数据 "));
            } else {
                sink.next(exists);
            }
        });
    }

    public Mono<Void> delete(CorpManager corpManager) {
        return corpManagerRepository.delete(corpManager);
    }

    public Flux<CorpManagerInfo> findAllInfoByCorpId(Long corpId) {

        com.agri.mis.db.tables.CorpManager TB_CORP_MANAGER = com.agri.mis.db.tables.CorpManager.CORP_MANAGER;
        com.agri.mis.db.tables.Users  TB_USERS = com.agri.mis.db.tables.Users.USERS;

        com.agri.mis.db.tables.CorpRole  TB_CORP_ROLE = com.agri.mis.db.tables.CorpRole.CORP_ROLE;
        com.agri.mis.db.tables.CorpDepart  TB_CORP_DEPART = com.agri.mis.db.tables.CorpDepart.CORP_DEPART;
        com.agri.mis.db.tables.CorpManagerRole  TB_CORP_MANAGER_ROLE = com.agri.mis.db.tables.CorpManagerRole.CORP_MANAGER_ROLE;
        com.agri.mis.db.tables.CorpManagerDepart  TB_CORP_MANAGER_DEPART = com.agri.mis.db.tables.CorpManagerDepart.CORP_MANAGER_DEPART;


        Condition where = DSL.trueCondition();

        if(null != corpId){
            where = where.and(TB_CORP_MANAGER.CORP_ID.eq(corpId));
        }
        var dataSql = dslContext.select(
                TB_CORP_MANAGER.ID,
                TB_CORP_MANAGER.CORP_ID,
                TB_CORP_MANAGER.USER_ID,
                TB_CORP_MANAGER.POSITION,
                TB_USERS.NICK_NAME,
                TB_USERS.MOBILE,
                TB_USERS.HEADER_URL,
                TB_USERS.DESCRIPTION,

                multiset(
                  selectDistinct(
                          TB_CORP_DEPART.ID,
                          TB_CORP_DEPART.NAME,
                          TB_CORP_DEPART.CORP_ID
                  ).from(TB_CORP_DEPART).join(TB_CORP_MANAGER_DEPART).on(TB_CORP_MANAGER_DEPART.DEPART_ID.eq(TB_CORP_DEPART.ID))
                        .where(TB_CORP_MANAGER_DEPART.MANAGER_ID.eq(TB_CORP_MANAGER.ID))
                ).as("departs").convertFrom(r -> r.map(mapping(CorpDepart::new))),
                multiset(
                        selectDistinct(
                                TB_CORP_ROLE.ID,
                                TB_CORP_ROLE.NAME,
                                TB_CORP_ROLE.CORP_ID
                        ).from(TB_CORP_ROLE).join(TB_CORP_MANAGER_ROLE).on(TB_CORP_MANAGER_ROLE.ROLE_ID.eq(TB_CORP_ROLE.ID))
                                .where(TB_CORP_MANAGER_ROLE.MANAGER_ID.eq(TB_CORP_MANAGER.ID))
                ).as("roles").convertFrom(r -> r.map(mapping(CorpRole::new)))

        ).from(TB_CORP_MANAGER).leftJoin(TB_USERS).on(TB_CORP_MANAGER.USER_ID.eq(TB_USERS.ID)).where(where);

        return  Flux.from(dataSql)
                .map(r -> new CorpManagerInfo(r.getValue(TB_CORP_MANAGER.ID), r.getValue(TB_CORP_MANAGER.CORP_ID), r.getValue(TB_CORP_MANAGER.USER_ID),r.getValue(TB_CORP_MANAGER.POSITION),
                       r.getValue(TB_USERS.NICK_NAME), r.getValue(TB_USERS.MOBILE), r.getValue(TB_USERS.HEADER_URL),r.getValue(TB_USERS.DESCRIPTION), r.value9(), r.value10()));
    }
}
