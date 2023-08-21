package com.agri.mis.service;

import com.agri.mis.domain.SaleOrderItem;
import com.agri.mis.domain.Product;
import com.agri.mis.dto.TotalData;
import com.agri.mis.repository.SaleOrderItemRepository;
import com.agri.mis.repository.SaleOrderRepository;
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

import static org.jooq.impl.DSL.*;

@Service
public class SaleOrderItemService {
    @Autowired
    private SaleOrderItemRepository saleOrderItemRepository;
    @Autowired
    private SaleOrderRepository saleOrderRepository;

    @Autowired
    private DSLContext dslContext;

    public Mono<SaleOrderItem> findById(Long id){
        return saleOrderItemRepository.findById(id);
    }

    public Mono<SaleOrderItem> add(SaleOrderItem saleOrderItem){
        return saleOrderItemRepository.save(saleOrderItem).flatMap(st->{
            return totalData(st.getOrderId()).flatMap(ct->{
                return  saleOrderRepository.findById(saleOrderItem.getOrderId()).flatMap(so->{
                    so.setQuantity(ct.getQuantity());
                    so.setAmount(ct.getAmount());
                    return saleOrderRepository.save(so);
                });
            }).then(Mono.just(st));
        });
    }

    public Mono<SaleOrderItem> update(Long id, SaleOrderItem saleOrderItem){
        return saleOrderItemRepository.findById(id).flatMap(
                r ->{
                    saleOrderItem.setId(r.getId());
                    return saleOrderItemRepository.save(saleOrderItem);
                }
        ).flatMap(st->{
            return totalData(st.getOrderId()).flatMap(ct->{
                return  saleOrderRepository.findById(saleOrderItem.getOrderId()).flatMap(so->{
                    so.setQuantity(ct.getQuantity());
                    so.setAmount(ct.getAmount());
                    return saleOrderRepository.save(so);
                });
            }).then(Mono.just(st));
        });
    }

    private Mono<TotalData> totalData(Long orderId){
        com.agri.mis.db.tables.SaleOrder saleOrder =  com.agri.mis.db.tables.SaleOrder.SALE_ORDER;
        com.agri.mis.db.tables.SaleOrderItem ST_ITEM =  com.agri.mis.db.tables.SaleOrderItem.SALE_ORDER_ITEM;
        Condition where = DSL.trueCondition();


        if(null != orderId){
            where = where.and(saleOrder.ID.eq(orderId));
        }

        var countSQL = dslContext.select(sum(ST_ITEM.QUANTITY), sum(ST_ITEM.AMOUNT))
                .from(ST_ITEM)
                .where(ST_ITEM.ORDER_ID.eq(orderId));

        return Mono.from(countSQL).map(r->{
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

    public Mono<Void> delete(SaleOrderItem saleOrderItem){
        return saleOrderItemRepository.delete(saleOrderItem).then(
             totalData(saleOrderItem.getOrderId()).flatMap(ct->{
                return  saleOrderRepository.findById(saleOrderItem.getOrderId()).flatMap(so->{
                    so.setQuantity(ct.getQuantity());
                    so.setAmount(ct.getAmount());
                    return saleOrderRepository.save(so);
                });
            }).then(Mono.empty())
        );
    }

    public Flux<SaleOrderItem> findAllByOrderId(Long orderId){
        com.agri.mis.db.tables.SaleOrderItem bcei =  com.agri.mis.db.tables.SaleOrderItem.SALE_ORDER_ITEM;

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
                            SaleOrderItem saleOrderItem = new SaleOrderItem();
                            saleOrderItem.setId(r.getValue(bcei.ID));
                            saleOrderItem.setOrderId(r.getValue(bcei.ORDER_ID));
                            saleOrderItem.setProductId(r.getValue(bcei.PRODUCT_ID));
                            saleOrderItem.setProductSku(r.getValue(bcei.PRODUCT_SKU));
                            saleOrderItem.setDescription(r.getValue(bcei.DESCRIPTION));
                            saleOrderItem.setAmount(r.getValue(bcei.AMOUNT));
                            saleOrderItem.setPrice(r.getValue(bcei.PRICE));
                            saleOrderItem.setQuantity(r.getValue(bcei.QUANTITY));
                            saleOrderItem.setCreatedAt(r.getValue(bcei.CREATED_AT));

                            if(null!= saleOrderItem.getProductId()){
                                Product product = new Product();
                                product.setId(r.getValue(p.ID));
                                product.setName(r.getValue(p.NAME));
                                product.setImageUrl(r.getValue(p.IMAGE_URL));
                                saleOrderItem.setProduct(product);
                            }


                            return saleOrderItem;
                        });
    }

    public Mono<Page<SaleOrderItem>> pageQuery(Long orderId, String name, PageRequest pageRequest) {
        com.agri.mis.db.tables.SaleOrderItem bcei =  com.agri.mis.db.tables.SaleOrderItem.SALE_ORDER_ITEM;

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
                                            SaleOrderItem saleOrderItem = new SaleOrderItem();
                                            saleOrderItem.setId(r.getValue(bcei.ID));
                                            saleOrderItem.setOrderId(r.getValue(bcei.ORDER_ID));
                                            saleOrderItem.setProductId(r.getValue(bcei.PRODUCT_ID));
                                            saleOrderItem.setProductSku(r.getValue(bcei.PRODUCT_SKU));
                                            saleOrderItem.setDescription(r.getValue(bcei.DESCRIPTION));
                                            saleOrderItem.setAmount(r.getValue(bcei.AMOUNT));
                                            saleOrderItem.setPrice(r.getValue(bcei.PRICE));
                                            saleOrderItem.setQuantity(r.getValue(bcei.QUANTITY));
                                            saleOrderItem.setCreatedAt(r.getValue(bcei.CREATED_AT));

                                            if(null!= saleOrderItem.getProductId()){
                                                Product product = new Product();
                                                product.setId(r.getValue(p.ID));
                                                product.setName(r.getValue(p.NAME));
                                                product.setImageUrl(r.getValue(p.IMAGE_URL));
                                                saleOrderItem.setProduct(product);
                                            }


                                            return saleOrderItem;
                                        }).collectList(),Mono.from(countSql).map(Record1::value1))
                .map(it -> new PageImpl<>(it.getT1(),pageRequest,it.getT2()));
    }
}
