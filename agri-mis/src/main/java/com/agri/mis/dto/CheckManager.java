package com.agri.mis.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CheckManager {
    Long userId;
    String nickName;
    String headerUrl;
    String mobile;
    int status = 0;
}
