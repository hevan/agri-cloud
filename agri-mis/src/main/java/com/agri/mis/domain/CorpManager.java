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
@Table("corp_manager")
public class CorpManager {

    @Id
    private Long id;
    private Long userId;
    private Long corpId;
    private LocalDateTime createdAt;
    private String position;



}

