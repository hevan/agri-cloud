package com.agri.mis.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TotalSum {
    private BigDecimal quantity;
    private BigDecimal amount;
}
