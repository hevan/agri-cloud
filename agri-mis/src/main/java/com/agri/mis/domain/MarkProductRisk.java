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
@Table("mark_product_risk")
public class MarkProductRisk {
    @Id
    private String cycleName;
    private String riskCategory;
    private String description;
    private String solution;
    private BigDecimal feeAmount;
    private String name;
    private Long id;
    private Long productBatchId;
}
