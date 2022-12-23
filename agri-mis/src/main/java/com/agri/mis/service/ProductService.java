package com.agri.mis.service;

import com.agri.mis.domain.Product;
import com.agri.mis.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


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
}
