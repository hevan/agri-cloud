package com.agri.mis.service;

import com.agri.mis.domain.Address;
import com.agri.mis.domain.Corp;
import com.agri.mis.domain.MisStore;
import com.agri.mis.dto.MisStoreWithAddressCorp;
import com.agri.mis.repository.MisStoreRepository;
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

// 业务层
@Service
public class MisStoreService {
    // 定义接口查询
    @Autowired
    private MisStoreRepository misStoreRepository;
   // 多表连接
    @Autowired
    private DSLContext dslContext;

    // 根据id查询数据
    public Mono<MisStore> findById(Long id) {
        return misStoreRepository.findById(id);
    }

    // 添加数据
    public Mono<MisStore> save(MisStore misStore) {
        return misStoreRepository.save(misStore);
    }

    // 根据id查询后修改数据
    public Mono<MisStore> update(Long id, MisStore misStore) {
        return misStoreRepository.findById(id).flatMap(s -> {
            misStore.setId(s.getId());
            return misStoreRepository.save(misStore);
        });
    }

    // 根据id删除数据
    public Mono<Void> delete(MisStore misStore) {
        return misStoreRepository.delete(misStore);
    }

    // 分页查询
    public Mono<Page<MisStoreWithAddressCorp>> pageQuery(String name, PageRequest pageRequest) {
        com.agri.mis.db.tables.MisStore ms = com.agri.mis.db.tables.MisStore.MIS_STORE;
        com.agri.mis.db.tables.Address at = com.agri.mis.db.tables.Address.ADDRESS;
        com.agri.mis.db.tables.Corp ct = com.agri.mis.db.tables.Corp.CORP;
        Condition where = DSL.trueCondition();

        if (StringUtils.hasLength(name)) {
            where = where.and(ms.NAME.like("%" + name + "%"));
        }
        var dataSql = dslContext.select(
                        ms.ID, ms.NAME, ms.CODE, ms.DESCRIPTION, ms.ADDRESS_ID, ms.CATEGORY, ms.CREATED_AT, ms.CORP_ID,
                        at.ID, at.PROVINCE, at.CITY, at.REGION, at.LINE_DETAIL, at.LINK_NAME, at.LINK_MOBILE, at.CREATED_AT,
                        ct.ID, ct.NAME, ct.CODE, ct.ADDRESS_ID, ct.DESCRIPTION, ct.CREATED_AT)
                .from(ms).leftJoin(at).on(ms.ADDRESS_ID.eq(at.ID))
                .rightJoin(ct).on(ms.CORP_ID.eq(ct.ID));
        val countSql = dslContext.select(DSL.field("count(*)", SQLDataType.BIGINT))
                .from(ms)
                .where(where);

        return Mono.zip(
                Flux.from(dataSql).map(r -> {
                            MisStore misStore = new MisStore(
                                    r.getValue(ms.ID), r.getValue(ms.NAME), r.getValue(ms.CODE), r.getValue(ms.DESCRIPTION), r.getValue(ms.ADDRESS_ID), r.getValue(ms.CATEGORY), r.getValue(ms.CREATED_AT),
                                    r.getValue(ms.CORP_ID));
                            if (null != misStore.getAddressId()) {
                                Address address = new Address(
                                        r.getValue(at.ID), r.getValue(at.PROVINCE),
                                        r.getValue(at.CITY), r.getValue(at.REGION), r.getValue(at.LINE_DETAIL), r.getValue(at.LINK_NAME),
                                        r.getValue(at.LINK_MOBILE), null, r.getValue(ct.CREATED_AT));

                                Corp corp = new Corp(
                                        r.getValue(ct.ID),
                                        r.getValue(ct.NAME),
                                        r.getValue(ct.CODE),
                                        r.getValue(ct.DESCRIPTION),
                                        r.getValue(ct.ADDRESS_ID),
                                        r.getValue(ct.CREATED_AT));
                                return new MisStoreWithAddressCorp(misStore, address, corp);
                            } else {
                                return new MisStoreWithAddressCorp(misStore, null, null);
                            }
                        })
                        .collectList(),
                Mono.from(countSql)
                        .map(Record1::value1)
        ).map(it -> new PageImpl<>(it.getT1(), pageRequest, it.getT2()));

    }
}
