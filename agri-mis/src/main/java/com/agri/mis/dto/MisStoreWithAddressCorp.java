package com.agri.mis.dto;

import com.agri.mis.domain.Address;
import com.agri.mis.domain.Corp;
import com.agri.mis.domain.MisStore;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MisStoreWithAddressCorp {
    private MisStore misStore;
    private Address address;
    private Corp corp;
}
