package com.agri.mis.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table("cms_category")
public class CmsCategory {
    @Id
    private Long id;
    private String code;
    private String name;
    private Long parentId;

    private Long corpId;
}
