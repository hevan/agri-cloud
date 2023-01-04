package com.agri.mis.service;
import com.agri.mis.domain.MisStockPlaceItem;
import com.agri.mis.domain.Product;
import com.agri.mis.dto.MisStockPlaceItemWithStockPlaceProduct;
import com.agri.mis.repository.MisStockPlaceItemRepository;

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
public class MisStockPlaceItemService {

    // 定义接口
    @Autowired
    private MisStockPlaceItemRepository misStockPlaceItemRepository;
    // 多表查询
    @Autowired
    private DSLContext dslContext;

    // 根据id查询数据
    public Mono<MisStockPlaceItem> findById(Long id) {
        return misStockPlaceItemRepository.findById(id);
    }

    // 增加数据
    public Mono<MisStockPlaceItem> save(MisStockPlaceItem misStockPlaceItem) {
        return misStockPlaceItemRepository.save(misStockPlaceItem);
    }

    // 根据id修该数据
    public Mono<MisStockPlaceItem> update(Long id, MisStockPlaceItem misStockPlaceItem) {
        return misStockPlaceItemRepository.findById(id).flatMap(s -> {
            misStockPlaceItem.setId(s.getId());
            return misStockPlaceItemRepository.save(misStockPlaceItem);
        });
    }

    // 根据id删除数据
    public Mono<Void> delete(MisStockPlaceItem misStockPlaceItem) {
        return misStockPlaceItemRepository.delete(misStockPlaceItem);
    }

    //分页查询数据
    public Mono<Page<MisStockPlaceItemWithStockPlaceProduct>> pageQuery(String boxCode, PageRequest pageRequest) {
        com.agri.mis.db.tables.MisStockPlaceItem mspi = com.agri.mis.db.tables.MisStockPlaceItem.MIS_STOCK_PLACE_ITEM;
        com.agri.mis.db.tables.MisStockPlace msp =  com.agri.mis.db.tables.MisStockPlace.MIS_STOCK_PLACE;
        com.agri.mis.db.tables.Product pt = com.agri.mis.db.tables.Product.PRODUCT;

        Condition where = DSL.trueCondition();
        if (StringUtils.hasLength(String.valueOf(boxCode))) {
            where = where.and(mspi.BOX_CODE.eq(boxCode));
        }
        var dataSql = dslContext.select(
                        mspi.ID, mspi.STOCK_PLACE_ID, mspi.PRODUCT_ID, mspi.QUANTITY, mspi.BOX_CODE, mspi.PRODUCT_CODE,
                        msp.ID, msp.PRODUCT_ID, msp.QUANTITY, msp.SKU, msp.STORE_ITEM_CODE, msp.STORE_PALLET_CODE, msp.DIRECTION, msp.STORE_ID, msp.STOCK_ID,
                        msp.OCCUR_AT, msp.CREATED_AT, msp.CREATED_BY, msp.UPDTED_AT, msp.UPDATED_BY, msp.CORP_ID, msp.STATUS,
                        pt.ID, pt.NAME, pt.CODE, pt.CATEGORY_ID, pt.IMAGE_URL, pt.CALC_UNIT, pt.CORP_ID, pt.CREATED_AT, pt.CREATED_BY, pt.UPDATED_AT, pt.UPDATED_BY, pt.DESCRIPTION

                ).from(mspi).leftJoin(msp).on(mspi.STOCK_PLACE_ID.eq(msp.ID))
                .rightJoin(pt).on(mspi.PRODUCT_ID.eq(pt.ID)).where(where).limit(pageRequest.getOffset(), pageRequest.getPageSize());

        var countSql = dslContext.select(DSL.field("count(*)", SQLDataType.BIGINT)).from(mspi).where(where);
        return Mono.zip(
                Flux.from(dataSql).map(r -> {
                    MisStockPlaceItem misStockPlaceItem = new MisStockPlaceItem(
                            r.getValue(mspi.ID), r.getValue(mspi.STOCK_PLACE_ID), r.getValue(mspi.PRODUCT_ID), r.getValue(mspi.QUANTITY), r.getValue(mspi.BOX_CODE), r.getValue(mspi.PRODUCT_CODE));
                    if (null != misStockPlaceItem.getStockPlaceId()) {
                        com.agri.mis.domain.MisStockPlace misStockPlace = new com.agri.mis.domain.MisStockPlace(
                                r.getValue(msp.ID), r.getValue(msp.PRODUCT_ID), r.getValue(msp.QUANTITY), r.getValue(msp.SKU), r.getValue(msp.STORE_ITEM_CODE), r.getValue(msp.STORE_PALLET_CODE), r.getValue(msp.DIRECTION), r.getValue(msp.STORE_ID), r.getValue(msp.STOCK_ID), r.getValue(msp.OCCUR_AT),
                                r.getValue(msp.CREATED_AT), r.getValue(msp.CREATED_BY), r.getValue(msp.UPDTED_AT), r.getValue(msp.UPDATED_BY), r.getValue(msp.CORP_ID), r.getValue(msp.STATUS));

                        Product product = new Product(
                                r.getValue(pt.ID), r.getValue(pt.NAME), r.getValue(pt.CODE), r.getValue(pt.CATEGORY_ID), r.getValue(pt.IMAGE_URL), r.getValue(pt.CALC_UNIT), r.getValue(pt.CORP_ID), r.getValue(pt.CREATED_AT),
                                r.getValue(pt.CREATED_BY), r.getValue(pt.UPDATED_AT), r.getValue(pt.UPDATED_BY), r.getValue(pt.DESCRIPTION));
                        return new MisStockPlaceItemWithStockPlaceProduct(misStockPlaceItem, misStockPlace, product);
                    } else {
                        return new MisStockPlaceItemWithStockPlaceProduct(misStockPlaceItem, null, null);
                    }
                }).collectList(),
                Mono.from(countSql)
                        .map(Record1::value1)

        ).map(it -> new PageImpl<>(it.getT1(), pageRequest, it.getT2()));
    }
}
