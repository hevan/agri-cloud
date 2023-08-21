package com.agri.mis.service;

import com.agri.mis.domain.BatchCycle;
import com.agri.mis.domain.BatchCycleInvest;
import com.agri.mis.domain.Product;
import com.agri.mis.repository.BatchCycleInvestRepository;
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
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.jooq.impl.DSL.select;

@Service
public class BatchCycleInvestService {

    @Autowired
    private BatchCycleInvestRepository repository;

    @Autowired
    private DSLContext dslContext;

    public Mono<BatchCycleInvest> findById(Long id){
        com.agri.mis.db.tables.BatchCycleInvest bce = com.agri.mis.db.tables.BatchCycleInvest.BATCH_CYCLE_INVEST;

        com.agri.mis.db.tables.BatchCycle bc = com.agri.mis.db.tables.BatchCycle.BATCH_CYCLE;

        com.agri.mis.db.tables.Product pd = com.agri.mis.db.tables.Product.PRODUCT;

        Condition where = DSL.trueCondition();

        if(null != id){
            where = where.and(bce.ID.eq(id));
        }
        var dataSql = dslContext.select(
                bce.ID,
                bce.BATCH_CYCLE_ID,
                bce.PRODUCT_ID,
                bce.PRODUCT_SKU,
                bce.DESCRIPTION,
                bce.AMOUNT,
                bce.PRICE,
                bce.QUANTITY,
                bce.CREATED_AT,
                bce.CREATED_USER_ID,
                bce.UPDATED_AT,
                bce.BATCH_ID,
                bce.CORP_ID,

                bc.ID,
                bc.NAME,
                bc.DESCRIPTION,
                bc.IMAGE_URL,
                bc.START_AT,
                bc.END_AT,
                bc.STATUS,

                pd.ID,
                pd.NAME,
                pd.CODE,
                pd.IMAGE_URL
        ).from(bce).leftJoin(bc).on(bce.BATCH_CYCLE_ID.eq(bc.ID)).leftJoin(pd).on(bce.PRODUCT_ID.eq(pd.ID)).where(where);


        return   Mono.from(dataSql)
                .map(
                        r->{
                            BatchCycleInvest batchCycleInvest = new BatchCycleInvest();
                            batchCycleInvest.setId(r.getValue(bce.ID));
                            batchCycleInvest.setBatchCycleId(r.getValue(bce.BATCH_CYCLE_ID));
                            batchCycleInvest.setProductId(r.getValue(bce.PRODUCT_ID));
                            batchCycleInvest.setProductSku(r.getValue(bce.PRODUCT_SKU));
                            batchCycleInvest.setDescription(r.getValue(bce.DESCRIPTION));
                            batchCycleInvest.setAmount(r.getValue(bce.AMOUNT));
                            batchCycleInvest.setPrice(r.getValue(bce.PRICE));
                            batchCycleInvest.setQuantity(r.getValue(bce.QUANTITY));
                            batchCycleInvest.setCreatedAt(r.getValue(bce.CREATED_AT));
                            batchCycleInvest.setUpdatedAt(r.getValue(bce.UPDATED_AT));
                            batchCycleInvest.setCreatedUserId(r.getValue(bce.CREATED_USER_ID));
                            batchCycleInvest.setBatchId(r.getValue(bce.BATCH_ID));
                            batchCycleInvest.setCorpId(r.getValue(bce.CORP_ID));



                            if(null!=batchCycleInvest.getBatchCycleId()){
                                BatchCycle batchCycle = new BatchCycle();
                                batchCycle.setId(batchCycleInvest.getBatchCycleId());
                                batchCycle.setName(r.getValue(bc.NAME));
                                batchCycle.setImageUrl(r.getValue(bc.IMAGE_URL));
                                batchCycle.setDescription(r.getValue(bc.DESCRIPTION));
                                batchCycle.setStartAt(r.getValue(bc.START_AT));
                                batchCycle.setEndAt(r.getValue(bc.END_AT));
                                batchCycle.setStatus(r.getValue(bc.STATUS));
                                batchCycleInvest.setBatchCycle(batchCycle);
                         }
                            if(null!=batchCycleInvest.getProductId()){
                                Product product = new Product();
                                product.setId(r.getValue(pd.ID));
                                product.setName(r.getValue(pd.NAME));
                                product.setCode(r.getValue(pd.CODE));
                                product.setImageUrl(r.getValue(pd.IMAGE_URL));
                                batchCycleInvest.setProduct(product);
                            }

            return batchCycleInvest;
        });

    }

