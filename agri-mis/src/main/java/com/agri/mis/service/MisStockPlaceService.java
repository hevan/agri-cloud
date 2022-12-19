package com.agri.mis.service;

import com.agri.mis.domain.*;

import com.agri.mis.dto.MisStockPlaceWithProductStoreStockCrop;
import com.agri.mis.repository.MisStockPlaceRepository;
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
public class MisStockPlaceService {

    // 定义接口查询数据
    @Autowired
    private MisStockPlaceRepository misStockPlaceRepository;
    // 多表查询
    @Autowired
    private DSLContext dslContext;

    // 根据id查询数据
    public Mono<MisStockPlace> findById(Long id) {
        return misStockPlaceRepository.findById(id);
    }


    //增加数据
    public Mono<MisStockPlace> save(MisStockPlace misStockPlace) {
        return misStockPlaceRepository.save(misStockPlace);
    }

    // 根据Id修改数据
    public Mono<MisStockPlace> update(Long id, MisStockPlace misStockPlace) {
        return misStockPlaceRepository.findById(id).flatMap(s -> {
            misStockPlace.setId(s.getId());
            return misStockPlaceRepository.save(misStockPlace);
        });
    }

    // 根据id删除数据
    public Mono<Void> delete(MisStockPlace misStockPlace) {
        return misStockPlaceRepository.delete(misStockPlace);
    }


    // 分页查询
    public Mono<Page<MisStockPlaceWithProductStoreStockCrop>> pageQuery(String status, PageRequest pageRequest) {
        com.agri.mis.db.tables.MisStockPlace msp = com.agri.mis.db.tables.MisStockPlace.MIS_STOCK_PLACE;
        com.agri.mis.db.tables.Product pt = com.agri.mis.db.tables.Product.PRODUCT;
        com.agri.mis.db.tables.MisStore ms = com.agri.mis.db.tables.MisStore.MIS_STORE;
        com.agri.mis.db.tables.MisStock mst = com.agri.mis.db.tables.MisStock.MIS_STOCK;
        com.agri.mis.db.tables.Corp ct = com.agri.mis.db.tables.Corp.CORP;

        Condition where = DSL.trueCondition();
        if (StringUtils.hasLength((status))) {
            where = where.and(msp.STATUS.eq(Short.valueOf(status)));
        }
        var dataSql = dslContext.select(
                        msp.ID, msp.PRODUCT_ID, msp.QUANTITY, msp.SKU, msp.STORE_ITEM_CODE, msp.STORE_PALLET_CODE, msp.DIRECTION, msp.STORE_ID, msp.STOCK_ID,
                        msp.OCCUR_AT, msp.CREATED_AT, msp.CREATED_BY, msp.UPDTED_AT, msp.UPDATED_BY, msp.CORP_ID, msp.STATUS,

                        pt.ID, pt.NAME, pt.CODE, pt.CATEGORY_ID, pt.IMAGE_URL, pt.CALC_UNIT, pt.CORP_ID, pt.CREATED_AT, pt.CREATED_BY, pt.UPDATED_AT, pt.UPDATED_BY, pt.DESCRIPTION,
                        ms.ID, ms.NAME, ms.CODE, ms.DESCRIPTION, ms.ADDRESS_ID, ms.CATEGORY, ms.CREATED_AT, ms.CORP_ID,
                        mst.ID, mst.NAME, mst.ORDER_NO, mst.QUANTITY, mst.PRICE, mst.AMOUNT, mst.ORIGIN_ID, mst.ORIGIN_TYPE, mst.STORE_ID, mst.DIRECTION, mst.OCCUR_AT, mst.STATUS, mst.CREATED_AT, mst.CREATED_BY, mst.UPDTED_AT, mst.UPDATED_BY, mst.CORP_ID,
                        ct.ID, ct.NAME, ct.CODE, ct.ADDRESS_ID, ct.DESCRIPTION, ct.CREATED_AT

                ).from(msp).leftJoin(pt).on(msp.PRODUCT_ID.eq(pt.ID)).leftJoin(ms).on(msp.STORE_ID.eq(ms.ID))
                .rightJoin(mst).on(msp.STOCK_ID.eq(mst.ID)).rightJoin(ct).on(msp.CORP_ID.eq(ct.ID)).where(where)
                .limit(pageRequest.getOffset(), pageRequest.getPageSize());

        var countSql = dslContext.select(DSL.field("count(*)", SQLDataType.BIGINT))
                .from(msp).where(where);
        return  Mono.zip(
                Flux.from(dataSql).map(r -> {
                            MisStockPlace misStockPlace = new MisStockPlace(
                                    r.getValue(msp.ID), r.getValue(msp.PRODUCT_ID), r.getValue(msp.QUANTITY), r.getValue(msp.SKU), r.getValue(msp.STORE_ITEM_CODE), r.getValue(msp.STORE_PALLET_CODE), r.getValue(msp.DIRECTION), r.getValue(msp.STORE_ID), r.getValue(msp.STOCK_ID), r.getValue(msp.OCCUR_AT),
                                    r.getValue(msp.CREATED_AT), r.getValue(msp.CREATED_BY), r.getValue(msp.UPDTED_AT), r.getValue(msp.UPDATED_BY), r.getValue(msp.CORP_ID), r.getValue(msp.STATUS));
                            if (null != misStockPlace.getProductId()) {
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
                                        r.getValue(ct.ID), r.getValue(ct.NAME), r.getValue(ct.CODE), r.getValue(ct.DESCRIPTION), r.getValue(ct.ADDRESS_ID), r.getValue(ct.CREATED_AT));
                                return new MisStockPlaceWithProductStoreStockCrop(misStockPlace, product, misStock1,misStore , corp);
                            }else {
                                return new MisStockPlaceWithProductStoreStockCrop(misStockPlace,null,null,null,null);
                            }
                        }).collectList(),
                Mono.from(countSql)
                        .map(Record1::value1)

        ).map(it -> new PageImpl<>(it.getT1(), pageRequest, it.getT2()));
    }
}
