package com.agri.mis.dto;

import com.agri.mis.domain.MarkProductBatch;
import com.agri.mis.domain.Product;
import com.agri.mis.domain.User;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MarkProductBatchWithProductWithCreatedUser {

   private MarkProductBatch markProductBatch;
   private Product product;
   private User user;
}
