package com.agri.mis.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

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
    private Long categoryId;
    private String categoryCode;
    private String categoryName;
    private String tags;
    private String description;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate publishAt;
    private String imageUrl;
    private String videoUrl;
    private Long corpId;

    private Long countView;
    private Long countRaiseUp;
    private Long countRaiseDown;
}
