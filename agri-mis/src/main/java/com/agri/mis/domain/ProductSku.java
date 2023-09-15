package com.agri.mis.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table("product_sku")
public class ProductSku {
    @Id
    private Long id;
    private String name;
    private String code;
    private String imageUrl;
    private Long productId;
    private BigDecimal price;
    private BigDecimal originPrice;
}
