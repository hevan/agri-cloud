package com.agri.mis.service;

import com.agri.mis.domain.Address;
import com.agri.mis.domain.Corp;
import com.agri.mis.domain.Customer;
import com.agri.mis.repository.AddressRepository;
import com.agri.mis.repository.CorpRepository;
import com.agri.mis.repository.CustomerRepository;
import lombok.val;
import lombok.var;
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
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private DSLContext dslContext;

    public Mono<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    public Mono<Customer> findWithAddressById(Long id) {
        com.agri.mis.db.tables.Customer TB_CUSTOMER = com.agri.mis.db.tables.Customer.CUSTOMER;
        com.agri.mis.db.tables.Address at =  com.agri.mis.db.tables.Address.ADDRESS;

        var dataSql = dslContext.select(
                TB_CUSTOMER.ID,
                TB_CUSTOMER.NAME,
                TB_CUSTOMER.CODE,
                TB_CUSTOMER.DESCRIPTION,
                TB_CUSTOMER.ADDRESS_ID,
                TB_CUSTOMER.CORP_ID,
                TB_CUSTOMER.IS_CUSTOMER,
                TB_CUSTOMER.IS_SUPPLY,
                TB_CUSTOMER.CREATED_AT,
                at.ID,
                at.PROVINCE,
                at.CITY,
                at.REGION,
                at.LINE_DETAIL,
                at.LINK_NAME,
                at.LINK_MOBILE,
                at.CREATED_AT

        ).from(TB_CUSTOMER).leftJoin(at).on(TB_CUSTOMER.ADDRESS_ID.eq(at.ID)).where(TB_CUSTOMER.ADDRESS_ID.eq(id));


       return Mono.from(dataSql).map(r -> {
           Customer customer = new Customer(r.getValue(TB_CUSTOMER.ID), r.getValue(TB_CUSTOMER.NAME), r.getValue(TB_CUSTOMER.CODE), r.getValue(TB_CUSTOMER.DESCRIPTION), r.getValue(TB_CUSTOMER.ADDRESS_ID), r.getValue(TB_CUSTOMER.CORP_ID), r.getValue(TB_CUSTOMER.IS_CUSTOMER), r.getValue(TB_CUSTOMER.IS_SUPPLY), r.getValue(TB_CUSTOMER.CREATED_AT), null);

           //Address convert from
           if(null != customer.getAddressId()) {
               Address address = new Address(r.getValue(at.ID), r.getValue(at.PROVINCE), r.getValue(at.CITY), r.getValue(at.REGION), r.getValue(at.LINE_DETAIL), r.getValue(at.LINK_NAME), r.getValue(at.LINK_MOBILE), null, r.getValue(at.CREATED_AT));
               customer.setAddress(address);
           }

           return customer;
       });
    }


    public Mono<Customer> add(Customer customer) {
        return addressRepository.save(customer.getAddress()).flatMap(s->{
            customer.setAddressId(s.getId());
            return customerRepository.save(customer);
        });
    }

    public Mono<Customer> update(Long id, Customer customer) {
        return addressRepository.save(customer.getAddress()).flatMap(
                s -> customerRepository.save(customer));
    }

    public Mono<Void> delete(Customer customer) {
        return addressRepository.deleteById(customer.getAddressId()).flatMap(
                s-> customerRepository.delete(customer)
        );
    }

    public Mono<Page<Customer>> pageQuery(String name, PageRequest pageRequest) {


        com.agri.mis.db.tables.Customer TB_CUSTOMER = com.agri.mis.db.tables.Customer.CUSTOMER;
        com.agri.mis.db.tables.Address at =  com.agri.mis.db.tables.Address.ADDRESS;

        Condition where = DSL.trueCondition();

        if(StringUtils.hasLength(name)){
            where = where.and(TB_CUSTOMER.NAME.like("%" + name +"%"));
        }
        var dataSql = dslContext.select(
                TB_CUSTOMER.ID,
                TB_CUSTOMER.NAME,
                TB_CUSTOMER.CODE,
                TB_CUSTOMER.DESCRIPTION,
                TB_CUSTOMER.ADDRESS_ID,
                TB_CUSTOMER.CORP_ID,
                TB_CUSTOMER.IS_CUSTOMER,
                TB_CUSTOMER.IS_SUPPLY,
                TB_CUSTOMER.CREATED_AT,
                at.ID,
                at.PROVINCE,
                at.CITY,
                at.REGION,
                at.LINE_DETAIL,
                at.LINK_NAME,
                at.LINK_MOBILE,
                at.CREATED_AT

        ).from(TB_CUSTOMER).leftJoin(at).on(TB_CUSTOMER.ADDRESS_ID.eq(at.ID)).where(where).limit(pageRequest.getOffset(), pageRequest.getPageSize());

        val countSql = dslContext.select(DSL.field("count(*)", SQLDataType.BIGINT))
                .from(TB_CUSTOMER)
                .where(where);

        return Mono
                .zip(
                        Flux.from(dataSql)
                                .map(r -> {
                                    Customer customer = new Customer(r.getValue(TB_CUSTOMER.ID), r.getValue(TB_CUSTOMER.NAME), r.getValue(TB_CUSTOMER.CODE), r.getValue(TB_CUSTOMER.DESCRIPTION), r.getValue(TB_CUSTOMER.ADDRESS_ID), r.getValue(TB_CUSTOMER.CORP_ID), r.getValue(TB_CUSTOMER.IS_CUSTOMER), r.getValue(TB_CUSTOMER.IS_SUPPLY), r.getValue(TB_CUSTOMER.CREATED_AT), null);

                                    //Address convert from
                                    if(null != customer.getAddressId()) {
                                        Address address = new Address(r.getValue(at.ID), r.getValue(at.PROVINCE), r.getValue(at.CITY), r.getValue(at.REGION), r.getValue(at.LINE_DETAIL), r.getValue(at.LINK_NAME), r.getValue(at.LINK_MOBILE), null, r.getValue(at.CREATED_AT));
                                        customer.setAddress(address);
                                    }

                                    return customer;
                                })
                                .collectList(),
                        Mono.from(countSql)
                                .map(Record1::value1)
                )
                .map(it -> new PageImpl<>(it.getT1(), pageRequest, it.getT2()));



    }
}
