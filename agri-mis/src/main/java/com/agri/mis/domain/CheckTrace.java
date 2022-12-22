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
@Table("check_trace")
public class CheckTrace {

    @Id
    private Long id;
    private String entityName;
    private Long entityId;
    private Long userId;
    private Integer status;
    private Long corpId;
    private LocalDateTime createdAt;
    private String title;
    private String description;
}
