package com.agri.mis.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
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
@Table("mark_product_market")
public class MarkProductMarket {


    private Long productId;//产品ID
    private BigDecimal priceWholesale;//批发价格
    private String unit;//单位
    @Id
    private Long id;//主键ID

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate occurAt;//工作日期

    private BigDecimal priceRetal;//价格标签
    private Long marketId;//集市ID
}
