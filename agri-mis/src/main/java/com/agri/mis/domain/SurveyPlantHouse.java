package com.agri.mis.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table("survey_plant_house")
public class SurveyPlantHouse implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Long id;
    private String county;
    private String town;
    private String village;
    private String owner;
    private Double latitude;
    private Double longitude;
    private Integer quantity;
    private Double area;
    private String purpose;
    private String category;
    private String description;
    private String irrigateType;

    @CreatedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime createdAt;
}
