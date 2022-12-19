package com.agri.mis.dto;

import com.agri.mis.domain.Corp;
import com.agri.mis.domain.MisStock;
import com.agri.mis.domain.MisStore;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MisStockWithStoreCorp {

    private MisStock misStock;
    private MisStore misStore;
    private Corp corp;
}
