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
@Table("batch_cycle_expense")
public class BatchCycleExpense {

    @Id
    private Long id;
    private String cycleName;
    private String name;
    private String code;
    private String expenseType;
    private BigDecimal amount;
    private String description;
    private Long corpId;
    private Long batchId;
    private Integer checkStatus;
    private Integer status;
    private LocalDateTime createdAt;
    private Long createdUserId;

    @Transient
    private BatchProduct batchProduct;

    @Transient
    private User createdUser;
}
