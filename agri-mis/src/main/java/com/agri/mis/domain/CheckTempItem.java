package com.agri.mis.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table("check_temp_item")
public class CheckTempItem {
    @Id
    private Long id;
    private Long checkTempId;
    private Long userId;
}
