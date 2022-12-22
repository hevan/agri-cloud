package com.agri.mis.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CheckTraceInfo {
    private Long id;
    private String entityName;
    private Long entityId;
    private Long userId;
    private Integer status;
    private Long corpId;
    private LocalDateTime createdAt;
    private String title;
    private String description;
    private String nickName;
    private String mobile;
    private String headerUrl;
}
