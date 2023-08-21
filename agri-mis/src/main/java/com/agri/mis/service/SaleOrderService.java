package com.agri.mis.service;

import com.agri.mis.domain.BatchProduct;
import com.agri.mis.domain.Customer;
import com.agri.mis.domain.SaleOrder;
import com.agri.mis.domain.User;
import com.agri.mis.repository.SaleOrderRepository;
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
public class SaleOrderService {
    @Autowired
    private SaleOrderRepository saleOrderRepository;

    @Autowired
    private DSLContext dslContext;

    public Mono<SaleOrder> findById(Long id){
        com.agri.mis.db.tables.SaleOrder bce =  com.agri.mis.db.tables.SaleOrder.SALE_ORDER;

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


        return  Mono.from(dataSql)
                .map(
                        r->{
                            SaleOrder saleOrder = new SaleOrder();
                            saleOrder.setId(r.getValue(bce.ID));

                            saleOrder.setName(r.getValue(bce.NAME));
                            saleOrder.setCode(r.getValue(bce.CODE));
                            if(null != r.getValue(bce.QUANTITY)) {
                                saleOrder.setQuantity(r.getValue(bce.QUANTITY).doubleValue());
                            }else{
                                saleOrder.setQuantity(null);
                            }
                            saleOrder.setAmount(r.getValue(bce.AMOUNT));
                            saleOrder.setCorpId(r.getValue(bce.CORP_ID));
                            saleOrder.setCustomerId(r.getValue(bce.CUSTOMER_ID));
                            saleOrder.setBatchId(r.getValue(bce.BATCH_ID));

                            saleOrder.setCheckStatus(r.getValue(bce.CHECK_STATUS));
                            saleOrder.setStatus(r.getValue(bce.STATUS));
                            saleOrder.setCreatedAt(r.getValue(bce.CREATED_AT));
                            saleOrder.setCreatedUserId(r.getValue(bce.CREATED_USER_ID));
                            saleOrder.setDescription(r.getValue(bce.DESCRIPTION));
                            saleOrder.setOccurAt(r.getValue(bce.OCCUR_AT));
                            if(null!= saleOrder.getBatchId()){
                                BatchProduct batchProduct = new BatchProduct();
                                batchProduct.setId(r.getValue(bp.ID));
                                batchProduct.setName(r.getValue(bp.NAME));
                                batchProduct.setCode(r.getValue(bp.CODE));
                                saleOrder.setBatchProduct(batchProduct);
                            }
                            if(null!= saleOrder.getCreatedUserId()){
                                User user = new User();
                                user.setId(r.getValue(users.ID));
                                user.setNickName(r.getValue(users.NICK_NAME));
                                user.setHeaderUrl(r.getValue(users.HEADER_URL));
                                saleOrder.setCreatedUser(user);
                            }

                            if(null!= saleOrder.getCustomerId()){
                                Customer customer = new Customer();
                                customer.setId(r.getValue(cust.ID));
                                customer.setName(r.getValue(cust.NAME));
                                customer.setManagerMobile(r.getValue(cust.MANAGER_MOBILE));
                                saleOrder.setCustomer(customer);
                            }

                            return saleOrder;
                        });
    }

    public Mono<SaleOrder> add(SaleOrder saleOrder){
        if(null == saleOrder.getId()){
            saleOrder.setCode(DateUtils.genBusiCode("S", LocalDateTime.now()));
            saleOrder.setCheckStatus(0);
            saleOrder.setStatus(0);
        }
        return saleOrderRepository.save(saleOrder);
    }

    public Mono<SaleOrder> update(Long id, SaleOrder saleOrder){
        return saleOrderRepository.findById(id).flatMap(
                r ->{
                    saleOrder.setId(r.getId());
                    return saleOrderRepository.save(saleOrder);
                }
        );
    }

    public Mono<Void> delete(SaleOrder saleOrder){
        return saleOrderRepository.delete(saleOrder);
    }

