package com.agri.mis.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table("mis_store")
public class MisStore {
    @Id
    private Long id;
    private String name;
    private String code;
    private String description;
    private Long addressId;
    private String category;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDateTime createdAt;

    private Long corpId;
}
