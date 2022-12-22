package com.agri.mis.service;

import com.agri.mis.domain.Address;
import com.agri.mis.domain.Corp;
import com.agri.mis.domain.MisStock;
import com.agri.mis.domain.MisStore;
import com.agri.mis.dto.MisStockWithStoreCorp;
import com.agri.mis.repository.MisStockRepository;
import org.jooq.*;
import org.jooq.Record;
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
public class MisStockService {
    // 定义接口查询
    @Autowired
    private MisStockRepository misStockRepository;
    // 多表查询接口
    @Autowired
    private DSLContext dslContext;

    // 查询数据
    public Mono<MisStock> findById(Long id) {
        return misStockRepository.findById(id);
    }

    // 添加数据
    public Mono<MisStock> add(MisStock misStock) {
        return misStockRepository.save(misStock);
    }

    // 修该数据
    public Mono<MisStock> update(Long id, MisStock misStock) {
        return misStockRepository.findById(id).flatMap(s -> {
            misStock.setId(s.getId());
            return misStockRepository.save(misStock);
        });
    }

    // 根据id删除数据
    public Mono<Void> delete(MisStock misStock) {
        return misStockRepository.delete(misStock);
    }


    // 分页查询
    public Mono<Page<MisStockWithStoreCorp>> pageQuery(String name, PageRequest pageRequest) {
        com.agri.mis.db.tables.MisStock mst = com.agri.mis.db.tables.MisStock.MIS_STOCK;
        com.agri.mis.db.tables.MisStore ms = com.agri.mis.db.tables.MisStore.MIS_STORE;
        com.agri.mis.db.tables.Corp ct = com.agri.mis.db.tables.Corp.CORP;

        Condition where = DSL.trueCondition();
        if(StringUtils.hasLength(name)){
            where = where.and(mst.NAME.like("%" + name +"%"));
        }
        var dataSql= dslContext.select(
                mst.ID,
                mst.NAME,
                mst.ORDER_NO,
                mst.QUANTITY,
                mst.PRICE,
                mst.AMOUNT,
                mst.ORIGIN_ID,
                mst.ORIGIN_TYPE,
                mst.STORE_ID,
                mst.DIRECTION,
                mst.OCCUR_AT,
                mst.STATUS,
                mst.CREATED_AT,
                mst.CREATED_BY,
                mst.UPDTED_AT,
                mst.UPDATED_BY,
                mst.CORP_ID,
                ms.ID,
                ms.NAME,
                ms.CODE,
                ms.DESCRIPTION,
                ms.ADDRESS_ID,
                ms.CATEGORY,
                ms.CREATED_AT,
                ms.CORP_ID,
                ct.ID,
                ct.NAME,
                ct.CODE,
                ct.ADDRESS_ID,
                ct.DESCRIPTION,
                ct.CREATED_AT
        ).from(mst).leftJoin(ms).on(mst.STORE_ID.eq(ms.ID)).rightJoin(ct).on(mst.CORP_ID.eq(ct.ID)).where(where).limit(pageRequest.getOffset(),pageRequest.getPageSize());

        var countSql=dslContext.select(DSL.field("count(*)", SQLDataType.BIGINT))
                .from(mst).where(where);
        return Mono.zip(
                Flux.from(dataSql).map(r ->{
                    MisStock misStock = new MisStock(
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
                    //Misstore convert from
                     if (null != misStock.getStoreId()){
                         MisStore misStore = new MisStore(
                                 r.getValue(ms.ID),
                                 r.getValue(ms.NAME),
                                 r.getValue(ms.CODE),
                                 r.getValue(ms.DESCRIPTION),
                                 r.getValue(ms.ADDRESS_ID),
                                 r.getValue(ms.CATEGORY),
                                 r.getValue(ms.CREATED_AT),
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

                         return  new MisStockWithStoreCorp(misStock,misStore,corp);
                     }else{
                         return  new MisStockWithStoreCorp(misStock,null,null);
                     }
                })
                        .collectList(),
                        Mono.from(countSql)
                                .map(Record1::value1)
                )
                .map(it -> new PageImpl<>(it.getT1(), pageRequest, it.getT2()));

    }
}
