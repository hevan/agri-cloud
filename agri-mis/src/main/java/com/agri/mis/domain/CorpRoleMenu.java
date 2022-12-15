package com.agri.mis.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table("corp_role_menu")
public class CorpRoleMenu {

    @Id
    private Long id;
    private Long roleId;
    private Long menuId;
    private String actions;
}
