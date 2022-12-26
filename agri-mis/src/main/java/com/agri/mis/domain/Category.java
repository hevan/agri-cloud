package com.agri.mis.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table("category")
public class Category {

    @Id
    private Long id;
    private String pathName;
    private String name;
    private String imageUrl;
    private Long parentId;
    private Long corpId;
}
