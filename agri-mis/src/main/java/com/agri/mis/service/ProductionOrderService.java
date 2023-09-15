package com.agri.mis.service;

import com.agri.mis.domain.BatchProduct;
import com.agri.mis.domain.ProductionOrder;
import com.agri.mis.domain.User;
import com.agri.mis.repository.ProductionOrderRepository;
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
public class ProductionOrderService {
    @Autowired
    private ProductionOrderRepository productionOrderRepository;

    @Autowired
    private DSLContext dslContext;

    public Mono<ProductionOrder> findById(Long id){

        com.agri.mis.db.tables.ProductionOrder bce =  com.agri.mis.db.tables.ProductionOrder.PRODUCTION_ORDER;

        com.agri.mis.db.tables.BatchProduct bp = com.agri.mis.db.tables.BatchProduct.BATCH_PRODUCT;

        com.agri.mis.db.tables.Users users =  com.agri.mis.db.tables.Users.USERS;

        Condition where = DSL.trueCondition();
        where = where.and(bce.ID.eq(id));

        var dataSql = dslContext.select(
                bce.ID,
                bce.CORP_ID,
                bce.BATCH_ID,
                bce.NAME,
                bce.CODE,
                bce.QUANTITY,
                bce.AMOUNT,
                bce.DESCRIPTION,
                bce.CHECK_STATUS,
                bce.STATUS,
                bce.CREATED_AT,
                bce.CREATED_USER_ID,
                bce.START_AT,
                bce.END_AT,

                bp.ID,
                bp.NAME,
                bp.CODE,

                users.ID,
                users.NICK_NAME,
                users.HEADER_URL
        ).from(bce).leftJoin(bp).on(bce.BATCH_ID.eq(bp.ID)).leftJoin(users).on(bce.CREATED_USER_ID.eq(users.ID)).where(where);

        return Mono.from(dataSql)
                .map(
                        r->{
                            ProductionOrder productionOrder = new ProductionOrder();
                            productionOrder.setId(r.getValue(bce.ID));

                            productionOrder.setName(r.getValue(bce.NAME));
                            productionOrder.setCode(r.getValue(bce.CODE));

                            if(null != r.getValue(bce.QUANTITY)) {
                                productionOrder.setQuantity(r.getValue(bce.QUANTITY));
                            }else{
                                productionOrder.setQuantity(null);
                            }
                            productionOrder.setAmount(r.getValue(bce.AMOUNT));
                            productionOrder.setCorpId(r.getValue(bce.CORP_ID));

                            productionOrder.setBatchId(r.getValue(bce.BATCH_ID));

                            productionOrder.setCheckStatus(r.getValue(bce.CHECK_STATUS));
                            productionOrder.setStatus(r.getValue(bce.STATUS));
                            productionOrder.setCreatedAt(r.getValue(bce.CREATED_AT));
                            productionOrder.setCreatedUserId(r.getValue(bce.CREATED_USER_ID));
                            productionOrder.setDescription(r.getValue(bce.DESCRIPTION));
                            productionOrder.setStartAt(r.getValue(bce.START_AT));
                            productionOrder.setEndAt(r.getValue(bce.END_AT));
                            if(null!= productionOrder.getBatchId()){
                                BatchProduct batchProduct = new BatchProduct();
                                batchProduct.setId(r.getValue(bp.ID));
                                batchProduct.setName(r.getValue(bp.NAME));
                                batchProduct.setCode(r.getValue(bp.CODE));
                                productionOrder.setBatchProduct(batchProduct);
                            }
                            if(null!= productionOrder.getCreatedUserId()){
                                User user = new User();
                                user.setId(r.getValue(users.ID));
                                user.setNickName(r.getValue(users.NICK_NAME));
                                user.setHeaderUrl(r.getValue(users.HEADER_URL));
                                productionOrder.setCreatedUser(user);
                            }


                            return productionOrder;
                        });
    }

    public Mono<ProductionOrder> add(ProductionOrder productionOrder){
        if(null == productionOrder.getId()){
            productionOrder.setCode(DateUtils.genBusiCode("C", LocalDateTime.now()));
            productionOrder.setCheckStatus(0);
            productionOrder.setStatus(0);
        }
        return productionOrderRepository.save(productionOrder);
    }

    public Mono<ProductionOrder> update(Long id, ProductionOrder productionOrder){
        return productionOrderRepository.findById(id).flatMap(
                r ->{
                    productionOrder.setId(r.getId());
                    return productionOrderRepository.save(productionOrder);
                }
        );
    }


