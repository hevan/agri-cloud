package com.agri.mis.service;

import com.agri.mis.domain.Category;
import com.agri.mis.domain.Product;
import com.agri.mis.repository.ProductRepository;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
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
      return productRepository.findById(id);
    }


    public Mono<Product> add(Product Product) {
        return productRepository.save(Product);
    }

    public Mono<Product> update(Long id, Product Product) {
        return productRepository.findById(id)
                .flatMap(s -> {
                    Product.setId(s.getId());
                    return productRepository.save(Product);
                });
    }

    public Mono<Void> delete(Product Product) {
        return productRepository.delete(Product);
    }

    public Mono<Page<Product>> pageQueryByExample(Product product, PageRequest pageRequest){

        ExampleMatcher exampleObjectMatcher = ExampleMatcher.matching()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains());
        return this.productRepository.findBy(Example.of(product, exampleObjectMatcher), pageRequest).collectList()
                .zipWith(this.productRepository.count(Example.of(product, exampleObjectMatcher)))
                .map(t -> new PageImpl<>(t.getT1(), pageRequest, t.getT2()));
    }

    public Flux<Product> findProductByUserId(Long corpId,String name) {
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
}
