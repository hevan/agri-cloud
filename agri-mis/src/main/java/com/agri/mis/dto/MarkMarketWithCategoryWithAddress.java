package com.agri.mis.dto;

import com.agri.mis.domain.Address;
import com.agri.mis.domain.MarkCategory;
import com.agri.mis.domain.MarkMarket;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MarkMarketWithCategoryWithAddress {
    private MarkMarket markMarket;

    private MarkCategory category;

    private Address address;

}
