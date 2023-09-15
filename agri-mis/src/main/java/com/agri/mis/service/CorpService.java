package com.agri.mis.service;

import com.agri.mis.domain.Address;
import com.agri.mis.domain.Corp;
import com.agri.mis.domain.CorpManager;
import com.agri.mis.repository.AddressRepository;
import com.agri.mis.repository.CorpManagerRepository;
import com.agri.mis.repository.CorpRepository;
import com.agri.mis.repository.SysMenuRepository;
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
import static org.jooq.impl.DSL.selectCount;


@Service
public class CorpService {

    @Autowired
    private CorpRepository corpRepository;

    @Autowired
    private CorpManagerRepository corpManagerRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private SysMenuRepository sysMenuRepository;

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
           Corp corp = new Corp();
           corp.setId(r.getValue(ct.ID));
           corp.setName(r.getValue(ct.NAME));
           corp.setCode(r.getValue(ct.CODE));
           corp.setDescription(r.getValue(ct.DESCRIPTION));
           corp.setAddressId(r.getValue(ct.ADDRESS_ID));
           corp.setCreatedAt(r.getValue(ct.CREATED_AT));

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

        com.agri.mis.db.tables.BatchProduct bt =  com.agri.mis.db.tables.BatchProduct.BATCH_PRODUCT;
        com.agri.mis.db.tables.BatchTeam tm =  com.agri.mis.db.tables.BatchTeam.BATCH_TEAM;
        com.agri.mis.db.tables.BatchCycle bc =  com.agri.mis.db.tables.BatchCycle.BATCH_CYCLE;
        com.agri.mis.db.tables.CheckApply ca =  com.agri.mis.db.tables.CheckApply.CHECK_APPLY;
        com.agri.mis.db.tables.CheckTrace cc =  com.agri.mis.db.tables.CheckTrace.CHECK_TRACE;

        com.agri.mis.db.tables.CorpManager CORP_MANAGER = com.agri.mis.db.tables.CorpManager.CORP_MANAGER;

        var dataSql = dslContext.select(
                ct.ID,
                ct.NAME,
                ct.CODE,
                ct.ADDRESS_ID,
                ct.DESCRIPTION,
                ct.CREATED_AT,

                selectCount().from(bt).where(bt.STATUS.lessOrEqual(1).and(bt.CORP_ID.eq(ct.ID)).and(bt.ID.in(select(tm.BATCH_ID).from(tm).where(tm.USER_ID.eq(userId))))).asField("countProject"),
                selectCount().from(bc).where(bc.STATUS.lessOrEqual((short) 1).and(bc.CREATED_USER_ID.eq(userId)).and(bc.CORP_ID.eq(ct.ID))).asField("countTask"),
                selectCount().from(ca).where(ca.STATUS.lessOrEqual(1).and(ca.USER_ID.eq(userId)).and(ca.CORP_ID.eq(ct.ID))).asField("countApply"),
                selectCount().from(cc).where(cc.STATUS.eq(0).and(cc.USER_ID.eq(userId)).and(cc.CORP_ID.eq(ct.ID))).asField("countCheck"),

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
            Corp corp = new Corp();
            corp.setId(r.getValue(ct.ID));
            corp.setName(r.getValue(ct.NAME));
            corp.setCode(r.getValue(ct.CODE));
            corp.setDescription(r.getValue(ct.DESCRIPTION));
            corp.setAddressId(r.getValue(ct.ADDRESS_ID));
            corp.setCreatedAt(r.getValue(ct.CREATED_AT));

            corp.setCountProject((Integer) r.getValue("countProject"));
            corp.setCountTask((Integer) r.getValue("countTask"));
            corp.setCountApply((Integer) r.getValue("countApply"));
            corp.setCountCheck((Integer) r.getValue("countCheck"));

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
        }).flatMap(c->{
            return corpManagerRepository.save(new CorpManager(null, corp.getCreatedUserId(), c.getId(), LocalDateTime.now(), null, null, null)).then(Mono.just(c));

        }).flatMap(ct->{
           return sysMenuRepository.findAllByCorpId(1L).flatMap(sm->{
               sm.setId(null);
               sm.setCorpId(ct.getId());
               return sysMenuRepository.save(sm);
           }).then(Mono.just(ct));
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

    public Mono<Page<Corp>> pageQuery(Corp corpParam, PageRequest pageRequest) {


        com.agri.mis.db.tables.Corp ct = com.agri.mis.db.tables.Corp.CORP;
        com.agri.mis.db.tables.Address at =  com.agri.mis.db.tables.Address.ADDRESS;

        Condition where = DSL.trueCondition();

        if(null != corpParam.getCreatedUserId()){
            where = where.and(ct.CREATED_USER_ID.eq(corpParam.getCreatedUserId()));
        }

        if(StringUtils.hasLength(corpParam.getName())){
            where = where.and(ct.NAME.like("%" + corpParam.getName() +"%"));
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
                                   Corp corp = new Corp();
                                    corp.setId(r.getValue(ct.ID));
                                    corp.setName(r.getValue(ct.NAME));
                                    corp.setCode(r.getValue(ct.CODE));
                                    corp.setDescription(r.getValue(ct.DESCRIPTION));
                                    corp.setAddressId(r.getValue(ct.ADDRESS_ID));
                                    corp.setCreatedAt(r.getValue(ct.CREATED_AT));
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

    }
}