    public Mono<Page<SaleOrder>> pageQuery(SaleOrder saleOrderParam, PageRequest pageRequest) {
        com.agri.mis.db.tables.SaleOrder bce =  com.agri.mis.db.tables.SaleOrder.SALE_ORDER;

        com.agri.mis.db.tables.BatchProduct bp = com.agri.mis.db.tables.BatchProduct.BATCH_PRODUCT;

        com.agri.mis.db.tables.Users users =  com.agri.mis.db.tables.Users.USERS;

        com.agri.mis.db.tables.Customer cust =  com.agri.mis.db.tables.Customer.CUSTOMER;

        Condition where = DSL.trueCondition();

        if(StringUtils.hasLength(saleOrderParam.getName())){
            where = where.and(bce.NAME.like("%" + saleOrderParam.getName() +"%"));
        }

        if(null != saleOrderParam.getBatchId()){
            where = where.and(bce.BATCH_ID.eq(saleOrderParam.getBatchId()));
        }

        if(null != saleOrderParam.getCorpId()){
            where = where.and(bce.CORP_ID.eq(saleOrderParam.getCorpId()));
        }

        if(null != saleOrderParam.getCustomerId()){
            where = where.and(bce.CUSTOMER_ID.eq(saleOrderParam.getCustomerId()));
        }

        if(null != saleOrderParam.getCreatedUserId()){
            where = where.and(bce.CREATED_USER_ID.eq(saleOrderParam.getCreatedUserId()));
        }

        if(null != saleOrderParam.getStatus()){
            where = where.and(bce.STATUS.eq(saleOrderParam.getStatus()));
        }
        if(null != saleOrderParam.getCheckStatus()){
            where = where.and(bce.CHECK_STATUS.eq(saleOrderParam.getCheckStatus()));
        }

        var dataSql = dslContext.select(
                bce.ID,
                bce.CORP_ID,
                bce.BATCH_ID,
                bce.NAME,
                bce.CODE,
                bce.AMOUNT,
                bce.QUANTITY,
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
                                            SaleOrder saleOrder = new SaleOrder();
                                            saleOrder.setId(r.getValue(bce.ID));

                                            saleOrder.setName(r.getValue(bce.NAME));
                                            saleOrder.setCode(r.getValue(bce.CODE));

                                            if(null != r.getValue(bce.QUANTITY)) {
                                                saleOrder.setQuantity(r.getValue(bce.QUANTITY).doubleValue());
                                            }else{
                                                saleOrder.setQuantity(null);
                                            }

                                            saleOrder.setAmount(r.getValue(bce.AMOUNT));
                                            saleOrder.setCorpId(r.getValue(bce.CORP_ID));

                                            saleOrder.setBatchId(r.getValue(bce.BATCH_ID));

                                            saleOrder.setCheckStatus(r.getValue(bce.CHECK_STATUS));
                                            saleOrder.setStatus(r.getValue(bce.STATUS));
                                            saleOrder.setCreatedAt(r.getValue(bce.CREATED_AT));
                                            saleOrder.setCreatedUserId(r.getValue(bce.CREATED_USER_ID));
                                            saleOrder.setDescription(r.getValue(bce.DESCRIPTION));
                                            saleOrder.setOccurAt(r.getValue(bce.OCCUR_AT));
                                            if(null!= saleOrder.getBatchId()){
                                                BatchProduct batchProduct = new BatchProduct();
                                                batchProduct.setId(r.getValue(bp.ID));
                                                batchProduct.setName(r.getValue(bp.NAME));
                                                batchProduct.setCode(r.getValue(bp.CODE));
                                                saleOrder.setBatchProduct(batchProduct);
                                            }
                                            if(null!= saleOrder.getCreatedUserId()){
                                               User user = new User();
                                               user.setId(r.getValue(users.ID));
                                                user.setNickName(r.getValue(users.NICK_NAME));
                                                user.setHeaderUrl(r.getValue(users.HEADER_URL));
                                                saleOrder.setCreatedUser(user);
                                            }

                                            if(null!= saleOrder.getCustomerId()){
                                                Customer customer = new Customer();
                                                customer.setId(r.getValue(cust.ID));
                                                customer.setName(r.getValue(cust.NAME));
                                                customer.setManagerMobile(r.getValue(cust.MANAGER_MOBILE));
                                                saleOrder.setCustomer(customer);
                                            }

                                            return saleOrder;
                                        }).collectList(),Mono.from(countSql).map(Record1::value1))
                .map(it -> new PageImpl<>(it.getT1(),pageRequest,it.getT2()));
    }


}
