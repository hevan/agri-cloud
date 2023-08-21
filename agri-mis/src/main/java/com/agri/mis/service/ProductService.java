package com.agri.mis.service;

import com.agri.mis.domain.*;
import com.agri.mis.repository.ProductRepository;
import lombok.val;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private DSLContext dslContext;

    public Mono<Product> findById(Long id) {
        com.agri.mis.db.tables.Product pt =  com.agri.mis.db.tables.Product.PRODUCT;

        com.agri.mis.db.tables.Category cy = com.agri.mis.db.tables.Category.CATEGORY;
        Condition where = DSL.trueCondition();

        where = where.and(pt.ID.eq(id));

        var dataSql = dslContext.select(
                pt.ID,
                pt.NAME,
                pt.CODE,
                pt.CATEGORY_ID,
                pt.IMAGE_URL,
                pt.CALC_UNIT,
                pt.CORP_ID,
                pt.CREATED_AT,
                pt.CREATED_BY,
                pt.UPDATED_AT,
                pt.UPDATED_BY,
                pt.DESCRIPTION,

                cy.ID,
                cy.PATH_NAME,
                cy.NAME,
                cy.IMAGE_URL,
                cy.PARENT_ID,
                cy.CORP_ID

        ).from(pt).leftJoin(cy).on(pt.CATEGORY_ID.eq(cy.ID)).and(where);

      return  Mono.from(dataSql)
              .map(r -> {
                  Product product = new Product();

                  product.setId(r.getValue(pt.ID));
                  product.setName(r.getValue(pt.NAME));
                  product.setCode(r.getValue(pt.CODE));
                  product.setCategoryId(r.getValue(pt.CATEGORY_ID));
                  product.setImageUrl(r.getValue(pt.IMAGE_URL));
                  product.setCalcUnit(r.getValue(pt.CALC_UNIT));
                  product.setCorpId(r.getValue(pt.CORP_ID));
                  product.setCreatedAt(r.getValue(pt.CREATED_AT));
                  product.setCreatedBy(r.getValue(pt.CREATED_BY));
                  product.setUpdatedAt(r.getValue(pt.UPDATED_AT));
                  product.setUpdatedBy(r.getValue(pt.UPDATED_BY));
                  product.setDescription(r.getValue(pt.DESCRIPTION));

                  if(null != product.getCategoryId()) {
                      Category category = new Category(
                              r.getValue(cy.ID),
                              r.getValue(cy.PATH_NAME),
                              r.getValue(cy.NAME),
                              r.getValue(cy.IMAGE_URL),
                              r.getValue(cy.PARENT_ID),
                              r.getValue(cy.CORP_ID)
                      );
                      product.setCategory(category);
                  }

                  return product;
              });
    }


    public Mono<Product> add(Product product) {
        return productRepository.save(product);
    }

    public Mono<Product> update(Long id, Product product) {
        return productRepository.findById(id)
                .flatMap(s -> {
                    s.setName(product.getName());
                    s.setCode(product.getCode());
                    s.setDescription(product.getDescription());
                    s.setImageUrl(product.getImageUrl());
                    s.setCalcUnit(product.getCalcUnit());
                    s.setCategoryId(product.getCategoryId());

                    return productRepository.save(s);
                });
    }

    public Mono<Void> delete(Product product) {
        return productRepository.delete(product);
    }

    public Mono<Page<Product>> pageQueryByExample(Product product, PageRequest pageRequest){

        ExampleMatcher exampleObjectMatcher = ExampleMatcher.matching()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains());
        return this.productRepository.findBy(Example.of(product, exampleObjectMatcher), pageRequest).collectList()
                .zipWith(this.productRepository.count(Example.of(product, exampleObjectMatcher)))
                .map(t -> new PageImpl<>(t.getT1(), pageRequest, t.getT2()));
    }

    public Mono<Page<Product>> pageQuery(Product productParam, PageRequest pageRequest) {
        com.agri.mis.db.tables.Product pt =  com.agri.mis.db.tables.Product.PRODUCT;

        com.agri.mis.db.tables.Category cy = com.agri.mis.db.tables.Category.CATEGORY;
        Condition where = DSL.trueCondition();

        if(StringUtils.hasLength(productParam.getName())){
            where = where.and(pt.NAME.like("%" + productParam.getName() +"%"));
        }

            if(StringUtils.hasLength(productParam.getCode())){
            where = where.and(pt.CODE.like( productParam.getCode() +"%"));
        }

        if(null != productParam.getCorpId()){
            where = where.and(pt.CORP_ID.eq(productParam.getCorpId()));
        }

        if(null != productParam.getCategoryId()){
            where = where.and(pt.CATEGORY_ID.eq(productParam.getCategoryId()));
        }
        var dataSql = dslContext.select(
                pt.ID,
                pt.NAME,
                pt.CODE,
                pt.CATEGORY_ID,
                pt.IMAGE_URL,
                pt.CALC_UNIT,
                pt.CORP_ID,
                pt.CREATED_AT,
                pt.CREATED_BY,
                pt.UPDATED_AT,
                pt.UPDATED_BY,
                pt.DESCRIPTION,

                cy.ID,
                cy.PATH_NAME,
                cy.NAME,
                cy.IMAGE_URL,
                cy.PARENT_ID,
                cy.CORP_ID

        ).from(pt).leftJoin(cy).on(pt.CATEGORY_ID.eq(cy.ID)).and(where);

        val countSql = dslContext.select(DSL.field("count(*)", SQLDataType.BIGINT))
                .from(pt)
                .where(where);

        return Mono
                .zip(
                        Flux.from(dataSql)
                                .map(r -> {
                                    Product product = new Product();

                                    product.setId(r.getValue(pt.ID));
                                    product.setName(r.getValue(pt.NAME));
                                    product.setCode(r.getValue(pt.CODE));
                                    product.setCategoryId(r.getValue(pt.CATEGORY_ID));
                                    product.setImageUrl(r.getValue(pt.IMAGE_URL));
                                    product.setCalcUnit(r.getValue(pt.CALC_UNIT));
                                    product.setCorpId(r.getValue(pt.CORP_ID));
                                    product.setCreatedAt(r.getValue(pt.CREATED_AT));
                                    product.setCreatedBy(r.getValue(pt.CREATED_BY));
                                    product.setUpdatedAt(r.getValue(pt.UPDATED_AT));
                                    product.setUpdatedBy(r.getValue(pt.UPDATED_BY));
                                    product.setDescription(r.getValue(pt.DESCRIPTION));


                                    if(null != product.getCategoryId()) {
                                        Category category = new Category(
                                                r.getValue(cy.ID),
                                                r.getValue(cy.PATH_NAME),
                                                r.getValue(cy.NAME),
                                                r.getValue(cy.IMAGE_URL),
                                                r.getValue(cy.PARENT_ID),
                                                r.getValue(cy.CORP_ID)
                                        );
                                        product.setCategory(category);
                                    }

                                    return product;
                                })
                                .collectList(),
                        Mono.from(countSql)
                                .map(Record1::value1)
                )
                .map(it -> new PageImpl<>(it.getT1(), pageRequest, it.getT2()));

    }
    public Flux<Product> findProductByCorpId(Long corpId,String name) {
        com.agri.mis.db.tables.Product pt =  com.agri.mis.db.tables.Product.PRODUCT;

        com.agri.mis.db.tables.Category cy = com.agri.mis.db.tables.Category.CATEGORY;
        Condition where = DSL.trueCondition();
        if(StringUtils.hasLength(name)){
            where = where.and(pt.NAME.like("%" + name +"%"));
        }
        var dataSql = dslContext.select(
                pt.ID,
                pt.NAME,
                pt.CODE,
                pt.CATEGORY_ID,
                pt.IMAGE_URL,
                pt.CALC_UNIT,
                pt.CORP_ID,
                pt.CREATED_AT,
                pt.CREATED_BY,
                pt.UPDATED_AT,
                pt.UPDATED_BY,
                pt.DESCRIPTION,

                cy.ID,
                cy.PATH_NAME,
                cy.NAME,
                cy.IMAGE_URL,
                cy.PARENT_ID,
                cy.CORP_ID

        ).from(pt).leftJoin(cy).on(pt.CATEGORY_ID.eq(cy.ID)).where(pt.CORP_ID.eq(corpId)).and(where);
        return Flux.from(dataSql).map(r -> {
            Product product = new Product(
                    r.getValue(pt.ID),
                    r.getValue(pt.NAME),
                    r.getValue(pt.CODE),
                    r.getValue(pt.CATEGORY_ID),
                    r.getValue(pt.IMAGE_URL),
                    r.getValue(pt.CALC_UNIT),
                    r.getValue(pt.CORP_ID),
                    r.getValue(pt.CREATED_AT),
                    r.getValue(pt.CREATED_BY),
                    r.getValue(pt.UPDATED_AT),
                    r.getValue(pt.UPDATED_BY),
                    r.getValue(pt.DESCRIPTION),
                    null
            );

            //Address convert from
            if(null != product.getCategoryId()) {
                Category category = new Category(
                        r.getValue(cy.ID),
                        r.getValue(cy.PATH_NAME),
                        r.getValue(cy.NAME),
                        r.getValue(cy.IMAGE_URL),
                        r.getValue(cy.PARENT_ID),
                        r.getValue(cy.CORP_ID)
                );
                product.setCategory(category);
            }
            return product;
        });
    }


    public Mono<Product> findProductById(Long productId) {
        com.agri.mis.db.tables.Product pt = com.agri.mis.db.tables.Product.PRODUCT;

        com.agri.mis.db.tables.Category cy = com.agri.mis.db.tables.Category.CATEGORY;
        var dataSql = dslContext.select(
                pt.ID,
                pt.NAME,
                pt.CODE,
                pt.CATEGORY_ID,
                pt.IMAGE_URL,
                pt.CALC_UNIT,
                pt.CORP_ID,
                pt.CREATED_AT,
                pt.CREATED_BY,
                pt.UPDATED_AT,
                pt.UPDATED_BY,
                pt.DESCRIPTION,

                cy.ID,
                cy.PATH_NAME,
                cy.NAME,
                cy.IMAGE_URL,
                cy.PARENT_ID,
                cy.CORP_ID

        ).from(pt).leftJoin(cy).on(pt.CATEGORY_ID.eq(cy.ID)).where(pt.ID.eq(productId));
        return Mono.from(dataSql).map(r -> {
            Product product = new Product(
                    r.getValue(pt.ID),
                    r.getValue(pt.NAME),
                    r.getValue(pt.CODE),
                    r.getValue(pt.CATEGORY_ID),
                    r.getValue(pt.IMAGE_URL),
                    r.getValue(pt.CALC_UNIT),
                    r.getValue(pt.CORP_ID),
                    r.getValue(pt.CREATED_AT),
                    r.getValue(pt.CREATED_BY),
                    r.getValue(pt.UPDATED_AT),
                    r.getValue(pt.UPDATED_BY),
                    r.getValue(pt.DESCRIPTION),
                    null
            );

            //Address convert from
            if(null != product.getCategoryId()) {
                Category category = new Category(
                        r.getValue(cy.ID),
                        r.getValue(cy.PATH_NAME),
                        r.getValue(cy.NAME),
                        r.getValue(cy.IMAGE_URL),
                        r.getValue(cy.PARENT_ID),
                        r.getValue(cy.CORP_ID)
                );
                product.setCategory(category);
            }

            return product;
        });
    }
}
