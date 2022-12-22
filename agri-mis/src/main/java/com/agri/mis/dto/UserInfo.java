package com.agri.mis.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    private Long id;
    private String nickName;
    private String mobile;
    private String headerUrl;
    private String description;
}
