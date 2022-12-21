package com.agri.mis.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table("mark_product")
public class MarkProduct {

    @Id
    private Long id;
    private String name;
    private String code;
    private Long categoryId;
    private String imageUrl;
    private String calcUnit;
    private String description;
}