    public Flux<BatchCycleInvest> findAllByBatchCycleId(Long batchCycleId){
        com.agri.mis.db.tables.BatchCycleInvest bce = com.agri.mis.db.tables.BatchCycleInvest.BATCH_CYCLE_INVEST;

        com.agri.mis.db.tables.BatchCycle bc = com.agri.mis.db.tables.BatchCycle.BATCH_CYCLE;

        com.agri.mis.db.tables.Product pd = com.agri.mis.db.tables.Product.PRODUCT;

        Condition where = DSL.trueCondition();

        if(null != batchCycleId){
            where = where.and(bce.BATCH_CYCLE_ID.eq(batchCycleId));
        }
        var dataSql = dslContext.select(
                bce.ID,
                bce.BATCH_CYCLE_ID,
                bce.PRODUCT_ID,
                bce.PRODUCT_SKU,
                bce.DESCRIPTION,
                bce.AMOUNT,
                bce.PRICE,
                bce.QUANTITY,
                bce.CREATED_AT,
                bce.CREATED_USER_ID,
                bce.UPDATED_AT,
                bce.BATCH_ID,
                bce.CORP_ID,

                bc.ID,
                bc.NAME,
                bc.DESCRIPTION,
                bc.IMAGE_URL,
                bc.START_AT,
                bc.END_AT,
                bc.STATUS,

                pd.ID,
                pd.NAME,
                pd.CODE,
                pd.IMAGE_URL
        ).from(bce).leftJoin(bc).on(bce.BATCH_CYCLE_ID.eq(bc.ID)).leftJoin(pd).on(bce.PRODUCT_ID.eq(pd.ID)).where(where).orderBy(bce.BATCH_CYCLE_ID);


        return   Flux.from(dataSql)
                .map(
                        r->{
                            BatchCycleInvest batchCycleInvest = new BatchCycleInvest();
                            batchCycleInvest.setId(r.getValue(bce.ID));
                            batchCycleInvest.setBatchCycleId(r.getValue(bce.BATCH_CYCLE_ID));
                            batchCycleInvest.setProductId(r.getValue(bce.PRODUCT_ID));
                            batchCycleInvest.setProductSku(r.getValue(bce.PRODUCT_SKU));
                            batchCycleInvest.setDescription(r.getValue(bce.DESCRIPTION));
                            batchCycleInvest.setAmount(r.getValue(bce.AMOUNT));
                            batchCycleInvest.setPrice(r.getValue(bce.PRICE));
                            batchCycleInvest.setQuantity(r.getValue(bce.QUANTITY));
                            batchCycleInvest.setCreatedAt(r.getValue(bce.CREATED_AT));
                            batchCycleInvest.setUpdatedAt(r.getValue(bce.UPDATED_AT));
                            batchCycleInvest.setCreatedUserId(r.getValue(bce.CREATED_USER_ID));
                            batchCycleInvest.setBatchId(r.getValue(bce.BATCH_ID));
                            batchCycleInvest.setCorpId(r.getValue(bce.CORP_ID));


                            if(null!=batchCycleInvest.getBatchCycleId()){
                                BatchCycle batchCycle = new BatchCycle();
                                batchCycle.setId(batchCycleInvest.getBatchCycleId());
                                batchCycle.setName(r.getValue(bc.NAME));
                                batchCycle.setImageUrl(r.getValue(bc.IMAGE_URL));
                                batchCycle.setDescription(r.getValue(bc.DESCRIPTION));
                                batchCycle.setStartAt(r.getValue(bc.START_AT));
                                batchCycle.setEndAt(r.getValue(bc.END_AT));
                                batchCycle.setStatus(r.getValue(bc.STATUS));
                                batchCycleInvest.setBatchCycle(batchCycle);
                            }
                            if(null!=batchCycleInvest.getProductId()){
                                Product product = new Product();
                                product.setId(r.getValue(pd.ID));
                                product.setName(r.getValue(pd.NAME));
                                product.setCode(r.getValue(pd.CODE));
                                product.setImageUrl(r.getValue(pd.IMAGE_URL));
                                batchCycleInvest.setProduct(product);
                            }

                            return batchCycleInvest;
                        });

    }

   public Mono<BatchCycleInvest> add(BatchCycleInvest batchCycleInvest){
       return repository.save(batchCycleInvest);
   }

   public Mono<BatchCycleInvest> update(Long id,BatchCycleInvest batchCycleInvest){
       return repository.findById(id).flatMap(
               r ->{
                   batchCycleInvest.setId(r.getId());
                   return repository.save(batchCycleInvest);
               }
       );
   }

   public Mono<Void> delete(BatchCycleInvest batchCycleInvest){
        return repository.delete(batchCycleInvest);
   }

