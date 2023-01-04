package com.agri.mis.domain;

<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.annotation.Id;
=======

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
>>>>>>> origin/master
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
<<<<<<< HEAD
import java.time.OffsetDateTime;

=======
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
>>>>>>> origin/master
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table("batch_cycle")
public class BatchCycle {

    @Id
    private Long id;
    private String name;
    private String description;
    private String imageUrl;
    private Integer days;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate startAt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate endAt;
<<<<<<< HEAD
=======


>>>>>>> origin/master
    private Long batchId;
    private Short status;
    private Long parentId;
    private Double progress;
    private Long createdUserId;
    private String createdBy;

<<<<<<< HEAD
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private OffsetDateTime createdAt;
    private Short cycleType;
=======

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDateTime createdAt;

    private Short cycleType;

    @Transient
    private BatchProduct batchProduct;

>>>>>>> origin/master
}
