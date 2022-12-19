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
@Table("mis_stock_place_item")
public class MisStockPlaceItem {
    @Id
    private Long id;
    private Long stockPlaceId;
    private Long productId;
    private BigDecimal quantity;
    private String boxCode;
    private String productCode;

}
