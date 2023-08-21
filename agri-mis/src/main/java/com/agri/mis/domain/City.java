package com.agri.mis.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table("city")
public class City implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;
    private String code;
    private String name;
    private Long parentId;
    private Double latitude;
    private Double longitude;
}
