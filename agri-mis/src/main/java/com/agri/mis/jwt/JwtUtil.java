package com.agri.mis.jwt;

import com.agri.mis.domain.UserPrincipal;
import jakarta.xml.bind.DatatypeConverter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import java.util.*;

@Slf4j
@Component
@NoArgsConstructor
public class JwtUtil {
    // create random set of bit for secret
    @Value("${jjwt.secret}")
    private String secret;

    @Value("${jjwt.expiration}")
    private String expirationTime;

    public Claims getAllClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(secret))
                .parseClaimsJws(token).getBody();
    }

    public String getUsernameFromToken(String token) {
        return getAllClaimsFromToken(token).getSubject();
    }

    public Date getExpirationDateFromToken(String token) {
        return getAllClaimsFromToken(token).getExpiration();
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    public LoginResponse generateToken(UserPrincipal user) {
        Long expirationTimeLong = Long.parseLong(expirationTime); //in second

        final Date createdDate = new Date();
        final Date expirationDate = new Date(createdDate.getTime() + expirationTimeLong * 1000);

        Map<String, Object> claims = new HashMap<>();
        claims.put("role", user.getRoles());
        claims.put("userId", user.getId());
        claims.put("username", user.getUsername());
        claims.put("mobile", user.getMobile());
        claims.put("nickName", user.getNickName());
        claims.put("headerUrl", user.getHeaderUrl());
        String token =  doGenerateToken(claims, user.getUsername(),createdDate, expirationDate);

        return new LoginResponse(token, user.getId(), createdDate.getTime() + expirationTimeLong * 1000);
    }

    private String doGenerateToken(Map<String, Object> claims, String username, Date createdDate, Date expirationDate) {

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(createdDate)
                .setExpiration(expirationDate)
                .signWith(new SecretKeySpec(DatatypeConverter.parseBase64Binary(secret), SignatureAlgorithm.HS256.getJcaName()))
                .compact();
    }

    public Boolean validateToken(String token) {
        return !isTokenExpired(token);
    }
}
