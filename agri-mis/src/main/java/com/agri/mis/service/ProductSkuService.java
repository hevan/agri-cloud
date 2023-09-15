package com.agri.mis.service;
;
import com.agri.mis.domain.ProductSku;
import com.agri.mis.repository.ProductSkuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductSkuService {

    @Autowired
    private ProductSkuRepository skuRepository;


    public Mono<ProductSku> findById(Long id) {
        return skuRepository.findById(id);
    }


    public Mono<ProductSku> add(ProductSku sku) {
        return skuRepository.save(sku);
    }

    public Mono<ProductSku> update(Long id, ProductSku sku) {
        return skuRepository.findById(id)
                .flatMap(s -> {
                    sku.setId(s.getId());
                    return skuRepository.save(sku);
                });
    }

    public Mono<Void> delete(ProductSku sku) {
        return skuRepository.delete(sku);
    }

    public Flux<ProductSku> findAllByProductId(Long productId) {
        return skuRepository.findAllByProductId(productId);
    }

}