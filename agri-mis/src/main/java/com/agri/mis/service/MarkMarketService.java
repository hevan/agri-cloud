package com.agri.mis.service;

import com.agri.mis.domain.Address;
import com.agri.mis.domain.MarkCategory;
import com.agri.mis.domain.MarkMarket;
import com.agri.mis.dto.MarkMarketWithCategoryWithAddress;
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
    private DSLContext context;

    public Mono<MarkMarket> findById(Long id){//根据id查询单个MarkProduct
        return markMarketRepository.findById(id);
    }

    public Mono<MarkMarket> add(MarkMarket markMarket){//根据markMarket进行数据添加
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

    public Mono<Page<MarkMarketWithCategoryWithAddress>> pageQuery(String name, PageRequest request){

        com.agri.mis.db.tables.Address address = com.agri.mis.db.tables.Address.ADDRESS;

        com.agri.mis.db.tables.MarkCategory category = com.agri.mis.db.tables.MarkCategory.MARK_CATEGORY;

        com.agri.mis.db.tables.MarkMarket markMarket = com.agri.mis.db.tables.MarkMarket.MARK_MARKET;

        Condition where = DSL.trueCondition();

        if(StringUtils.hasLength(name)){
            where = where.and(markMarket.NAME.like("%"+name+"%"));
        }
        var dataSql = context.select(
                markMarket.ID,
                markMarket.ADDRESS_ID,
                markMarket.CATEGORY_ID,
                markMarket.NAME,
                category.ID,

                category.NAME,
                category.IMAGE_URL,
                category.PARENT_ID,

                address.ID,
                address.PROVINCE,
                address.CITY,
                address.REGION,
                address.LINE_DETAIL,
                address.LINK_NAME,
                address.LINK_MOBILE,
                address.CREATED_AT


        ).from(markMarket).leftJoin(category).on(markMarket.CATEGORY_ID.eq(category.ID)).rightJoin(address).on(markMarket.ADDRESS_ID.eq(address.ID)).where(where).limit(request.getOffset(),request.getPageSize());
        var countSql =  context.select(DSL.field("count(*)", SQLDataType.BIGINT))
                .from(markMarket)
                .where(where);
        return Mono.zip(Flux.from(dataSql)
                                .map(r->{
                                    MarkMarket markMarket1 = new MarkMarket(r.getValue(markMarket.ID),
                                            r.getValue(markMarket.NAME),
                                            r.getValue(markMarket.ADDRESS_ID),
                                            r.getValue(markMarket.CATEGORY_ID)
                                            );
                                    //category convert from
                                    if(null!=markMarket1.getId()){
                                        MarkCategory category1 = new MarkCategory(r.getValue(category.ID),r.getValue(category.NAME),
                                                r.getValue(category.IMAGE_URL),r.getValue(category.PARENT_ID)
                                        );

                                        Address address1 = new Address(r.getValue(address.ID
                                        ),r.getValue(address.PROVINCE),r.getValue(address.CITY),
                                                r.getValue(address.REGION),r.getValue(address.LINE_DETAIL)
                                                ,r.getValue(address.LINK_NAME),r.getValue(address.LINK_MOBILE),null,r.getValue(address.CREATED_AT));
                                        return new MarkMarketWithCategoryWithAddress(markMarket1,category1,address1);
                                    }else{
                                        return new MarkMarketWithCategoryWithAddress(markMarket1,null,null);
                                    }
                                })
                                .collectList(),
                        Mono.from(countSql).map(Record1::value1)
                ).map(it -> new PageImpl<>(it.getT1(),request,it.getT2()));
    }
}
