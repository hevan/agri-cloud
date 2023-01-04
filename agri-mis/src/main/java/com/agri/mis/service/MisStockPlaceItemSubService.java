package com.agri.mis.service;

import com.agri.mis.db.tables.MisStockPlaceItem;
import com.agri.mis.domain.MisStockPlaceItemSub;
import com.agri.mis.dto.MisStockPlaceItemSubWithStockPlaceItem;
import com.agri.mis.repository.MisStockPlaceItemSubRepository;
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

//业务层
@Service
public class MisStockPlaceItemSubService {
    // 定义借口
    @Autowired
    private MisStockPlaceItemSubRepository misStockPlaceItemSubRepository;
    // 多表查询
    @Autowired
    private DSLContext dslContext;
     // 根据Id查询数据
    public Mono<MisStockPlaceItemSub> findById(Long id) {
        return misStockPlaceItemSubRepository.findById(id);
    }

   // 添加数据
    public Mono<MisStockPlaceItemSub> save(MisStockPlaceItemSub misStockPlaceItemSub) {
        return misStockPlaceItemSubRepository.save(misStockPlaceItemSub);
    }

   // 根据id查询后修该数据
    public Mono<MisStockPlaceItemSub> update(Long id, MisStockPlaceItemSub misStockPlaceItemSub) {
        return misStockPlaceItemSubRepository.findById(id).flatMap(s ->{
            misStockPlaceItemSub.setId(s.getId());
            return misStockPlaceItemSubRepository.save(misStockPlaceItemSub);
        });
    }

   // 根据id删除数据
    public Mono<Void> delete(MisStockPlaceItemSub misStockPlaceItemSub) {
        return misStockPlaceItemSubRepository.delete(misStockPlaceItemSub);
    }

   // 分页查询数据
    public Mono<Page<MisStockPlaceItemSubWithStockPlaceItem>> pageQuery(String orginCode, PageRequest pageRequest) {
     com.agri.mis.db.tables.MisStockPlaceItemSub mspis = com.agri.mis.db.tables.MisStockPlaceItemSub.MIS_STOCK_PLACE_ITEM_SUB;
     com.agri.mis.db.tables.MisStockPlaceItem mspi = MisStockPlaceItem.MIS_STOCK_PLACE_ITEM;
        Condition where = DSL.trueCondition();
        if (StringUtils.hasLength(String.valueOf(orginCode))) {
            where = where.and(mspis.ORGIN_CODE.eq(orginCode));
        }

        var dataSql = dslContext.select(
                mspis.ID,mspis.STOCK_PLACE_ITEM_ID,mspis.QUANTITY,mspis.ORGIN_CODE,mspis.PRODUCT_CODE,
                mspi.ID, mspi.STOCK_PLACE_ID, mspi.PRODUCT_ID, mspi.QUANTITY, mspi.BOX_CODE, mspi.PRODUCT_CODE
        ).from(mspis).leftJoin(mspi).on(mspis.STOCK_PLACE_ITEM_ID.eq(mspi.ID)).where(where).limit(pageRequest.getOffset(), pageRequest.getPageSize());

        var countSql = dslContext.select(DSL.field("count(*)", SQLDataType.BIGINT)).from(mspis).where(where);
        return Mono.zip(
                Flux.from(dataSql).map(r ->{
                    MisStockPlaceItemSub misStockPlaceItemSub = new MisStockPlaceItemSub(
                            r.getValue(mspis.ID), r.getValue(mspis.STOCK_PLACE_ITEM_ID), r.getValue(mspis.QUANTITY), r.getValue(mspis.ORGIN_CODE), r.getValue(mspis.PRODUCT_CODE));

                    if (null != misStockPlaceItemSub.getStockPlaceItemId()){
                        com.agri.mis.domain.MisStockPlaceItem misStockPlaceItem = new com.agri.mis.domain.MisStockPlaceItem(
                                r.getValue(mspi.ID), r.getValue(mspi.STOCK_PLACE_ID), r.getValue(mspi.PRODUCT_ID), r.getValue(mspi.QUANTITY), r.getValue(mspi.BOX_CODE), r.getValue(mspi.PRODUCT_CODE));
                        return new MisStockPlaceItemSubWithStockPlaceItem(misStockPlaceItemSub,misStockPlaceItem);
                    }else {
                        return new MisStockPlaceItemSubWithStockPlaceItem(misStockPlaceItemSub,null);
                    }
                })         .collectList(),
                Mono.from(countSql)
                        .map(Record1::value1)
        ).map(it -> new PageImpl<>(it.getT1(), pageRequest, it.getT2()));
    }
}
