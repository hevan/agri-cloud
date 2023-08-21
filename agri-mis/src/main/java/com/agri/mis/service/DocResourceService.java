package com.agri.mis.service;

import com.agri.mis.domain.BatchProduct;
import com.agri.mis.domain.DocResource;
import com.agri.mis.domain.FinanceExpense;
import com.agri.mis.domain.User;
import com.agri.mis.repository.DocResourceRepository;
import com.agri.mis.repository.DocResourceRepository;
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
public class DocResourceService {

    @Autowired
    private DocResourceRepository docResourceRepository;

    @Autowired
    private DSLContext dslContext;

    public Mono<DocResource> findById(Long id) {
      return docResourceRepository.findById(id);
    }

    public Mono<Page<DocResource>> pageQuery(DocResource docResourceParam, PageRequest pageRequest) {

        com.agri.mis.db.tables.DocResource bce =  com.agri.mis.db.tables.DocResource.DOC_RESOURCE;

        com.agri.mis.db.tables.Users users =  com.agri.mis.db.tables.Users.USERS;

        Condition where = DSL.trueCondition();

        if(StringUtils.hasLength(docResourceParam.getEntityName())){
            where = where.and(bce.ENTITY_NAME.eq(docResourceParam.getEntityName() ));
        }
        if(null != docResourceParam.getEntityId()){
            where = where.and(bce.ENTITY_ID.eq(docResourceParam.getEntityId()));
        }
        if(StringUtils.hasLength(docResourceParam.getGroupName())){
            where = where.and(bce.GROUP_NAME.eq(docResourceParam.getGroupName()));
        }
        if(null != docResourceParam.getCreatedUserId()){
            where = where.and(bce.CREATED_USER_ID.eq(docResourceParam.getCreatedUserId()));
        }
        if(null != docResourceParam.getCorpId()){
            where = where.and(bce.CORP_ID.eq(docResourceParam.getCorpId()));
        }


        var dataSql = dslContext.select(
                bce.ID,
                bce.NAME,
                bce.DOC_TYPE,
                bce.DOC_EXT,
                bce.DOC_URL,
                bce.SHOW_IMAGE,
                bce.GROUP_NAME,
                bce.ENTITY_ID,
                bce.ENTITY_NAME,
                bce.CORP_ID,
                bce.CREATED_AT,
                bce.CREATED_USER_ID,

                users.ID,
                users.NICK_NAME,
                users.HEADER_URL
        ).from(bce).leftJoin(users).on(bce.CREATED_USER_ID.eq(users.ID)).where(where).limit(pageRequest.getOffset(),pageRequest.getPageSize());
        val countSql = dslContext.select(DSL.field("count(*)", SQLDataType.BIGINT))
                .from(bce)
                .where(where);
        return Mono
                .zip(
                        Flux.from(dataSql)
                                .map(
                                        r->{
                                            DocResource docResource = new DocResource();
                                            docResource.setId(r.getValue(bce.ID));

                                            docResource.setName(r.getValue(bce.NAME));
                                            docResource.setDocType(r.getValue(bce.DOC_TYPE));
                                            docResource.setGroupName(r.getValue(bce.GROUP_NAME));
                                            docResource.setDocExt(r.getValue(bce.DOC_EXT));
                                            docResource.setDocUrl(r.getValue(bce.DOC_URL));
                                            docResource.setCorpId(r.getValue(bce.CORP_ID));
                                            docResource.setShowImage(r.getValue(bce.SHOW_IMAGE));
                                            docResource.setEntityId(r.getValue(bce.ENTITY_ID));
                                            docResource.setEntityName(r.getValue(bce.ENTITY_NAME));
                                            docResource.setCreatedAt(r.getValue(bce.CREATED_AT));
                                            docResource.setCreatedUserId(r.getValue(bce.CREATED_USER_ID));


                                            if(null!= docResource.getCreatedUserId()){
                                                User user = new User();
                                                user.setId(r.getValue(users.ID));
                                                user.setNickName(r.getValue(users.NICK_NAME));
                                                user.setHeaderUrl(r.getValue(users.HEADER_URL));
                                                docResource.setCreatedUser(user);
                                            }

                                            return docResource;
                                        }).collectList(),Mono.from(countSql).map(Record1::value1))
                .map(it -> new PageImpl<>(it.getT1(),pageRequest,it.getT2()));
    }

    public Mono<DocResource> add(DocResource docResource) {
        return docResourceRepository.save(docResource);
    }

    public Mono<DocResource> update(Long id, DocResource docResource) {
        return docResourceRepository.findById(id)
                .flatMap(s -> {
                    docResource.setId(s.getId());
                    return docResourceRepository.save(docResource);
                });
    }

    public Mono<Void> delete(DocResource docResource) {
        return docResourceRepository.delete(docResource);
    }
}
