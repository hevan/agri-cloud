package com.agri.mis.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TotalData {
    private Double quantity;
    private BigDecimal amount;
}
