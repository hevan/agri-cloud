package com.agri.mis.service;



import com.agri.mis.domain.Address;
import com.agri.mis.domain.Corp;
import com.agri.mis.domain.MisStore;
import com.agri.mis.domain.MisStoreItem;

import com.agri.mis.dto.MisStoreItemWithProductStoreCorp;
import com.agri.mis.dto.MisStoreWithAddressCorp;
import com.agri.mis.repository.MisStoreItemRepository;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Name;
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

import java.math.BigDecimal;

// 业务层
@Service
public class MisStoreItemService {

    // 定义接口
    @Autowired
    private MisStoreItemRepository misStoreItemRepository;
    // 多表连接
    @Autowired
    private DSLContext dslContext;

    // 根据id查询数据
    public Mono<MisStoreItem> findById(Long id) {
        return misStoreItemRepository.findById(id);
    }

    // 添加数据
    public Mono<MisStoreItem> save(MisStoreItem misStoreItem) {
        return misStoreItemRepository.save(misStoreItem);
    }

    // 根据id查询后修改数据
    public Mono<MisStoreItem> update(Long id, MisStoreItem misStoreItem) {
        return misStoreItemRepository.findById(id).flatMap(s -> {
            misStoreItem.setId(s.getId());
            return misStoreItemRepository.save(misStoreItem);
        });
    }

    // 根据id删除数据

    public Mono<Void> delete(MisStoreItem misStoreItem) {
        return misStoreItemRepository.delete(misStoreItem);
    }

    // 分页查询
    public Mono<Page<MisStoreItemWithProductStoreCorp>> pageQuery(BigDecimal price, PageRequest pageRequest) {
        com.agri.mis.db.tables.MisStoreItem msi = com.agri.mis.db.tables.MisStoreItem.MIS_STORE_ITEM;
        com.agri.mis.db.tables.Product pt = com.agri.mis.db.tables.Product.PRODUCT;
        com.agri.mis.db.tables.MisStore ms = com.agri.mis.db.tables.MisStore.MIS_STORE;
        com.agri.mis.db.tables.Corp ct = com.agri.mis.db.tables.Corp.CORP;

        Condition where = DSL.trueCondition();
        if (StringUtils.hasLength(String.valueOf(price))) {
            where = where.and(msi.PRICE.eq(price));
        }
        var dataSql = dslContext.select(
                        msi.ID, msi.PRODUCT_ID, msi.QUANTITY, msi.STORE_ID, msi.CORP_ID, msi.PRICE, msi.AMOUNT, msi.CREATED_AT,
                        msi.CREATED_BY, msi.UPDATED_AT, msi.UPDATED_BY,
                        pt.ID, pt.NAME, pt.CODE, pt.CATEGORY_ID, pt.IMAGE_URL, pt.CALC_UNIT, pt.CORP_ID, pt.CREATED_AT, pt.CREATED_BY, pt.UPDATED_AT, pt.UPDATED_BY, pt.DESCRIPTION,
                        ms.ID, ms.NAME, ms.CODE, ms.DESCRIPTION, ms.ADDRESS_ID, ms.CATEGORY, ms.CREATED_AT, ms.CORP_ID,
                        ct.ID, ct.NAME, ct.CODE, ct.ADDRESS_ID, ct.DESCRIPTION, ct.CREATED_AT)
                .from(msi).leftJoin(pt).on(msi.PRODUCT_ID.eq(pt.ID)).leftJoin(ms).on(msi.STORE_ID.eq(ms.ID))
                .rightJoin(ct).on(msi.CORP_ID.eq(ct.ID));

        var countSql = dslContext.select(DSL.field("count(*)", SQLDataType.BIGINT))
                .from(msi).where(where);


        return Mono.zip(
                Flux.from(dataSql).map(r -> {
                    MisStoreItem misStoreItem = new MisStoreItem(
                            r.getValue(msi.ID), r.getValue(msi.PRODUCT_ID), r.getValue(msi.QUANTITY), r.getValue(msi.STORE_ID), r.getValue(msi.CORP_ID),
                            r.getValue(msi.PRICE), r.getValue(msi.AMOUNT), r.getValue(msi.CREATED_AT), r.getValue(msi.CREATED_BY), r.getValue(msi.UPDATED_AT), r.getValue(msi.UPDATED_BY));

                    if (null != misStoreItem.getProductId()) {
                        com.agri.mis.domain.Product product = new com.agri.mis.domain.Product(
                                r.getValue(pt.ID), r.getValue(pt.NAME), r.getValue(pt.CODE), r.getValue(pt.CATEGORY_ID), r.getValue(pt.IMAGE_URL), r.getValue(pt.CALC_UNIT), r.getValue(pt.CORP_ID), r.getValue(pt.CREATED_AT),
                                r.getValue(pt.CREATED_BY), r.getValue(pt.UPDATED_AT), r.getValue(pt.UPDATED_BY), r.getValue(pt.DESCRIPTION));


                        MisStore misStore = new MisStore(
                                r.getValue(ms.ID), r.getValue(ms.NAME), r.getValue(ms.CODE), r.getValue(ms.DESCRIPTION), r.getValue(ms.ADDRESS_ID), r.getValue(ms.CATEGORY), r.getValue(ms.CREATED_AT),
                                r.getValue(ms.CORP_ID));
                        Corp corp = new Corp(
                                r.getValue(ct.ID),
                                r.getValue(ct.NAME),
                                r.getValue(ct.CODE),
                                r.getValue(ct.DESCRIPTION),
                                r.getValue(ct.ADDRESS_ID),
                                r.getValue(ct.CREATED_AT),
                                null
                        );
                        return new MisStoreItemWithProductStoreCorp(misStoreItem, product, misStore, corp);
                    } else {
                        return new MisStoreItemWithProductStoreCorp(misStoreItem, null, null, null);
                    }
                }).collectList(),
                Mono.from(countSql)
                        .map(Record1::value1)
        ).map(it -> new PageImpl<>(it.getT1(), pageRequest, it.getT2()));
    }
}

