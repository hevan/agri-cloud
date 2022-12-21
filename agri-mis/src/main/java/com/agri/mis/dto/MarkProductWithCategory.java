package com.agri.mis.dto;

import com.agri.mis.domain.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MarkProductWithCategory {
    private MarkProduct markProduct;
    private Category category;
}
