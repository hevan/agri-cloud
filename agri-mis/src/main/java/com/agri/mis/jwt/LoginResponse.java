package com.agri.mis.jwt;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoginResponse {
    private String token;
    private Long userId;
    private Long expiration;
}
