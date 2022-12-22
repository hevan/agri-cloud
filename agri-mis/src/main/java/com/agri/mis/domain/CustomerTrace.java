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
@Table("customer_trace")
public class CustomerTrace {

    @Id
    private Long id;
    private Long customerId;
    private String description;
    private String title;
    private String linkName;
    private String linkMobile;
    private Long createdBy;
    private LocalDateTime createdAt;
    private Long corpId;
    private LocalDateTime occurAt;
    private Long createdUserId;
}
