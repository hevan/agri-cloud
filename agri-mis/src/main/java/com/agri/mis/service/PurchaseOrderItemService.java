package com.agri.mis.service;

import com.agri.mis.domain.Product;
import com.agri.mis.domain.PurchaseOrderItem;
import com.agri.mis.dto.TotalData;
import com.agri.mis.repository.PurchaseOrderItemRepository;
import com.agri.mis.repository.PurchaseOrderRepository;
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

import java.math.BigDecimal;

import static org.jooq.impl.DSL.sum;

@Service
public class PurchaseOrderItemService {
    @Autowired
    private PurchaseOrderItemRepository purchaseOrderItemRepository;
    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;


    @Autowired
    private DSLContext dslContext;

    public Mono<PurchaseOrderItem> findById(Long id){
        return purchaseOrderItemRepository.findById(id);
    }

    public Mono<PurchaseOrderItem> add(PurchaseOrderItem purchaseOrderItem){
        return purchaseOrderItemRepository.save(purchaseOrderItem).flatMap(st->{
            return totalData(st.getOrderId()).flatMap(ct -> {
                return purchaseOrderRepository.findById(purchaseOrderItem.getOrderId()).flatMap(so -> {
                    so.setQuantity(ct.getQuantity());
                    so.setAmount(ct.getAmount());
                    return purchaseOrderRepository.save(so);
                });
            }).then(Mono.just(st));
        });
    }

    public Mono<PurchaseOrderItem> update(Long id, PurchaseOrderItem purchaseOrderItem){
        return purchaseOrderItemRepository.findById(id).flatMap(
                r ->{
                    purchaseOrderItem.setId(r.getId());
                    return purchaseOrderItemRepository.save(purchaseOrderItem);
                }
        ).flatMap(st-> {
            return totalData(st.getOrderId()).flatMap(ct -> {
                return purchaseOrderRepository.findById(purchaseOrderItem.getOrderId()).flatMap(so -> {
                    so.setQuantity(ct.getQuantity());
                    so.setAmount(ct.getAmount());
                    return purchaseOrderRepository.save(so);
                });
            }).then(Mono.just(st));
        });
    }

    public Mono<Void> delete(PurchaseOrderItem purchaseOrderItem){
        return purchaseOrderItemRepository.delete(purchaseOrderItem).then(totalData(purchaseOrderItem.getOrderId()).flatMap(ct->{
                    return  purchaseOrderRepository.findById(purchaseOrderItem.getOrderId()).flatMap(so->{
                        so.setQuantity(ct.getQuantity());
                        so.setAmount(ct.getAmount());
                        return purchaseOrderRepository.save(so);
                    });
                }).then(Mono.empty())
        );
    }

    private Mono<TotalData> totalData(Long orderId){
        com.agri.mis.db.tables.PurchaseOrder  P_ORDER =  com.agri.mis.db.tables.PurchaseOrder.PURCHASE_ORDER;
        com.agri.mis.db.tables.PurchaseOrderItem P_ORDER_ITEM =  com.agri.mis.db.tables.PurchaseOrderItem.PURCHASE_ORDER_ITEM;

         var countSql = dslContext.select(sum(P_ORDER_ITEM.QUANTITY), sum(P_ORDER_ITEM.AMOUNT))
                .from(P_ORDER_ITEM)
                .where(P_ORDER_ITEM.ORDER_ID.eq(orderId));

        return Mono.from(countSql).map(r->{
            TotalData totalData = new TotalData();
            if(null == r.value1()){
                totalData.setQuantity(0.0);
                totalData.setAmount(new BigDecimal(0));
            }else{
                totalData.setQuantity(r.value1().doubleValue());
                totalData.setAmount(r.value2());
            }

            return totalData;
        });
    }

    public Flux<PurchaseOrderItem> findAllByOrderId(Long orderId){
        com.agri.mis.db.tables.PurchaseOrderItem bcei =  com.agri.mis.db.tables.PurchaseOrderItem.PURCHASE_ORDER_ITEM;

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
                            PurchaseOrderItem purchaseOrderItem = new PurchaseOrderItem();
                            purchaseOrderItem.setId(r.getValue(bcei.ID));
                            purchaseOrderItem.setOrderId(r.getValue(bcei.ORDER_ID));
                            purchaseOrderItem.setProductId(r.getValue(bcei.PRODUCT_ID));
                            purchaseOrderItem.setProductSku(r.getValue(bcei.PRODUCT_SKU));
                            purchaseOrderItem.setDescription(r.getValue(bcei.DESCRIPTION));
                            purchaseOrderItem.setAmount(r.getValue(bcei.AMOUNT));
                            purchaseOrderItem.setPrice(r.getValue(bcei.PRICE));
                            purchaseOrderItem.setQuantity(r.getValue(bcei.QUANTITY));
                            purchaseOrderItem.setCreatedAt(r.getValue(bcei.CREATED_AT));

                            if(null!= purchaseOrderItem.getProductId()){
                                Product product = new Product();
                                product.setId(r.getValue(p.ID));
                                product.setName(r.getValue(p.NAME));
                                product.setImageUrl(r.getValue(p.IMAGE_URL));
                                purchaseOrderItem.setProduct(product);
                            }
                            return purchaseOrderItem;
                        });
    }

    public Mono<Page<PurchaseOrderItem>> pageQuery(Long orderId, String name, PageRequest pageRequest) {
        com.agri.mis.db.tables.PurchaseOrderItem bcei =  com.agri.mis.db.tables.PurchaseOrderItem.PURCHASE_ORDER_ITEM;

        com.agri.mis.db.tables.Product p = com.agri.mis.db.tables.Product.PRODUCT;

        Condition where = DSL.trueCondition();

        if(StringUtils.hasLength(name)){
            where = where.and(p.NAME.like("%" + name +"%"));
        }

        if(null != orderId){
            where = where.and(bcei.ORDER_ID.eq(orderId));
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
                                            PurchaseOrderItem purchaseOrderItem = new PurchaseOrderItem();
                                            purchaseOrderItem.setId(r.getValue(bcei.ID));
                                            purchaseOrderItem.setOrderId(r.getValue(bcei.ORDER_ID));
                                            purchaseOrderItem.setProductId(r.getValue(bcei.PRODUCT_ID));
                                            purchaseOrderItem.setProductSku(r.getValue(bcei.PRODUCT_SKU));
                                            purchaseOrderItem.setDescription(r.getValue(bcei.DESCRIPTION));
                                            purchaseOrderItem.setAmount(r.getValue(bcei.AMOUNT));
                                            purchaseOrderItem.setPrice(r.getValue(bcei.PRICE));
                                            purchaseOrderItem.setQuantity(r.getValue(bcei.QUANTITY));
                                            purchaseOrderItem.setCreatedAt(r.getValue(bcei.CREATED_AT));

                                            if(null!= purchaseOrderItem.getProductId()){
                                                Product product = new Product();
                                                product.setId(r.getValue(p.ID));
                                                product.setName(r.getValue(p.NAME));
                                                product.setImageUrl(r.getValue(p.IMAGE_URL));
                                                purchaseOrderItem.setProduct(product);
                                            }


                                            return purchaseOrderItem;
                                        }).collectList(),Mono.from(countSql).map(Record1::value1))
                .map(it -> new PageImpl<>(it.getT1(),pageRequest,it.getT2()));
    }
}
