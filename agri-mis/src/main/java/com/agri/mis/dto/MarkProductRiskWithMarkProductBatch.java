package com.agri.mis.dto;

import com.agri.mis.domain.MarkProductBatch;
import com.agri.mis.domain.MarkProductRisk;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MarkProductRiskWithMarkProductBatch {
    private MarkProductRisk markProductRisk;
    private MarkProductBatch markProductBatch;
}
