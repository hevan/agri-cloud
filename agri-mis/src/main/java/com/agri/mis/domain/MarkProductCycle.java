package com.agri.mis.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

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
@Table("mark_product_cycle")
public class MarkProductCycle {

    @Id
    private Long id;//主键id
    private String name;//名称
    private String description;//类型
    private String imageUrl;//图片地址
    private Long productBatchId;//一批ID
    private Integer days;//日期
    private BigDecimal amount;//数量
    private Long parentId;//父ID

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate startAt;//开始时间

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate endAt;//结束时间
}
