package com.agri.mis.service;

import com.agri.mis.domain.CmsBlog;
import com.agri.mis.domain.CmsCategory;
import com.agri.mis.dto.CmsBlogInfo;
import com.agri.mis.repository.CmsBlogRepository;
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
public class CmsBlogService {

    @Autowired
    private CmsBlogRepository cmsBlogRepository;

    @Autowired
    private DSLContext dslContext;

    public Mono<CmsBlog> findById(Long id) {

        com.agri.mis.db.tables.CmsBlog TB_CMS_BLOG = com.agri.mis.db.tables.CmsBlog.CMS_BLOG;
        com.agri.mis.db.tables.CmsCategory TB_CMS_CATEGORY =  com.agri.mis.db.tables.CmsCategory.CMS_CATEGORY;

        var dataSql = dslContext.select(
                TB_CMS_BLOG.ID,
                TB_CMS_BLOG.TITLE,
                TB_CMS_BLOG.STATUS,
                TB_CMS_BLOG.CHECK_STATUS,
                TB_CMS_BLOG.AUTHOR,
                TB_CMS_BLOG.PRISE_UP,
                TB_CMS_BLOG.PRISE_DOWN,
                TB_CMS_BLOG.CATEGORY_ID,
                TB_CMS_BLOG.CREATED_AT,
                TB_CMS_BLOG.CREATED_BY,
                TB_CMS_BLOG.TAGS,
                TB_CMS_BLOG.DESCRIPTION,
                TB_CMS_BLOG.CREATED_USER_ID,
                TB_CMS_BLOG.CONTENT,
                TB_CMS_BLOG.PUBLISH_AT,
                TB_CMS_BLOG.IMAGE_URL,
                TB_CMS_BLOG.VIDEO_URL,
                TB_CMS_CATEGORY.CODE,
                TB_CMS_CATEGORY.NAME

        ).from(TB_CMS_BLOG).leftJoin(TB_CMS_CATEGORY).on(TB_CMS_BLOG.CATEGORY_ID.eq(TB_CMS_CATEGORY.ID)).where(TB_CMS_BLOG.ID.eq(id));


        return Mono.from(dataSql).map(r -> {
            CmsBlog cmsBlog = new CmsBlog(r.value1(), r.value2(), r.value3(),r.value4(), r.value5(), r.value6(), r.value7(), r.value8(),r.value9(),r.value10(),r.value11(),r.value12(),r.value13(),r.value14(), r.value15(),r.value16(),r.value17(),null);

            //Address convert from
            if(null != cmsBlog.getCategoryId()) {
                CmsCategory cmsCategory = new CmsCategory(r.value8(), r.value18(),r.value19(),null);
                cmsBlog.setCategory(cmsCategory);
            }

            return cmsBlog;
        });
    }


    public Mono<CmsBlog> add(CmsBlog cmsBlog) {
        return cmsBlogRepository.save(cmsBlog);
    }

    public Mono<CmsBlog> update(Long id, CmsBlog cmsBlog) {
        return cmsBlogRepository.findById(id)
                .flatMap(s -> {
                    cmsBlog.setId(s.getId());
                    return cmsBlogRepository.save(cmsBlog);
                });
    }

    public Mono<Void> delete(CmsBlog cmsBlog) {
        return cmsBlogRepository.delete(cmsBlog);
    }


    public Mono<Page<CmsBlogInfo>> pageQuery(CmsBlog cmsBlog, PageRequest pageRequest) {

        com.agri.mis.db.tables.CmsBlog TB_CMS_BLOG = com.agri.mis.db.tables.CmsBlog.CMS_BLOG;
        com.agri.mis.db.tables.CmsCategory TB_CMS_CATEGORY =  com.agri.mis.db.tables.CmsCategory.CMS_CATEGORY;

        Condition whereA = DSL.trueCondition();

        if(StringUtils.hasLength(cmsBlog.getTitle())){
            whereA = whereA.and(TB_CMS_BLOG.TITLE.like("%" + cmsBlog.getTitle() +"%").or(TB_CMS_BLOG.TAGS.like("%" + cmsBlog.getTags() +"%")));
        }
        if(null != cmsBlog.getCategoryId()){
            whereA = whereA.and(TB_CMS_BLOG.CATEGORY_ID.eq(cmsBlog.getCategoryId()));
        }
        var dataSql = dslContext.select(
                TB_CMS_BLOG.ID,
                TB_CMS_BLOG.TITLE,
                TB_CMS_BLOG.AUTHOR,
                TB_CMS_BLOG.PRISE_UP,
                TB_CMS_BLOG.PRISE_DOWN,
                TB_CMS_BLOG.CATEGORY_ID,
                TB_CMS_CATEGORY.CODE,
                TB_CMS_CATEGORY.NAME,
                TB_CMS_BLOG.TAGS,
                TB_CMS_BLOG.DESCRIPTION,
                TB_CMS_BLOG.PUBLISH_AT,
                TB_CMS_BLOG.IMAGE_URL,
                TB_CMS_BLOG.VIDEO_URL
        ).from(TB_CMS_BLOG).leftJoin(TB_CMS_CATEGORY).on(TB_CMS_BLOG.CATEGORY_ID.eq(TB_CMS_CATEGORY.ID)).where(whereA);

        val countSql = dslContext.select(DSL.field("count(*)", SQLDataType.BIGINT))
                .from(TB_CMS_BLOG)
                .where(whereA);


        return Mono
                .zip(
                        Flux.from(dataSql)
                                .map(r -> new CmsBlogInfo(r.value1(),r.value2(),r.value3(),r.value4(),r.value5(),r.value6(),r.value7(),r.value8(),r.value9(),r.value10(),r.value11(),r.value12(),r.value13()))
                                .collectList(),
                        Mono.from(countSql)
                                .map(Record1::value1)
                )
                .map(it -> new PageImpl<>(it.getT1(), pageRequest, it.getT2()));

    }

}
