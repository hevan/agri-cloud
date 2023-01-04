package com.agri.mis.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.annotation.Id;
<<<<<<< HEAD
=======
import org.springframework.data.annotation.Transient;
>>>>>>> origin/master
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
    private Double productionEstimated;
    private Double productionReal;
    private BigDecimal investEstimated;
    private BigDecimal investReal;
    private Long corpId;
    private String calcUnit;
    private Long parkId;
    private Long createdUserId;
    private String createdBy;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDateTime createdAt;
    private String description;
    private Double quantity;
    private Integer status;
<<<<<<< HEAD
=======

    @Transient
    private Corp corp;
>>>>>>> origin/master
}
