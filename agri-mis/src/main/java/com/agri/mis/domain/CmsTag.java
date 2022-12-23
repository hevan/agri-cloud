package com.agri.mis.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table("cms_tag")
public class CmsTag {

    @Id
    private Long id;
    private String name;

}
