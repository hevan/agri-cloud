package com.agri.mis.service;

import com.agri.mis.domain.*;
import com.agri.mis.repository.BatchCycleExpenseItemRepository;
import com.agri.mis.repository.BatchCycleExpenseRepository;
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
public class BatchCycleExpenseItemService {
    @Autowired
    private BatchCycleExpenseItemRepository batchCycleExpenseItemRepository;

    @Autowired
    private DSLContext dslContext;

    public Mono<BatchCycleExpenseItem> findById(Long id){
        return batchCycleExpenseItemRepository.findById(id);
    }

    public Mono<BatchCycleExpenseItem> add(BatchCycleExpenseItem batchCycleExpenseItem){
        return batchCycleExpenseItemRepository.save(batchCycleExpenseItem);
    }

    public Mono<BatchCycleExpenseItem> update(Long id,BatchCycleExpenseItem batchCycleExpenseItem){
        return batchCycleExpenseItemRepository.findById(id).flatMap(
                r ->{
                    batchCycleExpenseItem.setId(r.getId());
                    return batchCycleExpenseItemRepository.save(batchCycleExpenseItem);
                }
        );
    }

    public Mono<Void> delete(BatchCycleExpenseItem batchCycleExpenseItem){
        return batchCycleExpenseItemRepository.delete(batchCycleExpenseItem);
    }

    public Mono<Page<BatchCycleExpenseItem>> pageQuery(Long expenseId, String name, PageRequest pageRequest) {
        com.agri.mis.db.tables.BatchCycleExpenseItem bcei =  com.agri.mis.db.tables.BatchCycleExpenseItem.BATCH_CYCLE_EXPENSE_ITEM;

        com.agri.mis.db.tables.Product p = com.agri.mis.db.tables.Product.PRODUCT;

        Condition where = DSL.trueCondition();

        if(StringUtils.hasLength(name)){
            where = where.and(p.NAME.like("%" + name +"%"));
        }

        if(StringUtils.hasLength(name)){
            where = where.and(bcei.EXPENSE_ID.eq(expenseId));
        }

        var dataSql = dslContext.select(
                bcei.ID,
                bcei.EXPENSE_ID,
                bcei.PRODUCT_ID,
                bcei.PRODUCT_SKU,
                bcei.DESCRIPTION,
                bcei.AMOUNT,
                bcei.PRICE,
                bcei.QUANTITY,
                bcei.CREATED_AT,
                p.ID,
                p.NAME,
                p.IMAGE_URL
        ).from(bcei).leftJoin(p).on(bcei.PRODUCT_ID.eq(p.ID)).where(where).limit(pageRequest.getOffset(),pageRequest.getPageSize());
        val countSql = dslContext.select(DSL.field("count(*)", SQLDataType.BIGINT))
                .from(bcei)
                .where(where);
        return Mono
                .zip(
                        Flux.from(dataSql)
                                .map(
                                        r->{
                                            BatchCycleExpenseItem batchCycleExpenseItem = new BatchCycleExpenseItem(
                                                    r.getValue(bcei.ID),
                                                    r.getValue(bcei.EXPENSE_ID),
                                                    r.getValue(bcei.PRODUCT_ID),
                                                    r.getValue(bcei.PRODUCT_SKU),
                                                    r.getValue(bcei.DESCRIPTION),
                                                    r.getValue(bcei.AMOUNT),
                                                    r.getValue(bcei.PRICE),
                                                    r.getValue(bcei.QUANTITY),
                                                    r.getValue(bcei.CREATED_AT),
                                                   null);
                                            if(null!=batchCycleExpenseItem.getProductId()){
                                                Product product = new Product();
                                                product.setId(r.getValue(p.ID));
                                                product.setName(r.getValue(p.NAME));
                                                product.setImageUrl(r.getValue(p.IMAGE_URL));
                                                batchCycleExpenseItem.setProduct(product);
                                            }


                                            return batchCycleExpenseItem;
                                        }).collectList(),Mono.from(countSql).map(Record1::value1))
                .map(it -> new PageImpl<>(it.getT1(),pageRequest,it.getT2()));
    }
}
