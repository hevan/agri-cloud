package com.agri.mis.service;

import com.agri.mis.domain.*;
import com.agri.mis.dto.MisStockItemWithProductStoreStockCorp;
import com.agri.mis.repository.MisStockItemRepository;
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

// 业务类
@Service
public class MisStockItemService {
    // 定义接口查询数据
    @Autowired
    private MisStockItemRepository misStockItemRepository;
    // 多表查询
    @Autowired
    private DSLContext dslContext;

    //根据id查询数据
    public Mono<MisStockItem> findById(Long id) {
        return misStockItemRepository.findById(id);
    }

    // 添加数据
    public Mono<MisStockItem> add(MisStockItem misStockItem) {
        return misStockItemRepository.save(misStockItem);
    }

    // 根据id修该数据
    public Mono<MisStockItem> update(Long id, MisStockItem misStockItem) {
        return misStockItemRepository.findById(id).flatMap(s -> {
            misStockItem.setId(s.getId());
            return misStockItemRepository.save(misStockItem);
        });
    }

    // 根据id删除数据.
    public Mono<Void> delete(MisStockItem misStockItem) {
        return misStockItemRepository.delete(misStockItem);
    }

    // 分页查询
    public Mono<Page<MisStockItemWithProductStoreStockCorp>> pageQuery(BigDecimal price, PageRequest pageRequest) {
        com.agri.mis.db.tables.MisStockItem msi = com.agri.mis.db.tables.MisStockItem.MIS_STOCK_ITEM;
        com.agri.mis.db.tables.Product pt = com.agri.mis.db.tables.Product.PRODUCT;
        com.agri.mis.db.tables.MisStore ms = com.agri.mis.db.tables.MisStore.MIS_STORE;
        com.agri.mis.db.tables.MisStock mst = com.agri.mis.db.tables.MisStock.MIS_STOCK;
        com.agri.mis.db.tables.Corp ct = com.agri.mis.db.tables.Corp.CORP;

        Condition where = DSL.trueCondition();
        if (StringUtils.hasLength(String.valueOf(price))) {
            where = where.and(msi.PRICE.eq(price));
        }
        var dataSql = dslContext.select(
                        msi.ID, msi.PRODUCT_ID, msi.QUANTITY, msi.PRICE, msi.DIRECTION, msi.STORE_ID, msi.STOCK_ID, msi.OCCUR_AT, msi.CREATED_AT, msi.CREATED_BY, msi.UPDTED_AT, msi.CREATED_BY, msi.CORP_ID,
                        pt.ID, pt.NAME, pt.CODE, pt.CATEGORY_ID, pt.IMAGE_URL, pt.CALC_UNIT, pt.CORP_ID, pt.CREATED_AT, pt.CREATED_BY, pt.UPDATED_AT, pt.UPDATED_BY, pt.DESCRIPTION,
                        ms.ID, ms.NAME, ms.CODE, ms.DESCRIPTION, ms.ADDRESS_ID, ms.CATEGORY, ms.CREATED_AT, ms.CORP_ID,
                        mst.ID, mst.NAME, mst.ORDER_NO, mst.QUANTITY, mst.PRICE, mst.AMOUNT, mst.ORIGIN_ID, mst.ORIGIN_TYPE, mst.STORE_ID, mst.DIRECTION, mst.OCCUR_AT, mst.STATUS, mst.CREATED_AT, mst.CREATED_BY, mst.UPDTED_AT, mst.UPDATED_BY, mst.CORP_ID,
                        ct.ID, ct.NAME, ct.CODE, ct.ADDRESS_ID, ct.DESCRIPTION, ct.CREATED_AT,ct.ADDRESS
                ).from(msi).leftJoin(pt).on(msi.PRODUCT_ID.eq(pt.ID)).leftJoin(ms).on(msi.STORE_ID.eq(ms.ID))
                .rightJoin(mst).on(msi.STOCK_ID.eq(mst.ID)).rightJoin(ct).on(msi.CORP_ID.eq(ct.ID)).where(where)
                .limit(pageRequest.getOffset(), pageRequest.getPageSize());
        var countSql = dslContext.select(DSL.field("count(*)", SQLDataType.BIGINT))
                .from(msi).where(where);
        return Mono.zip(
                Flux.from(dataSql).map(r -> {
                    MisStockItem misStockItem = new MisStockItem(
                            r.getValue(msi.ID), r.getValue(msi.PRODUCT_ID), r.getValue(msi.QUANTITY), r.getValue(msi.PRICE), r.getValue(msi.DIRECTION), r.getValue(msi.STORE_ID), r.getValue(msi.STOCK_ID), r.getValue(msi.CREATED_AT),r.getValue(msi.OCCUR_AT),  r.getValue(msi.CREATED_BY),
                            r.getValue(msi.UPDTED_AT), r.getValue(msi.UPDATED_BY), r.getValue(msi.CORP_ID));
                    if (null != misStockItem.getProductId()) {
                        Product product = new Product(
                                r.getValue(pt.ID), r.getValue(pt.NAME), r.getValue(pt.CODE), r.getValue(pt.CATEGORY_ID), r.getValue(pt.IMAGE_URL), r.getValue(pt.CALC_UNIT), r.getValue(pt.CORP_ID), r.getValue(pt.CREATED_AT),
                                r.getValue(pt.CREATED_BY), r.getValue(pt.UPDATED_AT), r.getValue(pt.UPDATED_BY), r.getValue(pt.DESCRIPTION));
                        MisStore misStore = new MisStore(
                                r.getValue(ms.ID), r.getValue(ms.NAME), r.getValue(ms.CODE), r.getValue(ms.DESCRIPTION), r.getValue(ms.ADDRESS_ID),
                                r.getValue(ms.CATEGORY), r.getValue(ms.CREATED_AT), r.getValue(ms.CORP_ID));

                        MisStock misStock1 = new MisStock(
                                r.getValue(mst.ID),
                                r.getValue(mst.NAME),
                                r.getValue(mst.ORDER_NO),
                                r.getValue(mst.QUANTITY),
                                r.getValue(mst.PRICE),
                                r.getValue(mst.AMOUNT),
                                r.getValue(mst.ORIGIN_ID),
                                r.getValue(mst.ORIGIN_TYPE),
                                r.getValue(mst.STORE_ID),
                                r.getValue(mst.DIRECTION),
                                r.getValue(mst.OCCUR_AT),
                                r.getValue(mst.STATUS),
                                r.getValue(mst.CREATED_AT),
                                r.getValue(mst.CREATED_BY),
                                r.getValue(mst.UPDTED_AT),
                                r.getValue(mst.UPDATED_BY),
                                r.getValue(mst.CORP_ID));

                        Corp corp = new Corp(
                                r.getValue(ct.ID), r.getValue(ct.NAME), r.getValue(ct.CODE), r.getValue(ct.DESCRIPTION), r.getValue(ct.ADDRESS_ID), r.getValue(ct.CREATED_AT), (Address) r.getValue((Name) ct.ADDRESS));

                        return new MisStockItemWithProductStoreStockCorp(misStockItem, product, misStock1,misStore , corp);
                    } else {
                        return new MisStockItemWithProductStoreStockCorp(misStockItem, null, null, null, null);
                    }
    }) .collectList(),
                Mono.from(countSql)
                        .map(Record1::value1)

            ).map(it -> new PageImpl<>(it.getT1(), pageRequest, it.getT2()));
}
}
