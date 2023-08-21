package com.agri.mis.service;

import com.agri.mis.domain.*;
import com.agri.mis.dto.BatchFinanceAnalysis;
import com.agri.mis.dto.CheckManager;
import com.agri.mis.dto.TotalSum;
import com.agri.mis.repository.BatchProductRepository;
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

import java.math.BigDecimal;
import java.util.List;

import static org.jooq.Records.mapping;
import static org.jooq.impl.DSL.*;

@Service
public class BatchProductService {
    @Autowired
    private BatchProductRepository batchProductRepository;
    // 多表查询
    @Autowired
    private DSLContext dslContext;

    // 根据id查询数据
    public Mono<BatchProduct> findById(Long id) {

        com.agri.mis.db.tables.BatchProduct bp = com.agri.mis.db.tables.BatchProduct.BATCH_PRODUCT;
        com.agri.mis.db.tables.Corp ct =  com.agri.mis.db.tables.Corp.CORP;
        com.agri.mis.db.tables.Product pt =  com.agri.mis.db.tables.Product.PRODUCT;
        com.agri.mis.db.tables.CorpPark pk =  com.agri.mis.db.tables.CorpPark.CORP_PARK;

        Condition where = DSL.trueCondition();

            where = where.and(bp.ID.eq(id));

        var dataSql = dslContext.select(
                bp.ID, bp.NAME, bp.CODE, bp.PRODUCT_ID, bp.START_AT, bp.END_AT, bp.DAYS, bp.AREA, bp.ESTIMATED_PRICE, bp.QUANTITY,
                bp.CORP_ID, bp.CALC_UNIT, bp.PARK_ID, bp.CREATED_USER_ID,
                bp.CREATED_AT, bp.DESCRIPTION, bp.STATUS,
                ct.ID, ct.NAME, ct.CODE, pt.ID, pt.NAME, pt.CODE, pt.IMAGE_URL, pk.ID, pk.NAME
        ).from(bp).leftJoin(ct).on(bp.CORP_ID.eq(ct.ID)).leftJoin(pt).on(bp.PRODUCT_ID.eq(pt.ID)).leftJoin(pk).on(bp.PARK_ID.eq(pk.ID)).where(where);

        return Mono.from(dataSql).map(
                        r ->{
                            BatchProduct batchProduct = new BatchProduct();
                            batchProduct.setId(r.getValue(bp.ID));
                            batchProduct.setName(r.getValue(bp.NAME));
                            batchProduct.setArea(r.getValue(bp.AREA));
                            batchProduct.setCode(r.getValue(bp.CODE));
                            batchProduct.setProductId(r.getValue(bp.PRODUCT_ID));
                            batchProduct.setStartAt(r.getValue(bp.START_AT));
                            batchProduct.setEndAt(r.getValue(bp.END_AT));
                            batchProduct.setDays(r.getValue(bp.DAYS));
                            batchProduct.setEstimatedPrice(r.getValue(bp.ESTIMATED_PRICE));
                            batchProduct.setQuantity(r.getValue(bp.QUANTITY));
                            batchProduct.setCorpId(r.getValue(bp.CORP_ID));
                            batchProduct.setCalcUnit(r.getValue(bp.CALC_UNIT));
                            batchProduct.setParkId(r.getValue(bp.PARK_ID));

                            batchProduct.setCreatedUserId(r.getValue(bp.CREATED_USER_ID));
                            batchProduct.setCreatedAt(r.getValue(bp.CREATED_AT));
                            batchProduct.setDescription(r.getValue(bp.DESCRIPTION));
                            batchProduct.setStatus(r.getValue(bp.STATUS));

                            if (null != batchProduct.getCorpId()){
                                Corp corp = new Corp();
                                corp.setId(batchProduct.getCorpId());
                                corp.setName(r.getValue(ct.NAME));
                                corp.setCode(r.getValue(ct.CODE));

                                batchProduct.setCorp(corp);
                            }
                            if (null != batchProduct.getProductId()){
                                Product product = new Product();
                                product.setId(batchProduct.getProductId());
                                product.setName(r.getValue(pt.NAME));
                                product.setCode(r.getValue(pt.CODE));

                                batchProduct.setProduct(product);
                            }
                            if (null != batchProduct.getParkId()){
                                CorpPark corpPark = new CorpPark();
                                corpPark.setId(batchProduct.getParkId());
                                corpPark.setName(r.getValue(pk.NAME));

                                batchProduct.setPark(corpPark);
                            }
                            return batchProduct;

                        });

    }

