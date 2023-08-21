package com.agri.mis.domain;

import com.agri.mis.dto.BatchProductDto;
import com.agri.mis.dto.ParkBaseDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table("batch_base")
public class BatchBase {
    @Id
    private Long id;//主键ID
    private Long batchId;//分批处理ID
    private Long parkBaseId;
    private Double area;
    private Double quantity;
    private String description;
    @CreatedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime createdAt;

    private Long corpId;
    private String imageUrl;


    @Transient
    private ParkBaseDto parkBaseDto;

    @Transient
    private BatchProductDto batchProductDto;



}
