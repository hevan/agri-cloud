package com.agri.mis.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

//简洁代码
@Data
//全部参数的构造方法
@AllArgsConstructor
//无参构造方法
@NoArgsConstructor
//返回参数数据
@Getter
//修改参数数据
@Setter
//对应数据库
@Table("mark_market")
public class MarkMarket {
    @Id
    private Long id;//id

    private String name;//名称

    private Long categoryId;//种类id

    private Long addressId;//详细地址id

}
