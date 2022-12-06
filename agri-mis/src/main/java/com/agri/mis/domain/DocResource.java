package com.agri.mis.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("doc_resource")
public class DocResource {
    @Id
    private Long id;
    private String name;
    private String docType;//大的文档类型
    private String docExt;//详细的文档
    private String docUrl;
    private String showImage;
    private String category;//业务
    private Long entityId;
    private String entityName;
    private Long corpId;
    private Long userId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDateTime createdAt;
}
