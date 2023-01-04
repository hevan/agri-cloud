package com.agri.mis.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table("batch_base")
public class BatchBase {
    @Id
    private Long id;//主键ID
    private Long batchId;//分批处理ID
    private Long parkBaseId;
    private Double area;

}
