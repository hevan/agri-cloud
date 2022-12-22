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
@Table("mark_product_cycle_expense")
public class MarkProductCycleExpense {

    private Long cycleId;//周期ID
    private String investProductName;//投资产品名称
    private String description;//类型
    private BigDecimal amount;//数量
    private BigDecimal price;//价格
    private Double quantity;//数目
    private Long productBatchId;//产品一批ID

    @Id
    private Long id;//主键ID
    private String calcUnit;//计算单位
    private String expenseType;//费用类型
}
