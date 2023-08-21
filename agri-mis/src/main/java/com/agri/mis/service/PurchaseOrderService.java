package com.agri.mis.service;

import com.agri.mis.domain.BatchProduct;
import com.agri.mis.domain.Customer;
import com.agri.mis.domain.PurchaseOrder;
import com.agri.mis.domain.User;
import com.agri.mis.repository.PurchaseOrderRepository;
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

import static org.jooq.impl.DSL.*;
import static org.jooq.impl.DSL.sum;

@Service
public class PurchaseOrderService {
    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;

    @Autowired
    private DSLContext dslContext;

    public Mono<PurchaseOrder> findById(Long id){

        com.agri.mis.db.tables.PurchaseOrder bce =  com.agri.mis.db.tables.PurchaseOrder.PURCHASE_ORDER;

        com.agri.mis.db.tables.BatchProduct bp = com.agri.mis.db.tables.BatchProduct.BATCH_PRODUCT;

        com.agri.mis.db.tables.Users users =  com.agri.mis.db.tables.Users.USERS;

        com.agri.mis.db.tables.Customer cust =  com.agri.mis.db.tables.Customer.CUSTOMER;

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
                bce.CUSTOMER_ID,
                bce.CHECK_STATUS,
                bce.STATUS,
                bce.CREATED_AT,
                bce.CREATED_USER_ID,
                bce.OCCUR_AT,

                bp.ID,
                bp.NAME,
                bp.CODE,

                cust.ID,
                cust.NAME,
                cust.MANAGER_MOBILE,

                users.ID,
                users.NICK_NAME,
                users.HEADER_URL
        ).from(bce).leftJoin(bp).on(bce.BATCH_ID.eq(bp.ID)).leftJoin(users).on(bce.CREATED_USER_ID.eq(users.ID)).leftJoin(cust).on(bce.CUSTOMER_ID.eq(cust.ID)).where(where);

