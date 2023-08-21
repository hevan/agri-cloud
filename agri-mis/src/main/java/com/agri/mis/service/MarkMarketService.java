package com.agri.mis.service;

import com.agri.mis.domain.Address;
import com.agri.mis.domain.MarkMarket;
import com.agri.mis.repository.AddressRepository;
import com.agri.mis.repository.MarkMarketRepository;
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
public class MarkMarketService {

    @Autowired
    private MarkMarketRepository markMarketRepository;//数据操作

    @Autowired
    private AddressRepository addressRepository;//数据操作

    @Autowired
    private DSLContext context;

    public Mono<MarkMarket> findById(Long id){//根据id查询单个MarkProduct
        return markMarketRepository.findById(id);
    }

    public Mono<MarkMarket> add(MarkMarket markMarket){//根据markMarket进行数据添加

        if(null != markMarket.getAddress()){
           return  addressRepository.save(markMarket.getAddress()).flatMap(s-> {
                markMarket.setAddressId(s.getId());
                return markMarketRepository.save(markMarket);
            });
        }
        return markMarketRepository.save(markMarket);
    }

    public Mono<MarkMarket> update(Long id, MarkMarket markMarket){
        return markMarketRepository.findById(id).flatMap(
                s->{
                    markMarket.setId(s.getId());
                    return markMarketRepository.save(markMarket);
                });
    }

    public Mono<Void> dalete(MarkMarket markMarket){
        return markMarketRepository.delete(markMarket);
    }

    public Mono<Page<MarkMarket>> pageQuery(MarkMarket markMarketParam, PageRequest request){

        com.agri.mis.db.tables.Address address = com.agri.mis.db.tables.Address.ADDRESS;

        com.agri.mis.db.tables.MarkMarket markMarket = com.agri.mis.db.tables.MarkMarket.MARK_MARKET;

        Condition where = DSL.trueCondition();

        if(StringUtils.hasLength(markMarketParam.getName())){
            where = where.and(markMarket.NAME.like("%"+markMarketParam.getName()+"%"));
        }
        var dataSql = context.select(
                markMarket.ID,
                markMarket.ADDRESS_ID,
                markMarket.MARKET_TYPE,
                markMarket.NAME,

                address.ID,
                address.PROVINCE,
                address.CITY,
                address.REGION,
                address.LINE_DETAIL,
                address.LINK_NAME,
                address.LINK_MOBILE,
                address.CREATED_AT


        ).from(markMarket).leftJoin(address).on(markMarket.ADDRESS_ID.eq(address.ID)).where(where).limit(request.getOffset(),request.getPageSize());
        var countSql =  context.select(DSL.field("count(*)", SQLDataType.BIGINT))
                .from(markMarket)
                .where(where);
        return Mono.zip(Flux.from(dataSql)
                                .map(r->{
                                    MarkMarket markMarket1 = new MarkMarket();
                                    markMarket1.setMarketType(r.getValue(markMarket.MARKET_TYPE));
                                    markMarket1.setId(r.getValue(markMarket.ID));
                                    markMarket1.setName(r.getValue(markMarket.NAME));
                                    markMarket1.setAddressId(r.getValue(markMarket.ADDRESS_ID));
                                    //category convert from
                                    if(null!=markMarket1.getAddressId()) {

                                        Address address1 = new Address();
                                        address1.setId(r.getValue(address.ID));
                                        address1.setProvince(r.getValue(address.PROVINCE));
                                        address1.setCity(r.getValue(address.CITY));
                                        address1.setRegion(r.getValue(address.REGION));
                                        address1.setLineDetail(r.getValue(address.LINE_DETAIL));
                                        address1.setLinkName(r.getValue(address.LINK_NAME));
                                        address1.setLinkMobile(r.getValue(address.LINK_MOBILE));
                                        markMarket1.setAddress(address1);
                                    }
                                    return markMarket1;
                                })
                                .collectList(),
                        Mono.from(countSql).map(Record1::value1)
                ).map(it -> new PageImpl<>(it.getT1(),request,it.getT2()));
    }
}
