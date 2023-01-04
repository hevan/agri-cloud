package com.agri.mis.service;

import com.agri.mis.domain.MarkCategory;
import com.agri.mis.domain.MarkProduct;
import com.agri.mis.dto.MarkProductWithCategory;
import com.agri.mis.repository.MarkProductRepository;

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
public class MarkProductService {
    @Autowired
    private MarkProductRepository markProductRepositry;

    @Autowired
    private DSLContext context;

    public Mono<MarkProduct> findById(Long id){
            return markProductRepositry.findById(id);
    }

    public Mono<MarkProduct> add(MarkProduct markProduct){
        return markProductRepositry.save(markProduct);
    }

    public Mono<MarkProduct> update(Long id,MarkProduct markProduct){
        return markProductRepositry.findById(id).flatMap(
                r->{
                    markProduct.setId(r.getId());
                    return markProductRepositry.save(markProduct);
                });
    }

    public Mono<Void> delete(MarkProduct markProduct){
        return markProductRepositry.delete(markProduct);
    }

    public Mono<Page<MarkProductWithCategory>> pageQuery(String name, PageRequest pageRequest){
        com.agri.mis.db.tables.MarkProduct mp = com.agri.mis.db.tables.MarkProduct.MARK_PRODUCT;
        com.agri.mis.db.tables.MarkCategory ct = com.agri.mis.db.tables.MarkCategory.MARK_CATEGORY;

        Condition where = DSL.trueCondition();

        if(StringUtils.hasLength(name)){
            where = where.and(mp.NAME.like("%"+name+"%"));
        }
        var dataSql =  context.select(
                mp.ID,
                mp.CALC_UNIT,
                mp.CATEGORY_ID,
                mp.NAME,
                mp.CODE,
                mp.DESCRIPTION,
                mp.IMAGE_URL,
                ct.ID,

                ct.NAME,
                ct.IMAGE_URL,
                ct.PARENT_ID

        ).from(mp).leftJoin(ct).on(mp.CATEGORY_ID.eq(ct.ID)).where(where).limit(pageRequest.getOffset(),pageRequest.getPageSize());
        var countSql =  context.select(DSL.field("count(*)", SQLDataType.BIGINT))
                .from(mp)
                .where(where);
        return Mono.zip(Flux.from(dataSql)
                .map(r->{
                    MarkProduct markProduct = new MarkProduct(
                            r.getValue(mp.ID),r.getValue(mp.NAME),r.getValue(mp.CODE),r.getValue(mp.CATEGORY_ID),
                            r.getValue(mp.IMAGE_URL),r.getValue(mp.CALC_UNIT),r.getValue(mp.DESCRIPTION)
                    );
                    if(null!=markProduct.getId()){
                        MarkCategory category1 = new MarkCategory(r.getValue(ct.ID),r.getValue(ct.NAME),
                                r.getValue(ct.IMAGE_URL),r.getValue(ct.PARENT_ID)
                                );
                        return new MarkProductWithCategory(markProduct,category1);
                    }else{
                        return new MarkProductWithCategory(markProduct,null);
                    }

                }).collectList(),Mono.from(countSql).map(Record1::value1))
                .map(it -> new PageImpl<>(it.getT1(),pageRequest,it.getT2()));
    }
}
