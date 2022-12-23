package com.agri.mis.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table("cms_resource")
public class CmsResource {

    @Id
    private Long id;
    private String name;
    private String docType;
    private String docUrl;
    private Long blogId;
    private LocalDateTime createdAt;
    private Long createdBy;
    private Long createdUserId;
    private String docExt;
}
