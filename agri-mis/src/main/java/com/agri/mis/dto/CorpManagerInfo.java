package com.agri.mis.dto;

import com.agri.mis.domain.CorpDepart;
import com.agri.mis.domain.CorpRole;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CorpManagerInfo {

    private Long corpId;
    private Long userId;
    private String position;
    private String nickName;
    private String mobile;

    private String headerUrl;

    private String description;

    List<CorpDepart> listCorpDepart;
    List<CorpRole> listCorpRole;
}
