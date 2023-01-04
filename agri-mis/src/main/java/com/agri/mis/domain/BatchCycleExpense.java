package com.agri.mis.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table("batch_cycle_expense")
public class BatchCycleExpense {

    @Id
    private Long id;
    private Long batchCycleId;
    private Long investProductId;
    private String investProductName;
    private String description;
    private BigDecimal investAmount;
    private BigDecimal investPrice;
    private Double investQuantity;
    private Long corpId;
    private Long batchId;
    private Short expenseType;

    @Transient
    private BatchCycle batchCycle;
    @Transient
    private Corp corp;
    @Transient
    private BatchProduct batchProduct;

}
