package com.agri.mis.dto;


import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParkBaseDto {
    private Long parkId;
    private String parkName;
    private Long parkBaseId;
    private String parkBaseName;
}
