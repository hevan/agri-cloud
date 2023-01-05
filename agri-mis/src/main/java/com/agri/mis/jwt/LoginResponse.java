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
    private String nickName;
    private String mobile;
    private String headerUrl;
    private Long expiration;
}
