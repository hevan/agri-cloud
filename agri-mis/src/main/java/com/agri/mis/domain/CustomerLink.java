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
@Table("customer_link")
public class CustomerLink {

    @Id
    private Long id;
    private Long customerId;
    private String linkName;
    private String linkMobile;
    private LocalDateTime createdAt;
    private String position;
    private String description;
}
