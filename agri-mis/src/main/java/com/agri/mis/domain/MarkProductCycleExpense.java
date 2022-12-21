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
@Table("mark_product_cycle_expense")
public class MarkProductCycleExpense {

    private Long cycleId;
    private String investProductName;
    private String description;
    private BigDecimal amount;
    private BigDecimal price;
    private Double quantity;
    private Long productBatchId;

    @Id
    private Long id;
    private String calcUnit;
    private String expenseType;
}
