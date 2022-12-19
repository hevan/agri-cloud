package com.agri.mis.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table("corp_manager_depart")
public class CorpManagerDepart {

    @Id
    private Long id;
    private Long managerId;
    private Long departId;
}
