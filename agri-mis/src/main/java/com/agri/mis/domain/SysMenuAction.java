package com.agri.mis.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table("sys_menu_action")
public class SysMenuAction {
    private Long id;
    private Long menuId;
    private String name;
    private String code;
}
