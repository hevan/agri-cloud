package com.agri.mis.dto;

import com.agri.mis.domain.MarkMarket;
import com.agri.mis.domain.MarkProductMarket;
import com.agri.mis.domain.Product;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MarkProductMarketWithProductWithMarket {
    private MarkProductMarket markProductMarket;
    private Product product;
    private MarkMarket markMarket;
}
