package com.agri.mis.config;

import com.agri.mis.domain.UserPrincipal;
import com.agri.mis.jwt.JwtUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Slf4j
@Component
public class AuthenticationManager implements ReactiveAuthenticationManager {

    @Autowired
    private JwtUtil jwtUtil;
    @Override
    @SuppressWarnings("unchecked")
    public Mono<Authentication> authenticate(Authentication authentication) {
        String authToken = authentication.getCredentials().toString();
        log.info(authToken);

        String username;
        try {
            username = jwtUtil.getUsernameFromToken(authToken);
        } catch (Exception e) {
            username = null;
        }
        if (username != null && jwtUtil.validateToken(authToken)) {
            Claims claims = jwtUtil.getAllClaimsFromToken(authToken);
            List<String> rolesMap = claims.get("role", List.class);
            List<String> roles = new ArrayList<>();
            for (String rolemap : rolesMap) {
                roles.add(rolemap);
            }

            UserPrincipal userPrincipal = new UserPrincipal();
            userPrincipal.setId(claims.get("userId", Long.class));
            userPrincipal.setUsername(claims.get("username", String.class));
            userPrincipal.setMobile(claims.get("mobile", String.class));
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                    userPrincipal,
                    null,
                    roles.stream().map(authority -> new SimpleGrantedAuthority(authority)).collect(Collectors.toList())
            );
            return Mono.just(auth);
        } else {
            return Mono.empty();
        }
    }
}
