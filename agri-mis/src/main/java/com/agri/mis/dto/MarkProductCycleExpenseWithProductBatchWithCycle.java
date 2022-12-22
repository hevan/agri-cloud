package com.agri.mis.dto;

import com.agri.mis.domain.MarkProductBatch;
import com.agri.mis.domain.MarkProductCycle;
import com.agri.mis.domain.MarkProductCycleExpense;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MarkProductCycleExpenseWithProductBatchWithCycle {

    private MarkProductCycleExpense markProductCycleExpense;
    private MarkProductCycle markProductCycle;
    private MarkProductBatch markProductBatch;
}
