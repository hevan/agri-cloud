package com.agri.mis.service;

import com.agri.mis.domain.FinanceExpense;
import com.agri.mis.domain.BatchProduct;
import com.agri.mis.domain.SaleOrder;
import com.agri.mis.domain.User;
import com.agri.mis.repository.FinanceExpenseRepository;
import com.agri.mis.util.DateUtils;
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

import java.time.LocalDateTime;

@Service
public class FinanceExpenseService {
    @Autowired
    private FinanceExpenseRepository financeExpenseRepository;

    @Autowired
    private DSLContext dslContext;

    public Mono<FinanceExpense> findById(Long id){

        com.agri.mis.db.tables.FinanceExpense bce =  com.agri.mis.db.tables.FinanceExpense.FINANCE_EXPENSE;

        com.agri.mis.db.tables.BatchProduct bp = com.agri.mis.db.tables.BatchProduct.BATCH_PRODUCT;

        com.agri.mis.db.tables.Users users =  com.agri.mis.db.tables.Users.USERS;

        Condition where = DSL.trueCondition();
         where =  where.and(bce.ID.eq(id));

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
                bce.FOUND_DIRECT,
                bce.OCCUR_AT,

                bp.ID,
                bp.NAME,
                bp.CODE,

                users.ID,
                users.NICK_NAME,
                users.HEADER_URL
        ).from(bce).leftJoin(bp).on(bce.BATCH_ID.eq(bp.ID)).leftJoin(users).on(bce.CREATED_USER_ID.eq(users.ID)).where(where);

