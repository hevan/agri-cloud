package com.agri.mis.dto;

import com.agri.mis.domain.MisStockPlaceItem;
import com.agri.mis.domain.MisStockPlaceItemSub;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MisStockPlaceItemSubWithStockPlaceItem {
    private MisStockPlaceItemSub misStockPlaceItemSub;
    private MisStockPlaceItem misStockPlaceItem;
}
