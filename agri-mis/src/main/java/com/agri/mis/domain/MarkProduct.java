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
@Table("mark_product")
public class MarkProduct {

    @Id
    private Long id;//主键id
    private String name;//产品名称
    private String code;//唯一标识码
    private Long categoryId;//种类ID
    private String imageUrl;//图片地址
    private String calcUnit;//计算单位
    private String description;//类型
}