        return  Mono.from(dataSql)
                .map(
                        r->{
                            FinanceExpense financeExpense = new FinanceExpense();
                            financeExpense.setId(r.getValue(bce.ID));

                            financeExpense.setName(r.getValue(bce.NAME));
                            financeExpense.setCode(r.getValue(bce.CODE));
                            financeExpense.setAmount(r.getValue(bce.AMOUNT));
                            financeExpense.setCorpId(r.getValue(bce.CORP_ID));
                            financeExpense.setCycleName(r.getValue(bce.CYCLE_NAME));
                            financeExpense.setExpenseType(r.getValue(bce.EXPENSE_TYPE));
                            financeExpense.setFoundDirect(r.getValue(bce.FOUND_DIRECT));
                            financeExpense.setBatchId(r.getValue(bce.BATCH_ID));
                            financeExpense.setCheckStatus(r.getValue(bce.CHECK_STATUS));
                            financeExpense.setStatus(r.getValue(bce.STATUS));
                            financeExpense.setCreatedAt(r.getValue(bce.CREATED_AT));
                            financeExpense.setCreatedUserId(r.getValue(bce.CREATED_USER_ID));
                            financeExpense.setDescription(r.getValue(bce.DESCRIPTION));
                            financeExpense.setOccurAt(r.getValue(bce.OCCUR_AT));

                            if(null!= financeExpense.getBatchId()){
                                BatchProduct batchProduct = new BatchProduct();
                                batchProduct.setId(r.getValue(bp.ID));
                                batchProduct.setName(r.getValue(bp.NAME));
                                batchProduct.setCode(r.getValue(bp.CODE));
                                financeExpense.setBatchProduct(batchProduct);
                            }
                            if(null!= financeExpense.getCreatedUserId()){
                                User user = new User();
                                user.setId(r.getValue(users.ID));
                                user.setNickName(r.getValue(users.NICK_NAME));
                                user.setHeaderUrl(r.getValue(users.HEADER_URL));
                                financeExpense.setCreatedUser(user);
                            }

                            return financeExpense;
                        });
    }

    public Mono<FinanceExpense> add(FinanceExpense financeExpense){
        if(null == financeExpense.getId()){
            financeExpense.setCode(DateUtils.genBusiCode("F", LocalDateTime.now()));
        }
        return financeExpenseRepository.save(financeExpense);
    }

    public Flux<FinanceExpense> findAllByBatchId(Long batchId){
        return financeExpenseRepository.findAllByBatchId(batchId);
    }

    public Mono<FinanceExpense> update(Long id, FinanceExpense financeExpense){
        return financeExpenseRepository.findById(id).flatMap(
                r ->{
                    financeExpense.setId(r.getId());
                    return financeExpenseRepository.save(financeExpense);
                }
        );
    }

    public Mono<Void> delete(FinanceExpense financeExpense){
        return financeExpenseRepository.delete(financeExpense);
    }

    public Mono<Page<FinanceExpense>> pageQuery(FinanceExpense financeExpenseParam, PageRequest pageRequest) {
        com.agri.mis.db.tables.FinanceExpense bce =  com.agri.mis.db.tables.FinanceExpense.FINANCE_EXPENSE;

        com.agri.mis.db.tables.BatchProduct bp = com.agri.mis.db.tables.BatchProduct.BATCH_PRODUCT;

        com.agri.mis.db.tables.Users users =  com.agri.mis.db.tables.Users.USERS;

        Condition where = DSL.trueCondition();

        if(StringUtils.hasLength(financeExpenseParam.getName())){
            where = where.and(bce.NAME.like("%" + financeExpenseParam.getName() +"%"));
        }
        if(null != financeExpenseParam.getFoundDirect()){
            where = where.and(bce.FOUND_DIRECT.eq(financeExpenseParam.getFoundDirect()));
        }
        if(null != financeExpenseParam.getBatchId()){
            where = where.and(bce.BATCH_ID.eq(financeExpenseParam.getBatchId()));
        }
        if(null != financeExpenseParam.getCreatedUserId()){
            where = where.and(bce.CREATED_USER_ID.eq(financeExpenseParam.getCreatedUserId()));
        }
        if(null != financeExpenseParam.getCorpId()){
            where = where.and(bce.CORP_ID.eq(financeExpenseParam.getCorpId()));
        }
        if(null != financeExpenseParam.getStatus()){
            where = where.and(bce.STATUS.eq(financeExpenseParam.getStatus()));
        }
        if(null != financeExpenseParam.getCheckStatus()){
            where = where.and(bce.CHECK_STATUS.eq(financeExpenseParam.getCheckStatus()));
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
                bce.FOUND_DIRECT,
                bce.OCCUR_AT,

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
                                            FinanceExpense financeExpense = new FinanceExpense();
                                            financeExpense.setId(r.getValue(bce.ID));

                                            financeExpense.setName(r.getValue(bce.NAME));
                                            financeExpense.setCode(r.getValue(bce.CODE));
                                            financeExpense.setAmount(r.getValue(bce.AMOUNT));
                                            financeExpense.setCorpId(r.getValue(bce.CORP_ID));
                                            financeExpense.setCycleName(r.getValue(bce.CYCLE_NAME));
                                            financeExpense.setExpenseType(r.getValue(bce.EXPENSE_TYPE));
                                            financeExpense.setFoundDirect(r.getValue(bce.FOUND_DIRECT));
                                            financeExpense.setBatchId(r.getValue(bce.BATCH_ID));
                                            financeExpense.setCheckStatus(r.getValue(bce.CHECK_STATUS));
                                            financeExpense.setStatus(r.getValue(bce.STATUS));
                                            financeExpense.setCreatedAt(r.getValue(bce.CREATED_AT));
                                            financeExpense.setCreatedUserId(r.getValue(bce.CREATED_USER_ID));
                                            financeExpense.setDescription(r.getValue(bce.DESCRIPTION));
                                            financeExpense.setOccurAt(r.getValue(bce.OCCUR_AT));

                                            if(null!= financeExpense.getBatchId()){
                                                BatchProduct batchProduct = new BatchProduct();
                                                batchProduct.setId(r.getValue(bp.ID));
                                                batchProduct.setName(r.getValue(bp.NAME));
                                                batchProduct.setCode(r.getValue(bp.CODE));
                                                financeExpense.setBatchProduct(batchProduct);
                                            }
                                            if(null!= financeExpense.getCreatedUserId()){
                                               User user = new User();
                                               user.setId(r.getValue(users.ID));
                                                user.setNickName(r.getValue(users.NICK_NAME));
                                                user.setHeaderUrl(r.getValue(users.HEADER_URL));
                                                financeExpense.setCreatedUser(user);
                                            }

                                            return financeExpense;
                                        }).collectList(),Mono.from(countSql).map(Record1::value1))
                .map(it -> new PageImpl<>(it.getT1(),pageRequest,it.getT2()));
    }
}
