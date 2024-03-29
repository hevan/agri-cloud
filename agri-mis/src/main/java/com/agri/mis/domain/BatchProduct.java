package com.agri.mis.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table("batch_product")
public class BatchProduct {

    @Id
    private Long id;
    private String name;
    private String code;
    private Long productId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate startAt;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate endAt;
    private Integer days;
    private BigDecimal estimatedPrice;
    private Double quantity;
    private Double area;
    private Long corpId;
    private String calcUnit;
    private Long parkId;
    private Long createdUserId;

    @CreatedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime createdAt;
    private String description;
    private Integer status;

    @Transient
    private Corp corp;

    @Transient
    private Product product;

    @Transient
    private  CorpPark park;

    @Transient
    private List<BatchTeam> listTeam;
}
