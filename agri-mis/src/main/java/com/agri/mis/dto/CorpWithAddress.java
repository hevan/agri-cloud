package com.agri.mis.dto;

import com.agri.mis.domain.Address;
import com.agri.mis.domain.Corp;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CorpWithAddress {
    private Corp corp;
    private Address address;
}
