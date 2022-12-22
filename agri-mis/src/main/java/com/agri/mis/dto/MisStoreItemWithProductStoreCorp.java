package com.agri.mis.dto;

import com.agri.mis.domain.Corp;
import com.agri.mis.domain.MisStore;
import com.agri.mis.domain.MisStoreItem;
import com.agri.mis.domain.Product;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MisStoreItemWithProductStoreCorp {
    private MisStoreItem  misStoreItem;
    private Product product;
    private MisStore misStore;
    private Corp corp;
}
