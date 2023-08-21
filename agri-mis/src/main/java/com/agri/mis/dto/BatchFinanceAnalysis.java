package com.agri.mis.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BatchFinanceAnalysis {
    private Long batchId;
    private String batchName;
    private Long productId;
    private String productName;
    private BigDecimal area;
    private BigDecimal quantity;
    private BigDecimal estimatedTotal;
    private BigDecimal estimatedPrice;
    private BigDecimal estimatedAmount;
    private BigDecimal estimatedInvest;
    private BigDecimal realInvest;
    private BigDecimal realTotal;
    private BigDecimal realAmount;
}
