package com.agri.mis.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table("batch_cycle_expense_item")
public class BatchCycleExpenseItem {

    @Id
    private Long id;
    private Long expenseId;
    private Long productId;
    private String productSku;
    private String description;
    private BigDecimal amount;
    private BigDecimal price;
    private Double quantity;
    private LocalDateTime createdAt;

    @Transient
    private Product product;
}
