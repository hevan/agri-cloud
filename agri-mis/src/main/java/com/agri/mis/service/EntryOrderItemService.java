package com.agri.mis.service;

import com.agri.mis.domain.EntryOrderItem;
import com.agri.mis.domain.Product;
import com.agri.mis.repository.EntryOrderItemRepository;
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
public class EntryOrderItemService {
    @Autowired
    private EntryOrderItemRepository entryOrderItemRepository;

    @Autowired
    private DSLContext dslContext;

    public Mono<EntryOrderItem> findById(Long id){
        return entryOrderItemRepository.findById(id);
    }

    public Mono<EntryOrderItem> add(EntryOrderItem entryOrderItem){
        return entryOrderItemRepository.save(entryOrderItem);
    }

    public Mono<EntryOrderItem> update(Long id, EntryOrderItem entryOrderItem){
        return entryOrderItemRepository.findById(id).flatMap(
                r ->{
                    entryOrderItem.setId(r.getId());
                    return entryOrderItemRepository.save(entryOrderItem);
                }
        );
    }

    public Mono<Void> delete(EntryOrderItem entryOrderItem){
        return entryOrderItemRepository.delete(entryOrderItem);
    }

    public Flux<EntryOrderItem> findAllByOrderId(Long orderId){
        com.agri.mis.db.tables.EntryOrderItem bcei =  com.agri.mis.db.tables.EntryOrderItem.ENTRY_ORDER_ITEM;

        com.agri.mis.db.tables.Product p = com.agri.mis.db.tables.Product.PRODUCT;

        Condition where = DSL.trueCondition();


        if(null != orderId){
            where = where.and(bcei.ORDER_ID.eq(orderId));
        }

        var dataSql = dslContext.select(
                bcei.ID,
                bcei.ORDER_ID,
                bcei.PRODUCT_ID,
                bcei.PRODUCT_SKU,
                bcei.DESCRIPTION,
                bcei.WAREHOUSE_ID,
                bcei.AMOUNT,
                bcei.PRICE,
                bcei.QUANTITY,
                bcei.CREATED_AT,
                p.ID,
                p.NAME,
                p.IMAGE_URL
        ).from(bcei).leftJoin(p).on(bcei.PRODUCT_ID.eq(p.ID)).where(where);


        return Flux.from(dataSql)
                .map(
                        r->{
                            EntryOrderItem entryOrderItem = new EntryOrderItem();
                            entryOrderItem.setId(r.getValue(bcei.ID));
                            entryOrderItem.setOrderId(r.getValue(bcei.ORDER_ID));
                            entryOrderItem.setProductId(r.getValue(bcei.PRODUCT_ID));
                            entryOrderItem.setProductSku(r.getValue(bcei.PRODUCT_SKU));
                            entryOrderItem.setDescription(r.getValue(bcei.DESCRIPTION));
                            entryOrderItem.setWarehouseId(r.getValue(bcei.WAREHOUSE_ID));
                            entryOrderItem.setAmount(r.getValue(bcei.AMOUNT));
                            entryOrderItem.setPrice(r.getValue(bcei.PRICE));
                            entryOrderItem.setQuantity(r.getValue(bcei.QUANTITY));
                            entryOrderItem.setCreatedAt(r.getValue(bcei.CREATED_AT));

                            if(null!= entryOrderItem.getProductId()){
                                Product product = new Product();
                                product.setId(r.getValue(p.ID));
                                product.setName(r.getValue(p.NAME));
                                product.setImageUrl(r.getValue(p.IMAGE_URL));
                                entryOrderItem.setProduct(product);
                            }


                            return entryOrderItem;
                        });
    }

    public Mono<Page<EntryOrderItem>> pageQuery(EntryOrderItem entryOrderItemParam, PageRequest pageRequest) {
        com.agri.mis.db.tables.EntryOrderItem bcei =  com.agri.mis.db.tables.EntryOrderItem.ENTRY_ORDER_ITEM;

        com.agri.mis.db.tables.Product p = com.agri.mis.db.tables.Product.PRODUCT;

        Condition where = DSL.trueCondition();


        if(null != entryOrderItemParam.getOrderId()){
            where = where.and(bcei.ORDER_ID.eq(entryOrderItemParam.getOrderId()));
        }

        var dataSql = dslContext.select(
                bcei.ID,
                bcei.ORDER_ID,
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
                                            EntryOrderItem entryOrderItem = new EntryOrderItem();
                                            entryOrderItem.setId(r.getValue(bcei.ID));
                                            entryOrderItem.setOrderId(r.getValue(bcei.ORDER_ID));
                                            entryOrderItem.setProductId(r.getValue(bcei.PRODUCT_ID));
                                            entryOrderItem.setProductSku(r.getValue(bcei.PRODUCT_SKU));
                                            entryOrderItem.setDescription(r.getValue(bcei.DESCRIPTION));
                                            entryOrderItem.setAmount(r.getValue(bcei.AMOUNT));
                                            entryOrderItem.setPrice(r.getValue(bcei.PRICE));
                                            entryOrderItem.setQuantity(r.getValue(bcei.QUANTITY));
                                            entryOrderItem.setWarehouseId(r.getValue(bcei.WAREHOUSE_ID));
                                            entryOrderItem.setCreatedAt(r.getValue(bcei.CREATED_AT));

                                            if(null!= entryOrderItem.getProductId()){
                                                Product product = new Product();
                                                product.setId(r.getValue(p.ID));
                                                product.setName(r.getValue(p.NAME));
                                                product.setImageUrl(r.getValue(p.IMAGE_URL));
                                                entryOrderItem.setProduct(product);
                                            }


                                            return entryOrderItem;
                                        }).collectList(),Mono.from(countSql).map(Record1::value1))
                .map(it -> new PageImpl<>(it.getT1(),pageRequest,it.getT2()));
    }
}
