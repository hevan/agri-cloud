package com.agri.mis.service;

import com.agri.mis.db.tables.BatchProduct;
import com.agri.mis.db.tables.Users;
import com.agri.mis.domain.BatchRisk;
import com.agri.mis.domain.BatchTeam;
import com.agri.mis.repository.BatchTeamRepository;
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
public class BatchTeamService {

    @Autowired
    private BatchTeamRepository repository;

    @Autowired
    private DSLContext dslContext;

    public Mono<BatchTeam> findById(Long id){
        return repository.findById(id);
    }

    public Mono<BatchTeam> add(BatchTeam batchTeam){
        return repository.save(batchTeam);
    }

    public Mono<BatchTeam> update(Long id,BatchTeam batchTeam){
        return repository.findById(id).flatMap(
                r ->{
                    batchTeam.setId(r.getId());
                    return repository.save(batchTeam);
                }
        );
    }

    public Mono<Void> delete(BatchTeam batchTeam){
        return repository.delete(batchTeam);
    }


    public Mono<Page<BatchTeam>> pageQuery(Long batchId, String name, PageRequest pageRequest){
        com.agri.mis.db.tables.BatchTeam bt = com.agri.mis.db.tables.BatchTeam.BATCH_TEAM;

        com.agri.mis.db.tables.Users us = com.agri.mis.db.tables.Users.USERS;

        Condition where = DSL.trueCondition();

        if(StringUtils.hasLength(name)){
            where = where.and(us.NICK_NAME.like("%" + name +"%"));
        }

        if(null != batchId){
            where = where.and(bt.BATCH_ID.eq(batchId));
        }

        var dataSql = dslContext.select(
                bt.ID,
                bt.BATCH_ID,
                bt.USER_ID,
                bt.IS_MANAGER,
                bt.CREATED_AT,
                us.ID,
                us.NICK_NAME,
                us.HEADER_URL,
                us.MOBILE
        ).from(bt).leftJoin(us).on(bt.USER_ID.eq(us.ID)).where(where).limit(pageRequest.getOffset(),pageRequest.getPageSize());

        val countSql = dslContext.select(DSL.field("count(*)", SQLDataType.BIGINT))
                .from(bt).leftJoin(us).on(bt.USER_ID.eq(us.ID))
                .where(where);
        return Mono.zip(
                Flux.from(dataSql).map(
                        r->{
                            BatchTeam team = new BatchTeam(
                                    r.getValue(bt.ID),
                                    r.getValue(bt.BATCH_ID),
                                    r.getValue(bt.USER_ID),
                                    r.getValue(bt.IS_MANAGER),
                                    r.getValue(bt.CREATED_AT),
                                    null
                            );
                            if(null!=team.getUserId()){
                                com.agri.mis.domain.User user = new com.agri.mis.domain.User();
                                user.setId(team.getUserId());
                                user.setHeaderUrl(r.getValue(us.HEADER_URL));
                                user.setNickName(r.getValue(us.NICK_NAME));
                                user.setMobile(r.getValue(us.MOBILE));
                                team.setUser(user);
                            }
                           return team;
                        }).collectList(),Mono.from(countSql).map(Record1::value1))
                .map(it -> new PageImpl<>(it.getT1(),pageRequest,it.getT2()));
    }
}
