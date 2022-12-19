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
@Table("mis_stock_place_item_sub")
public class MisStockPlaceItemSub {
    @Id
    private Long id;
    private Long stockPlaceItemId;
    private BigDecimal quantity;
    private String orginCode;
    private String productCode;

}
