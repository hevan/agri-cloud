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


    public Mono<Page<BatchTeam>> pageQuery(String name, PageRequest pageRequest){
        com.agri.mis.db.tables.BatchTeam bt = com.agri.mis.db.tables.BatchTeam.BATCH_TEAM;

        com.agri.mis.db.tables.BatchProduct bp = com.agri.mis.db.tables.BatchProduct.BATCH_PRODUCT;



        Condition where = DSL.trueCondition();

        if(StringUtils.hasLength(name)){
            where = where.and(bp.NAME.like("%" + name +"%"));
        }
        var dataSql = dslContext.select(
                bt.ID,
                bt.BATCH_ID,
                bt.USER_ID,
                bt.IS_MANAGER,
                bt.CREATED_AT,

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
        ).from(bt).leftJoin(bp).on(bt.BATCH_ID.eq(bp.ID)).where(where).limit(pageRequest.getOffset(),pageRequest.getPageSize());

        val countSql = dslContext.select(DSL.field("count(*)", SQLDataType.BIGINT))
                .from(bt).leftJoin(bp).on(bt.BATCH_ID.eq(bp.ID))
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
                            if(null!=team.getBatchId()){
                                com.agri.mis.domain.BatchProduct batchProduct = new com.agri.mis.domain.BatchProduct(
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
                                team.setBatchProduct(batchProduct);
                            }
                           return team;
                        }).collectList(),Mono.from(countSql).map(Record1::value1))
                .map(it -> new PageImpl<>(it.getT1(),pageRequest,it.getT2()));
    }
}
