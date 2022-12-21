package com.agri.mis.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table("mark_product_market")
public class MarkProductMarket {


    private Long productId;
    private BigDecimal priceWholesale;
    private String unit;
    @Id
    private Long id;
    private LocalDate occurAt;
    private BigDecimal priceRetal;
    private Long marketId;
}
