package com.agri.mis.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table("corp_park")
public class CorpPark {

    @Id
    private Long id;
    private String name;
    private String description;
    private String imageUrl;
    private Long addressId;
    private Long corpId;
    private Double area;
    private Double areaUse;
    private LocalDate createdAt;
}
