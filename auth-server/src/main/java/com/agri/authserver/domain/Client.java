package com.agri.authserver.domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;


@Entity
@Table(name = "oauth2_registered_client")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client implements Serializable {

    @Id
    private String id;
    private String clientId;
    private Instant clientIdIssuedAt;
    private String clientSecret;
    private Instant clientSecretExpiresAt;
    private String clientName;
    @Column(length = 1000)
    private String clientAuthenticationMethods;
    @Column(length = 1000)
    private String authorizationGrantTypes;
    @Column(length = 1000)
    private String redirectUris;
    @Column(length = 2000)
    private String scopes;
    @Column(length = 2000)
    private String clientSettings;
    @Column(length = 2000)
    private String tokenSettings;

}
