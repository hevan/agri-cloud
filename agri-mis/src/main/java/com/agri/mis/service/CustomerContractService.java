package com.agri.mis.service;

import com.agri.mis.domain.Customer;
import com.agri.mis.domain.CustomerContract;
import com.agri.mis.repository.CustomerContractRepository;
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
public class CustomerContractService {

    @Autowired
    private CustomerContractRepository customerContractRepository;

    @Autowired
    private DSLContext dslContext;

    public Mono<CustomerContract> findById(Long id) {

        com.agri.mis.db.tables.Customer TB_CUSTOMER = com.agri.mis.db.tables.Customer.CUSTOMER;
        com.agri.mis.db.tables.CustomerContract TB_CUSTOMER_CONTRACT =  com.agri.mis.db.tables.CustomerContract.CUSTOMER_CONTRACT;

        Condition where = DSL.trueCondition();


          where = where.and(TB_CUSTOMER_CONTRACT.ID.eq(id));

        var dataSql = dslContext.select(
                TB_CUSTOMER_CONTRACT.ID,
                TB_CUSTOMER_CONTRACT.NAME,
                TB_CUSTOMER_CONTRACT.CODE,
                TB_CUSTOMER_CONTRACT.DESCRIPTION,
                TB_CUSTOMER_CONTRACT.START_AT,
                TB_CUSTOMER_CONTRACT.END_AT,
                TB_CUSTOMER_CONTRACT.CUSTOMER_ID,
                TB_CUSTOMER_CONTRACT.CORP_ID,
                TB_CUSTOMER_CONTRACT.CREATED_AT,
                TB_CUSTOMER_CONTRACT.CREATED_USER_ID,
                TB_CUSTOMER_CONTRACT.SIGN_AT,

                TB_CUSTOMER.ID,
                TB_CUSTOMER.NAME,
                TB_CUSTOMER.CODE,
                TB_CUSTOMER.DESCRIPTION,
                TB_CUSTOMER.MANAGER_NAME,
                TB_CUSTOMER.MANAGER_MOBILE,
                TB_CUSTOMER.ADDRESS_ID,
                TB_CUSTOMER.CORP_ID,
                TB_CUSTOMER.IS_CUSTOMER,
                TB_CUSTOMER.IS_SUPPLY,
                TB_CUSTOMER.CREATED_AT,
                TB_CUSTOMER.CREATED_USER_ID

        ).from(TB_CUSTOMER_CONTRACT).leftJoin(TB_CUSTOMER).on(TB_CUSTOMER_CONTRACT.CUSTOMER_ID.eq(TB_CUSTOMER.ID)).where(where);

        return Mono.from(dataSql)
                .map(r -> {
                    CustomerContract customerContract = new CustomerContract();
                    customerContract.setId(r.getValue(TB_CUSTOMER_CONTRACT.ID));
                    customerContract.setName(r.getValue(TB_CUSTOMER_CONTRACT.NAME));
                    customerContract.setCode(r.getValue(TB_CUSTOMER_CONTRACT.CODE));
                    customerContract.setDescription(r.getValue(TB_CUSTOMER_CONTRACT.DESCRIPTION));
                    customerContract.setStartAt(r.getValue(TB_CUSTOMER_CONTRACT.START_AT));
                    customerContract.setEndAt(r.getValue(TB_CUSTOMER_CONTRACT.END_AT));
                    customerContract.setCustomerId(r.getValue(TB_CUSTOMER_CONTRACT.CUSTOMER_ID));
                    customerContract.setCreatedAt(r.getValue(TB_CUSTOMER_CONTRACT.CREATED_AT));
                    customerContract.setSignAt(r.getValue(TB_CUSTOMER_CONTRACT.SIGN_AT));
                    customerContract.setCreatedUserId(r.getValue(TB_CUSTOMER_CONTRACT.CREATED_USER_ID));

                    if (null != customerContract.getCustomerId()){
                        Customer customer = new Customer(r.getValue(TB_CUSTOMER.ID), r.getValue(TB_CUSTOMER.NAME), r.getValue(TB_CUSTOMER.CODE), r.getValue(TB_CUSTOMER.DESCRIPTION), r.getValue(TB_CUSTOMER.MANAGER_NAME), r.getValue(TB_CUSTOMER.MANAGER_MOBILE), r.getValue(TB_CUSTOMER.ADDRESS_ID), r.getValue(TB_CUSTOMER.CORP_ID), r.getValue(TB_CUSTOMER.IS_CUSTOMER), r.getValue(TB_CUSTOMER.IS_SUPPLY), r.getValue(TB_CUSTOMER.CREATED_AT), r.getValue(TB_CUSTOMER.CREATED_USER_ID), null);

                        customerContract.setCustomer(customer);
                    }

                    return customerContract;
                });
    }


    public Flux<CustomerContract> findAllByCustomerId(Long customerId) {
        return customerContractRepository.findAllByCustomerId(customerId);
    }

