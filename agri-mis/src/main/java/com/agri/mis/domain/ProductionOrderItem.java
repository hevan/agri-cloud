package com.agri.mis.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table("production_order_item")
public class ProductionOrderItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;
    private Long productId;
    private Double quantity;
    private BigDecimal price;
    private Long orderId;
    @CreatedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime createdAt;
    private Long corpId;
    private BigDecimal amount;
    private String productSku;
    private String description;

    @Transient
    private Product product;

}
