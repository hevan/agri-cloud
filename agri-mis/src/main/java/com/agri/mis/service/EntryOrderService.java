package com.agri.mis.service;

import com.agri.mis.domain.BatchProduct;
import com.agri.mis.domain.EntryOrder;
import com.agri.mis.domain.User;
import com.agri.mis.repository.EntryOrderRepository;
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
public class EntryOrderService {
    @Autowired
    private EntryOrderRepository entryOrderRepository;

    @Autowired
    private DSLContext dslContext;

    public Mono<EntryOrder> findById(Long id){

        com.agri.mis.db.tables.EntryOrder bce =  com.agri.mis.db.tables.EntryOrder.ENTRY_ORDER;

        com.agri.mis.db.tables.BatchProduct bp = com.agri.mis.db.tables.BatchProduct.BATCH_PRODUCT;

        com.agri.mis.db.tables.Users users =  com.agri.mis.db.tables.Users.USERS;

        Condition where = DSL.trueCondition();
         where =  where.and(bce.ID.eq(id));

        var dataSql = dslContext.select(
                bce.ID,
                bce.CORP_ID,
                bce.BATCH_ID,
                bce.WAREHOUSE_ID,
                bce.NAME,
                bce.CODE,
                bce.ORIGIN_ID,
                bce.ORIGIN_TYPE,
                bce.QUANTITY,
                bce.AMOUNT,
                bce.DESCRIPTION,
                bce.CHECK_STATUS,
                bce.STATUS,
                bce.CREATED_AT,
                bce.CREATED_USER_ID,
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
                            EntryOrder entryOrder = new EntryOrder();
                            entryOrder.setId(r.getValue(bce.ID));

                            entryOrder.setName(r.getValue(bce.NAME));
                            entryOrder.setCode(r.getValue(bce.CODE));
                            entryOrder.setQuantity(r.getValue(bce.QUANTITY));
                            entryOrder.setAmount(r.getValue(bce.AMOUNT));
                            entryOrder.setCorpId(r.getValue(bce.CORP_ID));
                            entryOrder.setWarehouseId(r.getValue(bce.WAREHOUSE_ID));
                            entryOrder.setOriginId(r.getValue(bce.ORIGIN_ID));
                            entryOrder.setOriginType(r.getValue(bce.ORIGIN_TYPE));
                            entryOrder.setBatchId(r.getValue(bce.BATCH_ID));
                            entryOrder.setCheckStatus(r.getValue(bce.CHECK_STATUS));
                            entryOrder.setStatus(r.getValue(bce.STATUS));
                            entryOrder.setCreatedAt(r.getValue(bce.CREATED_AT));
                            entryOrder.setCreatedUserId(r.getValue(bce.CREATED_USER_ID));
                            entryOrder.setDescription(r.getValue(bce.DESCRIPTION));
                            entryOrder.setOccurAt(r.getValue(bce.OCCUR_AT));

                            if(null!= entryOrder.getBatchId()){
                                BatchProduct batchProduct = new BatchProduct();
                                batchProduct.setId(r.getValue(bp.ID));
                                batchProduct.setName(r.getValue(bp.NAME));
                                batchProduct.setCode(r.getValue(bp.CODE));
                                entryOrder.setBatchProduct(batchProduct);
                            }
                            if(null!= entryOrder.getCreatedUserId()){
                                User user = new User();
                                user.setId(r.getValue(users.ID));
                                user.setNickName(r.getValue(users.NICK_NAME));
                                user.setHeaderUrl(r.getValue(users.HEADER_URL));
                                entryOrder.setCreatedUser(user);
                            }

                            return entryOrder;
                        });
    }

    public Mono<EntryOrder> add(EntryOrder entryOrder){
        if(null == entryOrder.getId()){
            entryOrder.setCode(DateUtils.genBusiCode("F", LocalDateTime.now()));
        }
        return entryOrderRepository.save(entryOrder);
    }

    public Flux<EntryOrder> findAllByBatchId(Long batchId){
        return entryOrderRepository.findAllByBatchId(batchId);
    }

    public Mono<EntryOrder> update(Long id, EntryOrder entryOrder){
        return entryOrderRepository.findById(id).flatMap(
                r ->{
                    entryOrder.setId(r.getId());
                    return entryOrderRepository.save(entryOrder);
                }
        );
    }

    public Mono<Void> delete(EntryOrder entryOrder){
        return entryOrderRepository.delete(entryOrder);
    }

    public Mono<Page<EntryOrder>> pageQuery(EntryOrder entryOrderParam, PageRequest pageRequest) {
        com.agri.mis.db.tables.EntryOrder bce =  com.agri.mis.db.tables.EntryOrder.ENTRY_ORDER;

        com.agri.mis.db.tables.BatchProduct bp = com.agri.mis.db.tables.BatchProduct.BATCH_PRODUCT;

        com.agri.mis.db.tables.Users users =  com.agri.mis.db.tables.Users.USERS;

        Condition where = DSL.trueCondition();

        if(StringUtils.hasLength(entryOrderParam.getName())){
            where = where.and(bce.NAME.like("%" + entryOrderParam.getName() +"%"));
        }

        if(null != entryOrderParam.getBatchId()){
            where = where.and(bce.BATCH_ID.eq(entryOrderParam.getBatchId()));
        }
        if(null != entryOrderParam.getCreatedUserId()){
            where = where.and(bce.CREATED_USER_ID.eq(entryOrderParam.getCreatedUserId()));
        }
        if(null != entryOrderParam.getCorpId()){
            where = where.and(bce.CORP_ID.eq(entryOrderParam.getCorpId()));
        }
        if(null != entryOrderParam.getStatus()){
            where = where.and(bce.STATUS.eq(entryOrderParam.getStatus()));
        }
        if(null != entryOrderParam.getCheckStatus()){
            where = where.and(bce.CHECK_STATUS.eq(entryOrderParam.getCheckStatus()));
        }

        var dataSql = dslContext.select(
                bce.ID,
                bce.CORP_ID,
                bce.BATCH_ID,
                bce.WAREHOUSE_ID,
                bce.NAME,
                bce.CODE,
                bce.ORIGIN_ID,
                bce.ORIGIN_TYPE,
                bce.QUANTITY,
                bce.AMOUNT,
                bce.DESCRIPTION,
                bce.CHECK_STATUS,
                bce.STATUS,
                bce.CREATED_AT,
                bce.CREATED_USER_ID,
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
                                            EntryOrder entryOrder = new EntryOrder();
                                            entryOrder.setId(r.getValue(bce.ID));

                                            entryOrder.setName(r.getValue(bce.NAME));
                                            entryOrder.setCode(r.getValue(bce.CODE));
                                            entryOrder.setAmount(r.getValue(bce.AMOUNT));
                                            entryOrder.setCorpId(r.getValue(bce.CORP_ID));
                                            entryOrder.setQuantity(r.getValue(bce.QUANTITY));
                                            entryOrder.setWarehouseId(r.getValue(bce.WAREHOUSE_ID));
                                            entryOrder.setOriginId(r.getValue(bce.ORIGIN_ID));
                                            entryOrder.setOriginType(r.getValue(bce.ORIGIN_TYPE));
                                            entryOrder.setBatchId(r.getValue(bce.BATCH_ID));
                                            entryOrder.setCheckStatus(r.getValue(bce.CHECK_STATUS));
                                            entryOrder.setStatus(r.getValue(bce.STATUS));
                                            entryOrder.setCreatedAt(r.getValue(bce.CREATED_AT));
                                            entryOrder.setCreatedUserId(r.getValue(bce.CREATED_USER_ID));
                                            entryOrder.setDescription(r.getValue(bce.DESCRIPTION));
                                            entryOrder.setOccurAt(r.getValue(bce.OCCUR_AT));

                                            if(null!= entryOrder.getBatchId()){
                                                BatchProduct batchProduct = new BatchProduct();
                                                batchProduct.setId(r.getValue(bp.ID));
                                                batchProduct.setName(r.getValue(bp.NAME));
                                                batchProduct.setCode(r.getValue(bp.CODE));
                                                entryOrder.setBatchProduct(batchProduct);
                                            }
                                            if(null!= entryOrder.getCreatedUserId()){
                                               User user = new User();
                                               user.setId(r.getValue(users.ID));
                                                user.setNickName(r.getValue(users.NICK_NAME));
                                                user.setHeaderUrl(r.getValue(users.HEADER_URL));
                                                entryOrder.setCreatedUser(user);
                                            }

                                            return entryOrder;
                                        }).collectList(),Mono.from(countSql).map(Record1::value1))
                .map(it -> new PageImpl<>(it.getT1(),pageRequest,it.getT2()));
    }
}
