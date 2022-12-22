package com.agri.mis.domain;

import com.agri.mis.dto.UserInfo;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table("check_temp")
public class CheckTemp {
    @Id
    private Long id;
    private String name;
    private Long corpId;

    @Transient
    private List<UserInfo> listUserInfo;
}
