package com.agri.mis.dto;

import com.agri.mis.domain.MisStockPlace;
import com.agri.mis.domain.MisStockPlaceItem;
import com.agri.mis.domain.Product;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MisStockPlaceItemWithStockPlaceProduct {
    private MisStockPlaceItem misStockPlaceItem;
    private MisStockPlace misStockPlace;
    private Product product;
}