    public Mono<Page<BatchCycleInvest>> pageQuery(BatchCycleInvest batchCycleInvestParam, PageRequest pageRequest) {
        com.agri.mis.db.tables.BatchCycleInvest bce = com.agri.mis.db.tables.BatchCycleInvest.BATCH_CYCLE_INVEST;


        com.agri.mis.db.tables.BatchCycle bc = com.agri.mis.db.tables.BatchCycle.BATCH_CYCLE;

        com.agri.mis.db.tables.Product pd = com.agri.mis.db.tables.Product.PRODUCT;

        Condition where = DSL.trueCondition();

        if(null != batchCycleInvestParam.getBatchCycleId()){
            where = where.and(bce.BATCH_CYCLE_ID.eq(batchCycleInvestParam.getBatchCycleId()));
        }

        if(null != batchCycleInvestParam.getProductId()){
            where = where.and(bce.PRODUCT_ID.eq(batchCycleInvestParam.getProductId()));
        }

        if(null != batchCycleInvestParam.getCreatedUserId()){
            where = where.and(bce.CREATED_USER_ID.eq(batchCycleInvestParam.getCreatedUserId()));
        }

        if(null != batchCycleInvestParam.getCorpId()){
            where = where.and(bce.CORP_ID.eq(batchCycleInvestParam.getCorpId()));
        }

        if(null != batchCycleInvestParam.getBatchId()){
            where = where.and(bce.BATCH_ID.eq(batchCycleInvestParam.getBatchId()));
        }

        var dataSql = dslContext.select(
                bce.ID,
                bce.BATCH_CYCLE_ID,
                bce.PRODUCT_ID,
                bce.PRODUCT_SKU,
                bce.DESCRIPTION,
                bce.AMOUNT,
                bce.PRICE,
                bce.QUANTITY,
                bce.CREATED_AT,
                bce.CREATED_USER_ID,
                bce.UPDATED_AT,
                bce.BATCH_ID,
                bce.CORP_ID,

                bc.ID,
                bc.NAME,
                bc.DESCRIPTION,
                bc.IMAGE_URL,
                bc.START_AT,
                bc.END_AT,
                bc.STATUS,

                pd.ID,
                pd.CODE,
                pd.NAME,
                pd.IMAGE_URL
        ).from(bce).leftJoin(bc).on(bce.BATCH_CYCLE_ID.eq(bc.ID)).leftJoin(pd).on(bce.PRODUCT_ID.eq(pd.ID)).where(where).limit(pageRequest.getOffset(),pageRequest.getPageSize());
        val countSql = dslContext.select(DSL.field("count(*)", SQLDataType.BIGINT))
                .from(bce)
                .where(where);
        return Mono
                .zip(
                        Flux.from(dataSql)
                                .map(
                                        r->{
                                            BatchCycleInvest batchCycleInvest = new BatchCycleInvest();
                                            batchCycleInvest.setId(r.getValue(bce.ID));
                                            batchCycleInvest.setBatchCycleId(r.getValue(bce.BATCH_CYCLE_ID));
                                            batchCycleInvest.setProductId(r.getValue(bce.PRODUCT_ID));
                                            batchCycleInvest.setProductSku(r.getValue(bce.PRODUCT_SKU));
                                            batchCycleInvest.setDescription(r.getValue(bce.DESCRIPTION));
                                            batchCycleInvest.setAmount(r.getValue(bce.AMOUNT));
                                            batchCycleInvest.setPrice(r.getValue(bce.PRICE));
                                            batchCycleInvest.setQuantity(r.getValue(bce.QUANTITY));
                                            batchCycleInvest.setCreatedAt(r.getValue(bce.CREATED_AT));
                                            batchCycleInvest.setUpdatedAt(r.getValue(bce.UPDATED_AT));
                                            batchCycleInvest.setCreatedUserId(r.getValue(bce.CREATED_USER_ID));
                                            batchCycleInvest.setBatchId(r.getValue(bce.BATCH_ID));
                                            batchCycleInvest.setCorpId(r.getValue(bce.CORP_ID));


                                            if(null!=batchCycleInvest.getBatchCycleId()){
                                                BatchCycle batchCycle = new BatchCycle();
                                                batchCycle.setId(batchCycleInvest.getBatchCycleId());
                                                batchCycle.setName(r.getValue(bc.NAME));
                                                batchCycle.setImageUrl(r.getValue(bc.IMAGE_URL));
                                                batchCycle.setDescription(r.getValue(bc.DESCRIPTION));
                                                batchCycle.setStartAt(r.getValue(bc.START_AT));
                                                batchCycle.setEndAt(r.getValue(bc.END_AT));
                                                batchCycle.setStatus(r.getValue(bc.STATUS));
                                                batchCycleInvest.setBatchCycle(batchCycle);
                                            }

                                            if(null!=batchCycleInvest.getProductId()){
                                                Product product = new Product();
                                                product.setId(r.getValue(pd.ID));
                                                product.setName(r.getValue(pd.NAME));
                                                product.setCode(r.getValue(pd.CODE));
                                                product.setImageUrl(r.getValue(pd.IMAGE_URL));
                                                batchCycleInvest.setProduct(product);
                                            }

                                            return batchCycleInvest;
                                        }).collectList(),Mono.from(countSql).map(Record1::value1))
                .map(it -> new PageImpl<>(it.getT1(),pageRequest,it.getT2()));
    }
}
