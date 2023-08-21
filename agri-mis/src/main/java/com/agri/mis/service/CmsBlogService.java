package com.agri.mis.service;

import com.agri.mis.domain.CmsBlog;
import com.agri.mis.domain.CmsCategory;
import com.agri.mis.dto.CmsBlogInfo;
import com.agri.mis.repository.CmsBlogRepository;
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

import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.selectCount;

@Service
public class CmsBlogService {

    @Autowired
    private CmsBlogRepository cmsBlogRepository;

    @Autowired
    private DSLContext dslContext;

    public Mono<CmsBlog> findById(Long id) {

        com.agri.mis.db.tables.CmsBlog TB_CMS_BLOG = com.agri.mis.db.tables.CmsBlog.CMS_BLOG;
        com.agri.mis.db.tables.CmsCategory TB_CMS_CATEGORY =  com.agri.mis.db.tables.CmsCategory.CMS_CATEGORY;

        com.agri.mis.db.tables.CmsUserActive TB_CMS_USER_ACTIVE =  com.agri.mis.db.tables.CmsUserActive.CMS_USER_ACTIVE;

        var dataSql = dslContext.select(
                TB_CMS_BLOG.ID,
                TB_CMS_BLOG.TITLE,
                TB_CMS_BLOG.STATUS,
                TB_CMS_BLOG.CHECK_STATUS,
                TB_CMS_BLOG.AUTHOR,
                TB_CMS_BLOG.CATEGORY_ID,
                TB_CMS_BLOG.CREATED_AT,
                TB_CMS_BLOG.UPDATED_AT,
                TB_CMS_BLOG.TAGS,
                TB_CMS_BLOG.DESCRIPTION,
                TB_CMS_BLOG.CREATED_USER_ID,
                TB_CMS_BLOG.CONTENT,
                TB_CMS_BLOG.PUBLISH_AT,
                TB_CMS_BLOG.IMAGE_URL,
                TB_CMS_BLOG.VIDEO_URL,
                TB_CMS_BLOG.CORP_ID,

                TB_CMS_CATEGORY.CODE,
                TB_CMS_CATEGORY.NAME,

                field(selectCount()
                        .from(TB_CMS_USER_ACTIVE)
                        .where(TB_CMS_USER_ACTIVE.BLOG_ID.eq(TB_CMS_BLOG.ID)).and(TB_CMS_USER_ACTIVE.ACTION.eq("view")).asField("VIEW")),
                field(selectCount()
                        .from(TB_CMS_USER_ACTIVE)
                        .where(TB_CMS_USER_ACTIVE.BLOG_ID.eq(TB_CMS_BLOG.ID)).and(TB_CMS_USER_ACTIVE.ACTION.eq("raiseUp")).asField("RAISE_UP")),
                field(selectCount()
                        .from(TB_CMS_USER_ACTIVE)
                        .where(TB_CMS_USER_ACTIVE.BLOG_ID.eq(TB_CMS_BLOG.ID)).and(TB_CMS_USER_ACTIVE.ACTION.eq("raiseDown")).asField("RAISE_DOWN"))

        ).from(TB_CMS_BLOG).leftJoin(TB_CMS_CATEGORY).on(TB_CMS_BLOG.CATEGORY_ID.eq(TB_CMS_CATEGORY.ID)).where(TB_CMS_BLOG.ID.eq(id));


        return Mono.from(dataSql).map(r -> {
            CmsBlog cmsBlog = new CmsBlog();
            cmsBlog.setId(r.getValue(TB_CMS_BLOG.ID));
            cmsBlog.setTitle(r.getValue(TB_CMS_BLOG.TITLE));
            cmsBlog.setAuthor(r.getValue(TB_CMS_BLOG.AUTHOR));
            cmsBlog.setStatus(r.getValue(TB_CMS_BLOG.STATUS));
            cmsBlog.setCheckStatus(r.getValue(TB_CMS_BLOG.CHECK_STATUS));
            cmsBlog.setCategoryId(r.getValue(TB_CMS_BLOG.CATEGORY_ID));
            cmsBlog.setCreatedAt(r.getValue(TB_CMS_BLOG.CREATED_AT));
            cmsBlog.setUpdatedAt(r.getValue(TB_CMS_BLOG.UPDATED_AT));
            cmsBlog.setTags(r.getValue(TB_CMS_BLOG.TAGS));
            cmsBlog.setDescription(r.getValue(TB_CMS_BLOG.DESCRIPTION));
            cmsBlog.setContent(r.getValue(TB_CMS_BLOG.CONTENT));
            cmsBlog.setImageUrl(r.getValue(TB_CMS_BLOG.IMAGE_URL));
            cmsBlog.setVideoUrl(r.getValue(TB_CMS_BLOG.VIDEO_URL));
            cmsBlog.setPublishAt(r.getValue(TB_CMS_BLOG.PUBLISH_AT));
            cmsBlog.setCorpId(r.getValue(TB_CMS_BLOG.CORP_ID));

            cmsBlog.setCountView(r.getValue("VIEW", Long.class));
            cmsBlog.setCountRaiseDown(r.getValue("RAISE_DOWN", Long.class));
            cmsBlog.setCountRaiseUp(r.getValue("RAISE_UP", Long.class));
            //Address convert from
            if(null != cmsBlog.getCategoryId()) {
                CmsCategory cmsCategory = new CmsCategory();
                cmsCategory.setId(cmsBlog.getCategoryId());
                cmsCategory.setName(r.getValue(TB_CMS_CATEGORY.NAME));
                cmsCategory.setCode(r.getValue(TB_CMS_CATEGORY.CODE));
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
                    s.setTitle(cmsBlog.getTitle());
                    s.setTags(cmsBlog.getTags());
                    s.setDescription(cmsBlog.getDescription());
                    s.setAuthor(cmsBlog.getAuthor());
                    s.setCategory(cmsBlog.getCategory());

                    if(StringUtils.hasLength(cmsBlog.getImageUrl())) {
                        s.setImageUrl(cmsBlog.getImageUrl());
                    }
                    if(StringUtils.hasLength(cmsBlog.getVideoUrl())) {
                        s.setVideoUrl(cmsBlog.getVideoUrl());
                    }

                    if(StringUtils.hasLength(cmsBlog.getContent())){
                        s.setContent(cmsBlog.getContent());
                    }

                    return cmsBlogRepository.save(s);
                });
    }

    public Mono<Void> delete(CmsBlog cmsBlog) {
        return cmsBlogRepository.delete(cmsBlog);
    }


    public Mono<Page<CmsBlogInfo>> pageQuery(CmsBlog cmsBlog, PageRequest pageRequest) {

        com.agri.mis.db.tables.CmsBlog TB_CMS_BLOG = com.agri.mis.db.tables.CmsBlog.CMS_BLOG;
        com.agri.mis.db.tables.CmsCategory TB_CMS_CATEGORY =  com.agri.mis.db.tables.CmsCategory.CMS_CATEGORY;
        com.agri.mis.db.tables.CmsUserActive TB_CMS_USER_ACTIVE =  com.agri.mis.db.tables.CmsUserActive.CMS_USER_ACTIVE;

        Condition whereA = DSL.trueCondition();

        if(StringUtils.hasLength(cmsBlog.getTitle())){
            whereA = whereA.and(TB_CMS_BLOG.TITLE.like("%" + cmsBlog.getTitle() +"%").or(TB_CMS_BLOG.TAGS.like("%" + cmsBlog.getTags() +"%")));
        }

        if(null != cmsBlog.getCategoryId()){
            whereA = whereA.and(TB_CMS_BLOG.CATEGORY_ID.eq(cmsBlog.getCategoryId()));
        }

        if(null != cmsBlog.getCorpId()){
            whereA = whereA.and(TB_CMS_BLOG.CORP_ID.eq(cmsBlog.getCorpId()));
        }


        if(null != cmsBlog.getStatus()){
            whereA = whereA.and(TB_CMS_BLOG.STATUS.eq(cmsBlog.getStatus()));
        }

        var dataSql = dslContext.select(
                TB_CMS_BLOG.ID,
                TB_CMS_BLOG.TITLE,
                TB_CMS_BLOG.AUTHOR,
                TB_CMS_BLOG.TAGS,
                TB_CMS_BLOG.DESCRIPTION,
                TB_CMS_BLOG.PUBLISH_AT,
                TB_CMS_BLOG.IMAGE_URL,
                TB_CMS_BLOG.VIDEO_URL,
                TB_CMS_BLOG.CORP_ID,
                TB_CMS_BLOG.CATEGORY_ID,
                TB_CMS_CATEGORY.CODE,
                TB_CMS_CATEGORY.NAME,
                field(selectCount()
                        .from(TB_CMS_USER_ACTIVE)
                        .where(TB_CMS_USER_ACTIVE.BLOG_ID.eq(TB_CMS_BLOG.ID)).and(TB_CMS_USER_ACTIVE.ACTION.eq("view")).asField("VIEW")),
                field(selectCount()
                        .from(TB_CMS_USER_ACTIVE)
                        .where(TB_CMS_USER_ACTIVE.BLOG_ID.eq(TB_CMS_BLOG.ID)).and(TB_CMS_USER_ACTIVE.ACTION.eq("raiseUp")).asField("RAISE_UP")),
                field(selectCount()
                        .from(TB_CMS_USER_ACTIVE)
                        .where(TB_CMS_USER_ACTIVE.BLOG_ID.eq(TB_CMS_BLOG.ID)).and(TB_CMS_USER_ACTIVE.ACTION.eq("raiseDown")).asField("RAISE_DOWN"))
                ).from(TB_CMS_BLOG).leftJoin(TB_CMS_CATEGORY).on(TB_CMS_BLOG.CATEGORY_ID.eq(TB_CMS_CATEGORY.ID)).where(whereA);

        val countSql = dslContext.select(field("count(*)", SQLDataType.BIGINT))
                .from(TB_CMS_BLOG)
                .where(whereA);


        return Mono
                .zip(
                        Flux.from(dataSql)
                                .map(r -> {
                                  CmsBlogInfo cmsBlogInfo = new CmsBlogInfo();
                                    cmsBlogInfo.setId(r.getValue(TB_CMS_BLOG.ID));
                                    cmsBlogInfo.setTitle(r.getValue(TB_CMS_BLOG.TITLE));
                                    cmsBlogInfo.setAuthor(r.getValue(TB_CMS_BLOG.AUTHOR));
                                    cmsBlogInfo.setTags(r.getValue(TB_CMS_BLOG.TAGS));
                                    cmsBlogInfo.setPublishAt(r.getValue(TB_CMS_BLOG.PUBLISH_AT));
                                    cmsBlogInfo.setDescription(r.getValue(TB_CMS_BLOG.DESCRIPTION));
                                    cmsBlogInfo.setImageUrl(r.getValue(TB_CMS_BLOG.IMAGE_URL));
                                    cmsBlogInfo.setVideoUrl(r.getValue(TB_CMS_BLOG.VIDEO_URL));
                                    cmsBlogInfo.setCorpId(r.getValue(TB_CMS_BLOG.CORP_ID));

                                    cmsBlogInfo.setCategoryId(r.getValue(TB_CMS_BLOG.CATEGORY_ID));
                                    cmsBlogInfo.setCategoryCode(r.getValue(TB_CMS_CATEGORY.CODE));
                                    cmsBlogInfo.setCategoryName(r.getValue(TB_CMS_CATEGORY.NAME));
                                    cmsBlogInfo.setCountView(r.getValue("VIEW", Long.class));
                                    cmsBlogInfo.setCountRaiseDown(r.getValue("RAISE_DOWN", Long.class));
                                    cmsBlogInfo.setCountRaiseUp(r.getValue("RAISE_UP", Long.class));
                                    return cmsBlogInfo;
                                })
                                .collectList(),
                        Mono.from(countSql)
                                .map(Record1::value1)
                )
                .map(it -> new PageImpl<>(it.getT1(), pageRequest, it.getT2()));

    }

}
