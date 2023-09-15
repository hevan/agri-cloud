package com.agri.mis.repository;


import com.agri.mis.domain.ProductSku;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;


public interface ProductSkuRepository extends ReactiveCrudRepository<ProductSku, Long> {
    Flux<ProductSku> findAllByProductId(Long productId);
}
