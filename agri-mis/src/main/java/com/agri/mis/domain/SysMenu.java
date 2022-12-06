package com.agri.mis.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table("sys_menu")
public class SysMenu {
    @Id
    private Long id;

    private String name;

    private String path;

    private String iconUrl;

    private Long parentId;

    private Long corpId;

}
