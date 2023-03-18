package com.agri.mis.service;

import com.agri.mis.domain.BatchCycleExpense;
import com.agri.mis.domain.BatchProduct;
import com.agri.mis.domain.User;
import com.agri.mis.repository.BatchCycleExpenseRepository;
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
public class BatchCycleExpenseService {
    @Autowired
    private BatchCycleExpenseRepository batchCycleExpenseRepository;

    @Autowired
    private DSLContext dslContext;

    public Mono<BatchCycleExpense> findById(Long id){
        return batchCycleExpenseRepository.findById(id);
    }

    public Mono<BatchCycleExpense> add(BatchCycleExpense batchCycleExpense){
        return batchCycleExpenseRepository.save(batchCycleExpense);
    }

    public Mono<BatchCycleExpense> update(Long id,BatchCycleExpense batchCycleExpense){
        return batchCycleExpenseRepository.findById(id).flatMap(
                r ->{
                    batchCycleExpense.setId(r.getId());
                    return batchCycleExpenseRepository.save(batchCycleExpense);
                }
        );
    }

    public Mono<Void> delete(BatchCycleExpense batchCycleExpense){
        return batchCycleExpenseRepository.delete(batchCycleExpense);
    }

    public Mono<Page<BatchCycleExpense>> pageQuery(String name, PageRequest pageRequest) {
        com.agri.mis.db.tables.BatchCycleExpense bce =  com.agri.mis.db.tables.BatchCycleExpense.BATCH_CYCLE_EXPENSE;

        com.agri.mis.db.tables.BatchProduct bp = com.agri.mis.db.tables.BatchProduct.BATCH_PRODUCT;

        com.agri.mis.db.tables.Users users =  com.agri.mis.db.tables.Users.USERS;

        Condition where = DSL.trueCondition();

        if(StringUtils.hasLength(name)){
            where = where.and(bce.NAME.like("%" + name +"%"));
        }
        var dataSql = dslContext.select(
                bce.ID,
                bce.CORP_ID,
                bce.BATCH_ID,
                bce.EXPENSE_TYPE,
                bce.NAME,
                bce.CODE,
                bce.CYCLE_NAME,
                bce.AMOUNT,
                bce.DESCRIPTION,
                bce.CHECK_STATUS,
                bce.STATUS,
                bce.CREATED_AT,
                bce.CREATED_USER_ID,

                bp.ID,
                bp.NAME,
                bp.CODE,

                users.ID,
                users.NICK_NAME,
                users.HEADER_URL
        ).from(bce).leftJoin(bp).on(bce.BATCH_ID.eq(bp.ID)).leftJoin(users).on(bce.CREATED_USER_ID.eq(users.ID)).where(where).limit(pageRequest.getOffset(),pageRequest.getPageSize());
        val countSql = dslContext.select(DSL.field("count(*)", SQLDataType.BIGINT))
                .from(bce)
                .where(where);
        return Mono
                .zip(
                        Flux.from(dataSql)
                                .map(
                                        r->{
                                            BatchCycleExpense batchCycleExpense = new BatchCycleExpense(
                                                    r.getValue(bce.ID),
                                                    r.getValue(bce.CYCLE_NAME),
                                                    r.getValue(bce.NAME),
                                                    r.getValue(bce.CODE),
                                                    r.getValue(bce.EXPENSE_TYPE),
                                                    r.getValue(bce.AMOUNT),
                                                    r.getValue(bce.DESCRIPTION),
                                                    r.getValue(bce.CORP_ID),
                                                    r.getValue(bce.BATCH_ID),
                                                    r.getValue(bce.CHECK_STATUS),
                                                    r.getValue(bce.STATUS),
                                                    r.getValue(bce.CREATED_AT),
                                                    r.getValue(bce.CREATED_USER_ID), null, null);
                                            if(null!=batchCycleExpense.getBatchId()){
                                                BatchProduct batchProduct = new BatchProduct();
                                                batchProduct.setId(r.getValue(bp.ID));
                                                batchProduct.setName(r.getValue(bp.NAME));
                                                batchProduct.setCode(r.getValue(bp.CODE));
                                                batchCycleExpense.setBatchProduct(batchProduct);
                                            }
                                            if(null!=batchCycleExpense.getCreatedUserId()){
                                               User user = new User();
                                               user.setId(r.getValue(users.ID));
                                                user.setNickName(r.getValue(users.NICK_NAME));
                                                user.setHeaderUrl(r.getValue(users.HEADER_URL));
                                                batchCycleExpense.setCreatedUser(user);
                                            }

                                            return batchCycleExpense;
                                        }).collectList(),Mono.from(countSql).map(Record1::value1))
                .map(it -> new PageImpl<>(it.getT1(),pageRequest,it.getT2()));
    }
}
