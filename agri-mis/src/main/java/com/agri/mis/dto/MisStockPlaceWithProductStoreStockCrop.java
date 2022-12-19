package com.agri.mis.dto;

import com.agri.mis.domain.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MisStockPlaceWithProductStoreStockCrop {
    private MisStockPlace misStockPlace;
    private Product product;
    private MisStock misStock;
    private MisStore misStore;
    private Corp corp;
}
