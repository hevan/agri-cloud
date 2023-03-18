package com.agri.mis.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table("sys_const")
public class SysConst {
    @Id
    private Long id;
    private String name;
    private String code;
    private String data;

    private Long corpId;

    @Transient
    private List<SysConstItem> listItem;
}