    public Mono<Page<CustomerContract>> pageQuery(CustomerContract customerContractParam, PageRequest pageRequest) {


        com.agri.mis.db.tables.Customer TB_CUSTOMER = com.agri.mis.db.tables.Customer.CUSTOMER;
        com.agri.mis.db.tables.CustomerContract TB_CUSTOMER_CONTRACT =  com.agri.mis.db.tables.CustomerContract.CUSTOMER_CONTRACT;

        Condition where = DSL.trueCondition();

        if(StringUtils.hasLength(customerContractParam.getName())){
            where = where.and(TB_CUSTOMER_CONTRACT.NAME.like("%" + customerContractParam.getName() +"%"));
        }

        if(StringUtils.hasLength(customerContractParam.getCode())){
            where = where.and(TB_CUSTOMER_CONTRACT.CODE.like("%" + customerContractParam.getCode() +"%"));
        }

        if(null != customerContractParam.getCorpId()){
            where = where.and(TB_CUSTOMER_CONTRACT.CORP_ID.eq(customerContractParam.getCorpId()));
        }

        if(null != customerContractParam.getCustomerId()){
            where = where.and(TB_CUSTOMER_CONTRACT.CUSTOMER_ID.eq(customerContractParam.getCustomerId()));
        }

        var dataSql = dslContext.select(
                TB_CUSTOMER_CONTRACT.ID,
                TB_CUSTOMER_CONTRACT.NAME,
                TB_CUSTOMER_CONTRACT.CODE,
                TB_CUSTOMER_CONTRACT.DESCRIPTION,
                TB_CUSTOMER_CONTRACT.START_AT,
                TB_CUSTOMER_CONTRACT.END_AT,
                TB_CUSTOMER_CONTRACT.CUSTOMER_ID,
                TB_CUSTOMER_CONTRACT.CORP_ID,
                TB_CUSTOMER_CONTRACT.CREATED_AT,
                TB_CUSTOMER_CONTRACT.CREATED_USER_ID,
                TB_CUSTOMER_CONTRACT.SIGN_AT,

                TB_CUSTOMER.ID,
                TB_CUSTOMER.NAME,
                TB_CUSTOMER.CODE,
                TB_CUSTOMER.DESCRIPTION,
                TB_CUSTOMER.MANAGER_NAME,
                TB_CUSTOMER.MANAGER_MOBILE,
                TB_CUSTOMER.ADDRESS_ID,
                TB_CUSTOMER.CORP_ID,
                TB_CUSTOMER.IS_CUSTOMER,
                TB_CUSTOMER.IS_SUPPLY,
                TB_CUSTOMER.CREATED_AT,
                TB_CUSTOMER.CREATED_USER_ID

        ).from(TB_CUSTOMER_CONTRACT).leftJoin(TB_CUSTOMER).on(TB_CUSTOMER_CONTRACT.CUSTOMER_ID.eq(TB_CUSTOMER.ID)).where(where).limit(pageRequest.getOffset(), pageRequest.getPageSize());

        val countSql = dslContext.select(DSL.field("count(*)", SQLDataType.BIGINT))
                .from(TB_CUSTOMER_CONTRACT)
                .where(where);

        return Mono
                .zip(
                        Flux.from(dataSql)
                                .map(r -> {
                                    CustomerContract customerContract = new CustomerContract();
                                    customerContract.setId(r.getValue(TB_CUSTOMER_CONTRACT.ID));
                                    customerContract.setName(r.getValue(TB_CUSTOMER_CONTRACT.NAME));
                                    customerContract.setCode(r.getValue(TB_CUSTOMER_CONTRACT.CODE));
                                    customerContract.setDescription(r.getValue(TB_CUSTOMER_CONTRACT.DESCRIPTION));
                                    customerContract.setStartAt(r.getValue(TB_CUSTOMER_CONTRACT.START_AT));
                                    customerContract.setEndAt(r.getValue(TB_CUSTOMER_CONTRACT.END_AT));
                                    customerContract.setCustomerId(r.getValue(TB_CUSTOMER_CONTRACT.CUSTOMER_ID));
                                    customerContract.setCreatedAt(r.getValue(TB_CUSTOMER_CONTRACT.CREATED_AT));
                                    customerContract.setSignAt(r.getValue(TB_CUSTOMER_CONTRACT.SIGN_AT));
                                    customerContract.setCreatedUserId(r.getValue(TB_CUSTOMER_CONTRACT.CREATED_USER_ID));

                                    if (null != customerContract.getCustomerId()){
                                        Customer customer = new Customer(r.getValue(TB_CUSTOMER.ID), r.getValue(TB_CUSTOMER.NAME), r.getValue(TB_CUSTOMER.CODE), r.getValue(TB_CUSTOMER.DESCRIPTION), r.getValue(TB_CUSTOMER.MANAGER_NAME), r.getValue(TB_CUSTOMER.MANAGER_MOBILE), r.getValue(TB_CUSTOMER.ADDRESS_ID), r.getValue(TB_CUSTOMER.CORP_ID), r.getValue(TB_CUSTOMER.IS_CUSTOMER), r.getValue(TB_CUSTOMER.IS_SUPPLY), r.getValue(TB_CUSTOMER.CREATED_AT), r.getValue(TB_CUSTOMER.CREATED_USER_ID), null);

                                        customerContract.setCustomer(customer);
                                }

                                    return customerContract;
                                })
                                .collectList(),
                        Mono.from(countSql)
                                .map(Record1::value1)
                )
                .map(it -> new PageImpl<>(it.getT1(), pageRequest, it.getT2()));


    }

    public Mono<CustomerContract> add(CustomerContract customerContract) {
        return customerContractRepository.save(customerContract);
    }

    public Mono<CustomerContract> update(Long id, CustomerContract customerContract) {
        return customerContractRepository.findById(id)
                .flatMap(s -> {
                    customerContract.setId(s.getId());
                    return customerContractRepository.save(customerContract);
                });
    }

    public Mono<Void> delete(CustomerContract customerContract) {
        return customerContractRepository.delete(customerContract);
    }
}
