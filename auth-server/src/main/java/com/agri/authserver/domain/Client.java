package com.agri.authserver.domain;

import lombok.*;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;


@Entity(name = "oauth2_registered_client")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Client implements Serializable {

    @Id
    private UUID id;
    private String clientId;
    private LocalDateTime clientIdIssuedAt;
    private String clientSecret;
    private LocalDateTime clientSecretExpiresAt;
    private String clientName;
    private String clientAuthenticationMethods;
    private String authorizationGrantTypes;
    private String redirectUris;
    private String scopes;
    private String clientSettings;
    private String tokenSettings;

}
