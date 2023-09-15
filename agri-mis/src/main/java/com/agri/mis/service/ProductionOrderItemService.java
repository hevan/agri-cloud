package com.agri.mis.service;

import com.agri.mis.domain.Product;
import com.agri.mis.domain.ProductionOrderItem;
import com.agri.mis.dto.TotalData;
import com.agri.mis.repository.ProductionOrderItemRepository;
import com.agri.mis.repository.ProductionOrderRepository;
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
public class ProductionOrderItemService {
    @Autowired
    private ProductionOrderItemRepository productionOrderItemRepository;
    @Autowired
    private ProductionOrderRepository productionOrderRepository;


    @Autowired
    private DSLContext dslContext;

    public Mono<ProductionOrderItem> findById(Long id){
        return productionOrderItemRepository.findById(id);
    }

    public Mono<ProductionOrderItem> add(ProductionOrderItem productionOrderItem){
        return productionOrderItemRepository.save(productionOrderItem).flatMap(st->{
            return totalData(st.getOrderId()).flatMap(ct -> {
                return productionOrderRepository.findById(productionOrderItem.getOrderId()).flatMap(so -> {
                    so.setQuantity(ct.getQuantity());
                    so.setAmount(ct.getAmount());
                    return productionOrderRepository.save(so);
                });
            }).then(Mono.just(st));
        });
    }

    public Mono<ProductionOrderItem> update(Long id, ProductionOrderItem productionOrderItem){
        return productionOrderItemRepository.findById(id).flatMap(
                r ->{
                    productionOrderItem.setId(r.getId());
                    return productionOrderItemRepository.save(productionOrderItem);
                }
        ).flatMap(st-> {
            return totalData(st.getOrderId()).flatMap(ct -> {
                return productionOrderRepository.findById(productionOrderItem.getOrderId()).flatMap(so -> {
                    so.setQuantity(ct.getQuantity());
                    so.setAmount(ct.getAmount());
                    return productionOrderRepository.save(so);
                });
            }).then(Mono.just(st));
        });
    }

    public Mono<Void> delete(ProductionOrderItem productionOrderItem){
        return productionOrderItemRepository.delete(productionOrderItem).then(totalData(productionOrderItem.getOrderId()).flatMap(ct->{
                    return  productionOrderRepository.findById(productionOrderItem.getOrderId()).flatMap(so->{
                        so.setQuantity(ct.getQuantity());
                        so.setAmount(ct.getAmount());
                        return productionOrderRepository.save(so);
                    });
                }).then(Mono.empty())
        );
    }

    private Mono<TotalData> totalData(Long orderId){
        com.agri.mis.db.tables.ProductionOrder  P_ORDER =  com.agri.mis.db.tables.ProductionOrder.PRODUCTION_ORDER;
        com.agri.mis.db.tables.ProductionOrderItem P_ORDER_ITEM =  com.agri.mis.db.tables.ProductionOrderItem.PRODUCTION_ORDER_ITEM;

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

    public Flux<ProductionOrderItem> findAllByOrderId(Long orderId){
        com.agri.mis.db.tables.ProductionOrderItem bcei =  com.agri.mis.db.tables.ProductionOrderItem.PRODUCTION_ORDER_ITEM;

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
                            ProductionOrderItem productionOrderItem = new ProductionOrderItem();
                            productionOrderItem.setId(r.getValue(bcei.ID));
                            productionOrderItem.setOrderId(r.getValue(bcei.ORDER_ID));
                            productionOrderItem.setProductId(r.getValue(bcei.PRODUCT_ID));
                            productionOrderItem.setProductSku(r.getValue(bcei.PRODUCT_SKU));
                            productionOrderItem.setDescription(r.getValue(bcei.DESCRIPTION));
                            productionOrderItem.setAmount(r.getValue(bcei.AMOUNT));
                            productionOrderItem.setPrice(r.getValue(bcei.PRICE));
                            productionOrderItem.setQuantity(r.getValue(bcei.QUANTITY));
                            productionOrderItem.setCreatedAt(r.getValue(bcei.CREATED_AT));

                            if(null!= productionOrderItem.getProductId()){
                                Product product = new Product();
                                product.setId(r.getValue(p.ID));
                                product.setName(r.getValue(p.NAME));
                                product.setImageUrl(r.getValue(p.IMAGE_URL));
                                productionOrderItem.setProduct(product);
                            }
                            return productionOrderItem;
                        });
    }

    public Mono<Page<ProductionOrderItem>> pageQuery(Long orderId, String name, PageRequest pageRequest) {
        com.agri.mis.db.tables.ProductionOrderItem bcei =  com.agri.mis.db.tables.ProductionOrderItem.PRODUCTION_ORDER_ITEM;

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
                                            ProductionOrderItem productionOrderItem = new ProductionOrderItem();
                                            productionOrderItem.setId(r.getValue(bcei.ID));
                                            productionOrderItem.setOrderId(r.getValue(bcei.ORDER_ID));
                                            productionOrderItem.setProductId(r.getValue(bcei.PRODUCT_ID));
                                            productionOrderItem.setProductSku(r.getValue(bcei.PRODUCT_SKU));
                                            productionOrderItem.setDescription(r.getValue(bcei.DESCRIPTION));
                                            productionOrderItem.setAmount(r.getValue(bcei.AMOUNT));
                                            productionOrderItem.setPrice(r.getValue(bcei.PRICE));
                                            productionOrderItem.setQuantity(r.getValue(bcei.QUANTITY));
                                            productionOrderItem.setCreatedAt(r.getValue(bcei.CREATED_AT));

                                            if(null!= productionOrderItem.getProductId()){
                                                Product product = new Product();
                                                product.setId(r.getValue(p.ID));
                                                product.setName(r.getValue(p.NAME));
                                                product.setImageUrl(r.getValue(p.IMAGE_URL));
                                                productionOrderItem.setProduct(product);
                                            }


                                            return productionOrderItem;
                                        }).collectList(),Mono.from(countSql).map(Record1::value1))
                .map(it -> new PageImpl<>(it.getT1(),pageRequest,it.getT2()));
    }
}
