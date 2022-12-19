package com.agri.mis.dto;

import com.agri.mis.domain.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MisStockItemWithProductStoreStockCorp {
    private MisStockItem misStockItem;
    private Product product;
    private MisStock misStock;
    private MisStore misStore;
    private Corp corp;
}
