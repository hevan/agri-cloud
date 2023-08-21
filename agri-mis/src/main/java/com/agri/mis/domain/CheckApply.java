package com.agri.mis.domain;

import com.agri.mis.dto.CheckManager;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table("check_apply")
public class CheckApply {

    @Id
    private Long id;
    private String entityName;
    private Long entityId;
    private Long userId;
    private Integer status;
    private Long corpId;

    @CreatedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime updatedAt;

    private String title;
    private String description;

    private String checkUsers;

    @Transient
    private User createdUser;

    @Transient
    private List<CheckManager> listCheckManager;


    public List<CheckManager> convertCheck(){
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            List<CheckManager> myObjects = objectMapper.readValue(this.checkUsers, new TypeReference<List<CheckManager>>(){});
            return myObjects;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
