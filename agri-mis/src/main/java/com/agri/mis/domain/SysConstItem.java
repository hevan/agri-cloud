package com.agri.mis.domain;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table("sys_const_item")
public class SysConstItem {
    @Id
    private Long id;
    private Long constId;
    private String name;
    private String code;
    private String data;

}
