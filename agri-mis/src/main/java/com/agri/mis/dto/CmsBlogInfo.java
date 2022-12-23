package com.agri.mis.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CmsBlogInfo {
    private Long id;
    private String title;
    private String author;
    private Integer priseUp;
    private Integer priseDown;
    private Long categoryId;
    private String categoryCode;
    private String categoryName;
    private String tags;
    private String description;
    private LocalDate publishAt;
    private String imageUrl;
    private String videoUrl;
}
