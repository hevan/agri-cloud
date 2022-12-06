package com.agri.mis.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResetPassword {
    private Long userId;
    private String oldPassword;
    private String newPassword;
}
