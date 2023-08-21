package com.agri.mis.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BatchProductDto {
    private Long batchId;
    private String batchName;
    private Long productId;
    private String productName;
}
