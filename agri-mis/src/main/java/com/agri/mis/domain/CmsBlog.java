package com.agri.mis.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table("cms_blog")
public class CmsBlog {

    @Id
    private Long id;
    private String title;
    private Short status;
    private Short checkStatus;
    private String author;
    private Integer priseUp;
    private Integer priseDown;
    private Long categoryId;
    private LocalDateTime createdAt;
    private String createdBy;
    private String tags;
    private String description;
    private Long createdUserId;
    private String content;
    private LocalDate publishAt;
    private String imageUrl;
    private String videoUrl;
}
