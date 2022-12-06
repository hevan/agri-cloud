package com.agri.authserver.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.function.Supplier;

@Entity(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String mobile;

    private Boolean enabled = true;

    private String signText;

    private Long corpId;

    private LocalDateTime createdDate;

}