        return Mono.from(dataSql)
                .map(
                        r->{
                            PurchaseOrder purchaseOrder = new PurchaseOrder();
                            purchaseOrder.setId(r.getValue(bce.ID));

                            purchaseOrder.setName(r.getValue(bce.NAME));
                            purchaseOrder.setCode(r.getValue(bce.CODE));

                            if(null != r.getValue(bce.QUANTITY)) {
                                purchaseOrder.setQuantity(r.getValue(bce.QUANTITY).doubleValue());
                            }else{
                                purchaseOrder.setQuantity(null);
                            }
                            purchaseOrder.setAmount(r.getValue(bce.AMOUNT));
                            purchaseOrder.setCorpId(r.getValue(bce.CORP_ID));

                            purchaseOrder.setBatchId(r.getValue(bce.BATCH_ID));
                            purchaseOrder.setCustomerId(r.getValue(bce.CUSTOMER_ID));

                            purchaseOrder.setCheckStatus(r.getValue(bce.CHECK_STATUS));
                            purchaseOrder.setStatus(r.getValue(bce.STATUS));
                            purchaseOrder.setCreatedAt(r.getValue(bce.CREATED_AT));
                            purchaseOrder.setCreatedUserId(r.getValue(bce.CREATED_USER_ID));
                            purchaseOrder.setDescription(r.getValue(bce.DESCRIPTION));
                            purchaseOrder.setOccurAt(r.getValue(bce.OCCUR_AT));
                            if(null!= purchaseOrder.getBatchId()){
                                BatchProduct batchProduct = new BatchProduct();
                                batchProduct.setId(r.getValue(bp.ID));
                                batchProduct.setName(r.getValue(bp.NAME));
                                batchProduct.setCode(r.getValue(bp.CODE));
                                purchaseOrder.setBatchProduct(batchProduct);
                            }
                            if(null!= purchaseOrder.getCreatedUserId()){
                                User user = new User();
                                user.setId(r.getValue(users.ID));
                                user.setNickName(r.getValue(users.NICK_NAME));
                                user.setHeaderUrl(r.getValue(users.HEADER_URL));
                                purchaseOrder.setCreatedUser(user);
                            }

                            if(null!= purchaseOrder.getCustomerId()){
                                Customer customer = new Customer();
                                customer.setId(r.getValue(cust.ID));
                                customer.setName(r.getValue(cust.NAME));
                                customer.setManagerMobile(r.getValue(cust.MANAGER_MOBILE));
                                purchaseOrder.setCustomer(customer);
                            }

                            return purchaseOrder;
                        });
    }

    public Mono<PurchaseOrder> add(PurchaseOrder purchaseOrder){
        if(null == purchaseOrder.getId()){
            purchaseOrder.setCode(DateUtils.genBusiCode("C", LocalDateTime.now()));
            purchaseOrder.setCheckStatus(0);
            purchaseOrder.setStatus(0);
        }
        return purchaseOrderRepository.save(purchaseOrder);
    }

    public Mono<PurchaseOrder> update(Long id, PurchaseOrder purchaseOrder){
        return purchaseOrderRepository.findById(id).flatMap(
                r ->{
                    purchaseOrder.setId(r.getId());
                    return purchaseOrderRepository.save(purchaseOrder);
                }
        );
    }


    public Mono<Void> delete(PurchaseOrder purchaseOrder){
        return purchaseOrderRepository.delete(purchaseOrder);
    }

    public Mono<Page<PurchaseOrder>> pageQuery(PurchaseOrder purchaseOrderParam, PageRequest pageRequest) {
        com.agri.mis.db.tables.PurchaseOrder bce =  com.agri.mis.db.tables.PurchaseOrder.PURCHASE_ORDER;

        com.agri.mis.db.tables.BatchProduct bp = com.agri.mis.db.tables.BatchProduct.BATCH_PRODUCT;

        com.agri.mis.db.tables.Users users =  com.agri.mis.db.tables.Users.USERS;

        com.agri.mis.db.tables.Customer cust =  com.agri.mis.db.tables.Customer.CUSTOMER;

        Condition where = DSL.trueCondition();

        if(StringUtils.hasLength(purchaseOrderParam.getName())){
            where = where.and(bce.NAME.like("%" + purchaseOrderParam.getName() +"%"));
        }

        if(null != purchaseOrderParam.getBatchId()){
            where = where.and(bce.BATCH_ID.eq(purchaseOrderParam.getBatchId()));
        }

        if(null != purchaseOrderParam.getCorpId()){
            where = where.and(bce.CORP_ID.eq(purchaseOrderParam.getCorpId()));
        }

        if(null != purchaseOrderParam.getCustomerId()){
            where = where.and(bce.CUSTOMER_ID.eq(purchaseOrderParam.getCustomerId()));
        }

        if(null != purchaseOrderParam.getCreatedUserId()){
            where = where.and(bce.CREATED_USER_ID.eq(purchaseOrderParam.getCreatedUserId()));
        }

        if(null != purchaseOrderParam.getStatus()){
            where = where.and(bce.STATUS.eq(purchaseOrderParam.getStatus()));
        }

        if(null != purchaseOrderParam.getCheckStatus()){
            where = where.and(bce.CHECK_STATUS.eq(purchaseOrderParam.getCheckStatus()));
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
                bce.OCCUR_AT,

                bp.ID,
                bp.NAME,
                bp.CODE,

                cust.ID,
                cust.NAME,
                cust.MANAGER_MOBILE,

                users.ID,
                users.NICK_NAME,
                users.HEADER_URL
        ).from(bce).leftJoin(bp).on(bce.BATCH_ID.eq(bp.ID)).leftJoin(users).on(bce.CREATED_USER_ID.eq(users.ID)).leftJoin(cust).on(bce.CUSTOMER_ID.eq(cust.ID)).where(where).limit(pageRequest.getOffset(),pageRequest.getPageSize());
        val countSql = dslContext.select(DSL.field("count(*)", SQLDataType.BIGINT))
                .from(bce)
                .where(where);
        return Mono
                .zip(
                        Flux.from(dataSql)
                                .map(
                                        r->{
                                            PurchaseOrder purchaseOrder = new PurchaseOrder();
                                            purchaseOrder.setId(r.getValue(bce.ID));

                                            purchaseOrder.setName(r.getValue(bce.NAME));
                                            purchaseOrder.setCode(r.getValue(bce.CODE));
                                            if(null != r.getValue(bce.QUANTITY)) {
                                                purchaseOrder.setQuantity(r.getValue(bce.QUANTITY).doubleValue());
                                            }else{
                                                purchaseOrder.setQuantity(null);
                                            }
                                            purchaseOrder.setAmount(r.getValue(bce.AMOUNT));
                                            purchaseOrder.setCorpId(r.getValue(bce.CORP_ID));

                                            purchaseOrder.setBatchId(r.getValue(bce.BATCH_ID));

                                            purchaseOrder.setCheckStatus(r.getValue(bce.CHECK_STATUS));
                                            purchaseOrder.setStatus(r.getValue(bce.STATUS));
                                            purchaseOrder.setCreatedAt(r.getValue(bce.CREATED_AT));
                                            purchaseOrder.setCreatedUserId(r.getValue(bce.CREATED_USER_ID));
                                            purchaseOrder.setDescription(r.getValue(bce.DESCRIPTION));
                                            purchaseOrder.setOccurAt(r.getValue(bce.OCCUR_AT));
                                            if(null!= purchaseOrder.getBatchId()){
                                                BatchProduct batchProduct = new BatchProduct();
                                                batchProduct.setId(r.getValue(bp.ID));
                                                batchProduct.setName(r.getValue(bp.NAME));
                                                batchProduct.setCode(r.getValue(bp.CODE));
                                                purchaseOrder.setBatchProduct(batchProduct);
                                            }
                                            if(null!= purchaseOrder.getCreatedUserId()){
                                               User user = new User();
                                               user.setId(r.getValue(users.ID));
                                                user.setNickName(r.getValue(users.NICK_NAME));
                                                user.setHeaderUrl(r.getValue(users.HEADER_URL));
                                                purchaseOrder.setCreatedUser(user);
                                            }

                                            if(null!= purchaseOrder.getCustomerId()){
                                                Customer customer = new Customer();
                                                customer.setId(r.getValue(cust.ID));
                                                customer.setName(r.getValue(cust.NAME));
                                                customer.setManagerMobile(r.getValue(cust.MANAGER_MOBILE));
                                                purchaseOrder.setCustomer(customer);
                                            }

                                            return purchaseOrder;
                                        }).collectList(),Mono.from(countSql).map(Record1::value1))
                .map(it -> new PageImpl<>(it.getT1(),pageRequest,it.getT2()));
    }


}
