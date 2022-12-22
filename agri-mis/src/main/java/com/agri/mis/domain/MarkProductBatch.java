package com.agri.mis.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
@Table("mark_product_batch")
public class MarkProductBatch {

    @Id
    private Long id;//主键ID
    private String name;//一批名称
    private String code;//一批标识码
    private Long productId;//产品

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate startAt;//开始时间

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate endAt;//结束时间
    private Integer days;//日期
    private Integer createdType;//创建类型
    private Double production;//产量
    private BigDecimal invest;//投资
    private BigDecimal salePrice;//售价
    private String unit;//单位

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDateTime createdAt;//创建时间
    private String createdBy;//创建经过
    private Long createdUserId;//创建用户
    private String description;//类型
    private Integer status;//状态


}
