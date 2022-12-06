package com.agri.authserver.service;

import com.agri.authserver.domain.UserPrincipal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
public class CustomAuthenticationProvider implements AuthenticationProvider {

   final Logger logger = LoggerFactory.getLogger(CustomAuthenticationProvider.class);

    BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();

    @Autowired
        private CustomUserDetailsService userDetailsService;

        @Override
        public Authentication authenticate(Authentication authentication) throws AuthenticationException {
            String username = authentication.getName();
            String password = authentication.getCredentials().toString();

            logger.info("----user--name" + username);
            logger.info("----password" + password);


            UserPrincipal user = userDetailsService.loadUserByUsername(username);
            return checkPassword(user, password);
        }

        @Override
        public boolean supports(Class<?> aClass) {
            return UsernamePasswordAuthenticationToken.class.isAssignableFrom(aClass);
        }

        private Authentication checkPassword(UserPrincipal user, String rawPassword) {

           //String checkPassword = new BCryptPasswordEncoder().encode(rawPassword);
          // logger.info("check password" + checkPassword);
           // logger.info("password" + user.getPassword());
            if (bcryptPasswordEncoder.matches(rawPassword, user.getPassword())) {
                return new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), user.getAuthorities());
            } else {
               throw new BadCredentialsException("Bad credentials");
            }
        }
    }

