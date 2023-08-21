package com.agri.mis.service;

import com.agri.mis.domain.MarkCategory;
import com.agri.mis.repository.MarkCategoryRepository;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//业务层
@Service
public class MarkCategoryService {

    @Autowired
    private MarkCategoryRepository markCategoryRepository;//数据操作层

    @Autowired
    private DSLContext context;


    public Mono<MarkCategory> findById(Long id) {
        return markCategoryRepository.findById(id);
    }

    public Mono<MarkCategory> add(MarkCategory markCategory){
        return markCategoryRepository.save(markCategory);
    }

    public Mono<MarkCategory> update(Long id,MarkCategory markCategory){
        return markCategoryRepository.findById(id).flatMap(
                s ->{
                    markCategory.setId(s.getId());
                    return markCategoryRepository.save(markCategory);
                });
    }

    public Mono<Void> delete(MarkCategory markCategory){
        return markCategoryRepository.delete(markCategory);
    }

    public Mono<Page<MarkCategory>> pageQuery(MarkCategory markCategoryParam,PageRequest pageRequest){

        com.agri.mis.db.tables.MarkCategory ct = com.agri.mis.db.tables.MarkCategory.MARK_CATEGORY;

        Condition where = DSL.trueCondition();

        if(null != markCategoryParam && StringUtils.hasLength(markCategoryParam.getName())){
            where = where.and(ct.NAME.like("%"+markCategoryParam.getName()+"%"));
        }
        var dataSql =  context.select(
                ct.ID,
                ct.NAME,
                ct.IMAGE_URL,
                ct.PARENT_ID

        ).from(ct).where(where).limit(pageRequest.getOffset(),pageRequest.getPageSize());
        var countSql =  context.select(DSL.field("count(*)", SQLDataType.BIGINT))
                .from(ct)
                .where(where);
        return Mono.zip(Flux.from(dataSql)
                        .map(r->{
                            MarkCategory category1 = new MarkCategory();
                            category1.setId(r.getValue(ct.ID));
                            category1.setImageUrl(r.getValue(ct.IMAGE_URL));
                            category1.setName(r.getValue(ct.NAME));
                            category1.setParentId(r.getValue(ct.PARENT_ID));

                            return category1;
                        }).collectList(),Mono.from(countSql).map(Record1::value1))
                .map(it -> new PageImpl<>(it.getT1(),pageRequest,it.getT2()));

    }

}
