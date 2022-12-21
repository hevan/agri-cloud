package com.agri.mis.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table("mark_market")
public class MarkMarket {
    @Id
    private Long id;//id

    private String name;//名称

    private Long categoryId;//种类id

    private Long addressId;//详细地址id

}
