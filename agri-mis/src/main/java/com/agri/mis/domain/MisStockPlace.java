package com.agri.mis.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table("mis_stock_place")
public class MisStockPlace {
  // 主键ID
    @Id
    private Long id;
    private Long productId;
    private BigDecimal quantity;
    private String sku;
    private String storeItemCode;
    private String storePalletCode;
    private Integer direction;
    private Long storeId;
    private Long stockId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd ")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate occurAt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDateTime createdAt;

    private String createdBy;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDateTime updtedAt;

    private String updatedBy;
    private Long corpId;
    private Short status;

}
