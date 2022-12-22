package com.agri.mis.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

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
@Table("mark_product_risk")
public class MarkProductRisk {

    private String cycleName;//周期名称
    private String riskCategory;//风险种类
    private String description;//类型
    private String solution;//解决办法
    private BigDecimal feeAmount;//费用数目
    private String name;//名称
    @Id
    private Long id;//主键ID
    private Long productBatchId;//产品一批ID
}
