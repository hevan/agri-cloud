package com.agri.mis.service;

import com.agri.mis.domain.*;
import com.agri.mis.repository.FinanceExpenseItemRepository;
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
public class FinanceExpenseItemService {
    @Autowired
    private FinanceExpenseItemRepository financeExpenseItemRepository;

    @Autowired
    private DSLContext dslContext;

    public Mono<FinanceExpenseItem> findById(Long id){
        return financeExpenseItemRepository.findById(id);
    }

    public Mono<FinanceExpenseItem> add(FinanceExpenseItem financeExpenseItem){
        return financeExpenseItemRepository.save(financeExpenseItem);
    }

    public Mono<FinanceExpenseItem> update(Long id, FinanceExpenseItem financeExpenseItem){
        return financeExpenseItemRepository.findById(id).flatMap(
                r ->{
                    financeExpenseItem.setId(r.getId());
                    return financeExpenseItemRepository.save(financeExpenseItem);
                }
        );
    }

    public Mono<Void> delete(FinanceExpenseItem financeExpenseItem){
        return financeExpenseItemRepository.delete(financeExpenseItem);
    }

    public Flux<FinanceExpenseItem> findAllByExpenseId(Long expenseId){
        com.agri.mis.db.tables.FinanceExpenseItem bcei =  com.agri.mis.db.tables.FinanceExpenseItem.FINANCE_EXPENSE_ITEM;

        com.agri.mis.db.tables.Product p = com.agri.mis.db.tables.Product.PRODUCT;

        Condition where = DSL.trueCondition();


        if(null != expenseId){
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
        ).from(bcei).leftJoin(p).on(bcei.PRODUCT_ID.eq(p.ID)).where(where);


        return Flux.from(dataSql)
                .map(
                        r->{
                            FinanceExpenseItem financeExpenseItem = new FinanceExpenseItem();
                            financeExpenseItem.setId(r.getValue(bcei.ID));
                            financeExpenseItem.setExpenseId(r.getValue(bcei.EXPENSE_ID));
                            financeExpenseItem.setProductId(r.getValue(bcei.PRODUCT_ID));
                            financeExpenseItem.setProductSku(r.getValue(bcei.PRODUCT_SKU));
                            financeExpenseItem.setDescription(r.getValue(bcei.DESCRIPTION));
                            financeExpenseItem.setAmount(r.getValue(bcei.AMOUNT));
                            financeExpenseItem.setPrice(r.getValue(bcei.PRICE));
                            financeExpenseItem.setQuantity(r.getValue(bcei.QUANTITY));
                            financeExpenseItem.setCreatedAt(r.getValue(bcei.CREATED_AT));

                            if(null!= financeExpenseItem.getProductId()){
                                Product product = new Product();
                                product.setId(r.getValue(p.ID));
                                product.setName(r.getValue(p.NAME));
                                product.setImageUrl(r.getValue(p.IMAGE_URL));
                                financeExpenseItem.setProduct(product);
                            }


                            return financeExpenseItem;
                        });
    }

    public Mono<Page<FinanceExpenseItem>> pageQuery(Long expenseId, String name, PageRequest pageRequest) {
        com.agri.mis.db.tables.FinanceExpenseItem bcei =  com.agri.mis.db.tables.FinanceExpenseItem.FINANCE_EXPENSE_ITEM;

        com.agri.mis.db.tables.Product p = com.agri.mis.db.tables.Product.PRODUCT;

        Condition where = DSL.trueCondition();

        if(StringUtils.hasLength(name)){
            where = where.and(p.NAME.like("%" + name +"%"));
        }

        if(null != expenseId){
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
                                            FinanceExpenseItem financeExpenseItem = new FinanceExpenseItem();
                                            financeExpenseItem.setId(r.getValue(bcei.ID));
                                            financeExpenseItem.setExpenseId(r.getValue(bcei.EXPENSE_ID));
                                            financeExpenseItem.setProductId(r.getValue(bcei.PRODUCT_ID));
                                            financeExpenseItem.setProductSku(r.getValue(bcei.PRODUCT_SKU));
                                            financeExpenseItem.setDescription(r.getValue(bcei.DESCRIPTION));
                                            financeExpenseItem.setAmount(r.getValue(bcei.AMOUNT));
                                            financeExpenseItem.setPrice(r.getValue(bcei.PRICE));
                                            financeExpenseItem.setQuantity(r.getValue(bcei.QUANTITY));
                                            financeExpenseItem.setCreatedAt(r.getValue(bcei.CREATED_AT));

                                            if(null!= financeExpenseItem.getProductId()){
                                                Product product = new Product();
                                                product.setId(r.getValue(p.ID));
                                                product.setName(r.getValue(p.NAME));
                                                product.setImageUrl(r.getValue(p.IMAGE_URL));
                                                financeExpenseItem.setProduct(product);
                                            }


                                            return financeExpenseItem;
                                        }).collectList(),Mono.from(countSql).map(Record1::value1))
                .map(it -> new PageImpl<>(it.getT1(),pageRequest,it.getT2()));
    }
}
