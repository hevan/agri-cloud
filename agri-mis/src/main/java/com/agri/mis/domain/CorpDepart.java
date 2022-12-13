package com.agri.mis.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table("corp_depart")
public class CorpDepart {

    @Id
    private Long id;
    private String name;
    private Long corpId;

}