    // 添加数据
    public Mono<BatchProduct> add(BatchProduct batchProduct) {
        return batchProductRepository.save(batchProduct);
    }

    // 根据id修该数据
    public Mono<BatchProduct> update(Long id, BatchProduct batchProduct) {
        return batchProductRepository.findById(id).flatMap(
                s -> {
                    batchProduct.setId(s.getId());
                    return batchProductRepository.save(batchProduct);
                }
        );
    }

   // 根据id删除数据
    public Mono<Void> delete(BatchProduct batchProduct) {
        return batchProductRepository.delete(batchProduct);
    }

    public Mono<Page<BatchProduct>> pageQuery(BatchProduct batchProductParam, Long userId, PageRequest pageRequest) {
        com.agri.mis.db.tables.BatchProduct bp = com.agri.mis.db.tables.BatchProduct.BATCH_PRODUCT;
        com.agri.mis.db.tables.Corp ct =  com.agri.mis.db.tables.Corp.CORP;
        com.agri.mis.db.tables.Product pt =  com.agri.mis.db.tables.Product.PRODUCT;
        com.agri.mis.db.tables.CorpPark pk =  com.agri.mis.db.tables.CorpPark.CORP_PARK;
        com.agri.mis.db.tables.BatchTeam bt =   com.agri.mis.db.tables.BatchTeam.BATCH_TEAM;
        com.agri.mis.db.tables.Users us =   com.agri.mis.db.tables.Users.USERS;

        Condition where = trueCondition();
        if (null != batchProductParam.getCorpId()) {
            where = where.and(bp.CORP_ID.eq(batchProductParam.getCorpId()));
        }
        if (null != batchProductParam.getStatus()) {
            where = where.and(bp.STATUS.eq(batchProductParam.getStatus()));
        }

        if (null != batchProductParam.getStatus()) {
            where = where.and(bp.STATUS.eq(batchProductParam.getStatus()));
        }

        if (null != userId) {
            where = where.and(bp.ID.in(select(bt.BATCH_ID).from(bt).where(bt.USER_ID.eq(userId))));

        }
        var dataSql = dslContext.select(
                bp.ID, bp.NAME, bp.CODE, bp.PRODUCT_ID, bp.START_AT, bp.END_AT, bp.DAYS, bp.ESTIMATED_PRICE, bp.QUANTITY,
                bp.CORP_ID, bp.CALC_UNIT, bp.PARK_ID, bp.CREATED_USER_ID,
                bp.CREATED_AT, bp.DESCRIPTION, bp.STATUS, bp.AREA,
                ct.ID, ct.NAME, ct.CODE, pt.ID, pt.NAME, pt.CODE, pt.IMAGE_URL, pk.ID, pk.NAME,
                multiset(
                        select(
                                bt.ID,
                                bt.BATCH_ID,
                                bt.USER_ID,
                                bt.IS_MANAGER,
                                bt.CREATED_AT,
                                us.ID,
                                us.NICK_NAME,
                                us.HEADER_URL,
                                us.MOBILE)
                                .from(bt).leftJoin(us).on(bt.USER_ID.eq(us.ID))
                                                .where(bt.BATCH_ID.eq(bp.ID))
                ).as("TEAM_MEMBERS").convertFrom(t -> {
                   return  t.map(tt -> {
                        com.agri.mis.domain.BatchTeam team = new com.agri.mis.domain.BatchTeam(
                                tt.getValue(bt.ID),
                                tt.getValue(bt.BATCH_ID),
                                tt.getValue(bt.USER_ID),
                                tt.getValue(bt.IS_MANAGER),
                                tt.getValue(bt.CREATED_AT),
                                null
                        );
                        if (null != team.getUserId()) {
                            CheckManager user = new CheckManager();
                            user.setUserId(team.getUserId());
                            user.setHeaderUrl(tt.getValue(us.HEADER_URL));
                            user.setNickName(tt.getValue(us.NICK_NAME));
                            user.setMobile(tt.getValue(us.MOBILE));
                            team.setUser(user);
                        }
                        return team;
                    });
                })
        ).from(bp).leftJoin(ct).on(bp.CORP_ID.eq(ct.ID)).leftJoin(pt).on(bp.PRODUCT_ID.eq(pt.ID)).leftJoin(pk).on(bp.PARK_ID.eq(pk.ID)).where(where).limit(pageRequest.getOffset(), pageRequest.getPageSize());
        val countSql = dslContext.select(field("count(*)", SQLDataType.BIGINT))
                .from(bp)
                .where(where);
          return Mono.zip(
                  Flux.from(dataSql).map(
                          r ->{
                              BatchProduct batchProduct = new BatchProduct();
                              batchProduct.setId(r.getValue(bp.ID));
                              batchProduct.setName(r.getValue(bp.NAME));
                              batchProduct.setArea(r.getValue(bp.AREA));
                              batchProduct.setCode(r.getValue(bp.CODE));
                              batchProduct.setProductId(r.getValue(bp.PRODUCT_ID));
                              batchProduct.setStartAt(r.getValue(bp.START_AT));
                              batchProduct.setEndAt(r.getValue(bp.END_AT));
                              batchProduct.setDays(r.getValue(bp.DAYS));
                              batchProduct.setEstimatedPrice(r.getValue(bp.ESTIMATED_PRICE));
                              batchProduct.setQuantity(r.getValue(bp.QUANTITY));
                              batchProduct.setCorpId(r.getValue(bp.CORP_ID));
                              batchProduct.setCalcUnit(r.getValue(bp.CALC_UNIT));
                              batchProduct.setParkId(r.getValue(bp.PARK_ID));


                              batchProduct.setCreatedUserId(r.getValue(bp.CREATED_USER_ID));
                              batchProduct.setCreatedAt(r.getValue(bp.CREATED_AT));
                              batchProduct.setDescription(r.getValue(bp.DESCRIPTION));
                              batchProduct.setStatus(r.getValue(bp.STATUS));

                              if (null != batchProduct.getCorpId()){
                                  Corp corp = new Corp();
                                  corp.setId(batchProduct.getCorpId());
                                  corp.setName(r.getValue(ct.NAME));
                                  corp.setCode(r.getValue(ct.CODE));

                                     batchProduct.setCorp(corp);
                              }
                              if (null != batchProduct.getProductId()){
                                  Product product = new Product();
                                  product.setId(batchProduct.getProductId());
                                  product.setName(r.getValue(pt.NAME));
                                  product.setCode(r.getValue(pt.CODE));
                                  product.setImageUrl(r.getValue(pt.IMAGE_URL));

                                  batchProduct.setProduct(product);
                              }

                              if (null != batchProduct.getParkId()){
                                  CorpPark corpPark = new CorpPark();
                                  corpPark.setId(batchProduct.getParkId());
                                  corpPark.setName(r.getValue(pk.NAME));

                                  batchProduct.setPark(corpPark);
                              }

                              if (null != r.getValue("TEAM_MEMBERS")){
                                  batchProduct.setListTeam((List<BatchTeam>) r.getValue("TEAM_MEMBERS"));
                              }

                              return batchProduct;

                          }).collectList(),Mono.from(countSql).map(Record1::value1)
          ).map(it -> new PageImpl<>(it.getT1(),pageRequest, it.getT2()));

    }

