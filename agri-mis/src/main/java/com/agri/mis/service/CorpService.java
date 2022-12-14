package com.agri.mis.service;

import com.agri.mis.domain.Address;
import com.agri.mis.domain.Corp;
import com.agri.mis.repository.AddressRepository;
import com.agri.mis.repository.CorpRepository;
import lombok.val;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import static org.jooq.impl.DSL.select;


@Service
public class CorpService {

    @Autowired
    private CorpRepository corpRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private DSLContext dslContext;

    public Mono<Corp> findById(Long id) {
        return corpRepository.findById(id);
    }

    public Mono<Corp> findWithAddressById(Long id) {
        com.agri.mis.db.tables.Corp ct = com.agri.mis.db.tables.Corp.CORP;
        com.agri.mis.db.tables.Address at =  com.agri.mis.db.tables.Address.ADDRESS;

        var dataSql = dslContext.select(
                ct.ID,
                ct.NAME,
                ct.CODE,
                ct.ADDRESS_ID,
                ct.DESCRIPTION,
                ct.CREATED_AT,
                at.ID,
                at.PROVINCE,
                at.CITY,
                at.REGION,
                at.LINE_DETAIL,
                at.LINK_NAME,
                at.LINK_MOBILE,
                at.CREATED_AT

        ).from(ct).leftJoin(at).on(ct.ADDRESS_ID.eq(at.ID)).where(ct.ID.eq(id));


       return Mono.from(dataSql).map(r -> {
           Corp corp = new Corp(r.getValue(ct.ID), r.getValue(ct.NAME), r.getValue(ct.CODE), r.getValue(ct.DESCRIPTION), r.getValue(ct.ADDRESS_ID), r.getValue(ct.CREATED_AT), null);

           //Address convert from
           if(null != corp.getAddressId()) {
               Address address = new Address(r.getValue(at.ID), r.getValue(at.PROVINCE), r.getValue(at.CITY), r.getValue(at.REGION), r.getValue(at.LINE_DETAIL), r.getValue(at.LINK_NAME), r.getValue(at.LINK_MOBILE), null, r.getValue(at.CREATED_AT));
               corp.setAddress(address);
           }

           return corp;
       });
    }

    public Flux<Corp> findCorpByUserId(Long userId) {
        com.agri.mis.db.tables.Corp ct = com.agri.mis.db.tables.Corp.CORP;
        com.agri.mis.db.tables.Address at =  com.agri.mis.db.tables.Address.ADDRESS;

        com.agri.mis.db.tables.CorpManager CORP_MANAGER = com.agri.mis.db.tables.CorpManager.CORP_MANAGER;

        var dataSql = dslContext.select(
                ct.ID,
                ct.NAME,
                ct.CODE,
                ct.ADDRESS_ID,
                ct.DESCRIPTION,
                ct.CREATED_AT,
                at.ID,
                at.PROVINCE,
                at.CITY,
                at.REGION,
                at.LINE_DETAIL,
                at.LINK_NAME,
                at.LINK_MOBILE,
                at.CREATED_AT

        ).from(ct).leftJoin(at).on(ct.ADDRESS_ID.eq(at.ID)).where(ct.ID.in(select(CORP_MANAGER.CORP_ID)
                .from(CORP_MANAGER)
                .where(CORP_MANAGER.USER_ID.eq(userId))));


        return Flux.from(dataSql).map(r -> {
            Corp corp = new Corp(r.getValue(ct.ID), r.getValue(ct.NAME), r.getValue(ct.CODE), r.getValue(ct.DESCRIPTION), r.getValue(ct.ADDRESS_ID), r.getValue(ct.CREATED_AT), null);

            //Address convert from
            if(null != corp.getAddressId()) {
                Address address = new Address(r.getValue(at.ID), r.getValue(at.PROVINCE), r.getValue(at.CITY), r.getValue(at.REGION), r.getValue(at.LINE_DETAIL), r.getValue(at.LINK_NAME), r.getValue(at.LINK_MOBILE), null, r.getValue(at.CREATED_AT));
                corp.setAddress(address);
            }

            return corp;
        });
    }



    public Mono<Corp> add(Corp corp) {

        corp.setCreatedAt(LocalDateTime.now());
        return addressRepository.save(corp.getAddress()).flatMap(s->{
            corp.setAddressId(s.getId());
            return  corpRepository.save(corp);
        });
    }

    public Mono<Corp> update(Long id, Corp corp) {
        return addressRepository.save(corp.getAddress())
                .flatMap(s -> {
                    return corpRepository.save(corp);
                });
    }

    public Mono<Void> delete(Corp corp) {
       return  addressRepository.deleteById(corp.getAddressId()).flatMap(s->corpRepository.delete(corp));
    }

    public Mono<Page<Corp>> pageQuery(String name, PageRequest pageRequest) {


        com.agri.mis.db.tables.Corp ct = com.agri.mis.db.tables.Corp.CORP;
        com.agri.mis.db.tables.Address at =  com.agri.mis.db.tables.Address.ADDRESS;

        Condition where = DSL.trueCondition();

        if(StringUtils.hasLength(name)){
            where = where.and(ct.NAME.like("%" + name +"%"));
        }
        var dataSql = dslContext.select(
                ct.ID,
                ct.NAME,
                ct.CODE,
                ct.ADDRESS_ID,
                ct.DESCRIPTION,
                ct.CREATED_AT,
                at.ID,
                at.PROVINCE,
                at.CITY,
                at.REGION,
                at.LINE_DETAIL,
                at.LINK_NAME,
                at.LINK_MOBILE,
                at.LOCATION,
                at.CREATED_AT

        ).from(ct).leftJoin(at).on(ct.ADDRESS_ID.eq(at.ID)).where(where).limit(pageRequest.getOffset(), pageRequest.getPageSize());

        val countSql = dslContext.select(DSL.field("count(*)", SQLDataType.BIGINT))
                .from(ct)
                .where(where);

        return Mono
                .zip(
                        Flux.from(dataSql)
                                .map(r -> {
                                   Corp corp = new Corp(r.getValue(ct.ID), r.getValue(ct.NAME), r.getValue(ct.CODE), r.getValue(ct.DESCRIPTION), r.getValue(ct.ADDRESS_ID), r.getValue(ct.CREATED_AT), null);

                                   //Address convert from
                                    if(null != corp.getAddressId()) {
                                        Address address = new Address(r.getValue(at.ID), r.getValue(at.PROVINCE), r.getValue(at.CITY), r.getValue(at.REGION), r.getValue(at.LINE_DETAIL), r.getValue(at.LINK_NAME), r.getValue(at.LINK_MOBILE), null, r.getValue(at.CREATED_AT));
                                      corp.setAddress(address);
                                    }

                                    return corp;
                                })
                                .collectList(),
                        Mono.from(countSql)
                                .map(Record1::value1)
                )
                .map(it -> new PageImpl<>(it.getT1(), pageRequest, it.getT2()));
        /*
        Corp corp = new Corp();
        corp.setName(name);
        ExampleMatcher exampleObjectMatcher = ExampleMatcher.matching()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains());
        return this.corpRepository.findBy(Example.of(corp, exampleObjectMatcher), pageRequest)
                .collectList()
                .zipWith(this.corpRepository.count(Example.of(corp, exampleObjectMatcher)))
                .map(t -> new PageImpl<>(t.getT1(), pageRequest, t.getT2()));

         */
    }
}