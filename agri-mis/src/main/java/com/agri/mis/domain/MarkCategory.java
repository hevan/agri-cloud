package com.agri.mis.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table("mark_category")
public class MarkCategory {

    @Id
    private Long id;//id
    private String name;//名称
    private String imageUrl;//图片地址
    private Long parentId;//父类id
}
