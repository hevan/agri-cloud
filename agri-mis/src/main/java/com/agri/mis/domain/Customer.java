package com.agri.mis.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table("customer")
public class Customer {

    @Id
    private Long id;
    private String name;
    private String code;
    private String description;
    private Long addressId;
    private Long corpId;
    private Boolean isCustomer;
    private Boolean isSupply;
    private LocalDateTime createdAt;

    @Transient
    private Address address;
}