    public Mono<BatchFinanceAnalysis> batchFinanceAnalysis(Long id){

        com.agri.mis.db.tables.BatchProduct bp = com.agri.mis.db.tables.BatchProduct.BATCH_PRODUCT;
        com.agri.mis.db.tables.Product pt =  com.agri.mis.db.tables.Product.PRODUCT;
        com.agri.mis.db.tables.BatchBase bb =  com.agri.mis.db.tables.BatchBase.BATCH_BASE;
        com.agri.mis.db.tables.BatchCycleInvest bi=  com.agri.mis.db.tables.BatchCycleInvest.BATCH_CYCLE_INVEST;
        com.agri.mis.db.tables.PurchaseOrder po =  com.agri.mis.db.tables.PurchaseOrder.PURCHASE_ORDER;
        com.agri.mis.db.tables.SaleOrder so =  com.agri.mis.db.tables.SaleOrder.SALE_ORDER;

        Condition where = DSL.trueCondition();

        where = where.and(bp.ID.eq(id));

        var dataSql = dslContext.select(
                bp.ID, bp.NAME, bp.ESTIMATED_PRICE, bp.PRODUCT_ID, pt.NAME,
                multiset(
                        select(sum(bb.AREA).as("QUANTITY"), sum(bb.QUANTITY).as("AMOUNT")).from(bb).where(bb.BATCH_ID.eq(bp.ID))
                ).convertFrom(r -> r.map(mapping(TotalSum::new))),
                select(sum(bi.AMOUNT)).from(bi).where(bi.BATCH_ID.eq(bp.ID)).asField("INVEST"),
                select(sum(po.AMOUNT)).from(po).where(po.BATCH_ID.eq(bp.ID)).asField("PURCH"),
                multiset(
                        select(sum(so.QUANTITY), sum(so.AMOUNT)).from(so).where(so.BATCH_ID.eq(bp.ID))
                ).convertFrom(r -> r.map(mapping(TotalSum::new)))
                ).from(bp).leftJoin(pt).on(bp.PRODUCT_ID.eq(pt.ID)).where(where);

        return Mono.from(dataSql).map(
                r ->{
                    BatchFinanceAnalysis batchFinanceAnalysis = new BatchFinanceAnalysis();
                    batchFinanceAnalysis.setBatchId(r.getValue(bp.ID));
                    batchFinanceAnalysis.setBatchName(r.getValue(bp.NAME));
                    batchFinanceAnalysis.setProductId(r.getValue(bp.PRODUCT_ID));
                    batchFinanceAnalysis.setProductName(r.getValue(pt.NAME));
                    batchFinanceAnalysis.setEstimatedPrice(r.getValue(bp.ESTIMATED_PRICE));
                    List<TotalSum> curSum  = (List<TotalSum>) r.getValue(5);

                    //产量统计
                    if(null != curSum && curSum.size() > 0) {
                        TotalSum areaTotal = curSum.get(0);
                        batchFinanceAnalysis.setArea(null == areaTotal.getQuantity() ? new BigDecimal(0.00) : areaTotal.getQuantity() );
                        batchFinanceAnalysis.setQuantity( null ==  areaTotal.getAmount() ? new BigDecimal(0.00) : areaTotal.getAmount());
                        batchFinanceAnalysis.setEstimatedTotal(batchFinanceAnalysis.getArea().multiply(batchFinanceAnalysis.getQuantity()));

                    }
                    batchFinanceAnalysis.setEstimatedAmount(batchFinanceAnalysis.getEstimatedTotal().multiply(batchFinanceAnalysis.getEstimatedPrice()));

                    //
                    batchFinanceAnalysis.setEstimatedInvest((BigDecimal) r.getValue(6));
                    batchFinanceAnalysis.setRealInvest((BigDecimal) r.getValue(7));

                    if(null == batchFinanceAnalysis.getEstimatedInvest() ){
                        batchFinanceAnalysis.setEstimatedInvest( new BigDecimal(0.0));
                    }

                    if(null == batchFinanceAnalysis.getRealInvest() ){
                        batchFinanceAnalysis.setRealInvest( new BigDecimal(0.0));
                    }

                    //实际销售
                    List<TotalSum> curSumReal  = (List<TotalSum>)  r.getValue(8);
                    if(null != curSumReal && curSumReal.size() > 0) {
                        TotalSum realTotal = curSumReal.get(0);
                        batchFinanceAnalysis.setRealTotal(null == realTotal.getQuantity() ? new BigDecimal(0.00) : realTotal.getQuantity() );
                        batchFinanceAnalysis.setRealAmount( null ==  realTotal.getAmount() ? new BigDecimal(0.00) : realTotal.getAmount());
                    }

                    return batchFinanceAnalysis;

                });

        }

}