    public Mono<Void> delete(ProductionOrder productionOrder){
        return productionOrderRepository.delete(productionOrder);
    }

    public Mono<Page<ProductionOrder>> pageQuery(ProductionOrder productionOrderParam, PageRequest pageRequest) {
        com.agri.mis.db.tables.ProductionOrder bce =  com.agri.mis.db.tables.ProductionOrder.PRODUCTION_ORDER;

        com.agri.mis.db.tables.BatchProduct bp = com.agri.mis.db.tables.BatchProduct.BATCH_PRODUCT;

        com.agri.mis.db.tables.Users users =  com.agri.mis.db.tables.Users.USERS;

        Condition where = DSL.trueCondition();

        if(StringUtils.hasLength(productionOrderParam.getName())){
            where = where.and(bce.NAME.like("%" + productionOrderParam.getName() +"%"));
        }

        if(null != productionOrderParam.getBatchId()){
            where = where.and(bce.BATCH_ID.eq(productionOrderParam.getBatchId()));
        }

        if(null != productionOrderParam.getCorpId()){
            where = where.and(bce.CORP_ID.eq(productionOrderParam.getCorpId()));
        }


        if(null != productionOrderParam.getCreatedUserId()){
            where = where.and(bce.CREATED_USER_ID.eq(productionOrderParam.getCreatedUserId()));
        }

        if(null != productionOrderParam.getStatus()){
            where = where.and(bce.STATUS.eq(productionOrderParam.getStatus()));
        }

        if(null != productionOrderParam.getCheckStatus()){
            where = where.and(bce.CHECK_STATUS.eq(productionOrderParam.getCheckStatus()));
        }

        var dataSql = dslContext.select(
                bce.ID,
                bce.CORP_ID,
                bce.BATCH_ID,
                bce.NAME,
                bce.CODE,
                bce.QUANTITY,
                bce.AMOUNT,
                bce.DESCRIPTION,
                bce.CHECK_STATUS,
                bce.STATUS,
                bce.CREATED_AT,
                bce.CREATED_USER_ID,
                bce.START_AT,
                bce.END_AT,

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
                                            ProductionOrder productionOrder = new ProductionOrder();
                                            productionOrder.setId(r.getValue(bce.ID));

                                            productionOrder.setName(r.getValue(bce.NAME));
                                            productionOrder.setCode(r.getValue(bce.CODE));
                                            if(null != r.getValue(bce.QUANTITY)) {
                                                productionOrder.setQuantity(r.getValue(bce.QUANTITY));
                                            }else{
                                                productionOrder.setQuantity(0d);
                                            }
                                            productionOrder.setAmount(r.getValue(bce.AMOUNT));
                                            productionOrder.setCorpId(r.getValue(bce.CORP_ID));

                                            productionOrder.setBatchId(r.getValue(bce.BATCH_ID));

                                            productionOrder.setCheckStatus(r.getValue(bce.CHECK_STATUS));
                                            productionOrder.setStatus(r.getValue(bce.STATUS));
                                            productionOrder.setCreatedAt(r.getValue(bce.CREATED_AT));
                                            productionOrder.setCreatedUserId(r.getValue(bce.CREATED_USER_ID));
                                            productionOrder.setDescription(r.getValue(bce.DESCRIPTION));
                                            productionOrder.setStartAt(r.getValue(bce.START_AT));
                                            productionOrder.setEndAt(r.getValue(bce.END_AT));

                                            if(null!= productionOrder.getBatchId()){
                                                BatchProduct batchProduct = new BatchProduct();
                                                batchProduct.setId(r.getValue(bp.ID));
                                                batchProduct.setName(r.getValue(bp.NAME));
                                                batchProduct.setCode(r.getValue(bp.CODE));
                                                productionOrder.setBatchProduct(batchProduct);
                                            }
                                            if(null!= productionOrder.getCreatedUserId()){
                                               User user = new User();
                                               user.setId(r.getValue(users.ID));
                                                user.setNickName(r.getValue(users.NICK_NAME));
                                                user.setHeaderUrl(r.getValue(users.HEADER_URL));
                                                productionOrder.setCreatedUser(user);
                                            }

                                            return productionOrder;
                                        }).collectList(),Mono.from(countSql).map(Record1::value1))
                .map(it -> new PageImpl<>(it.getT1(),pageRequest,it.getT2()));
    }


}
