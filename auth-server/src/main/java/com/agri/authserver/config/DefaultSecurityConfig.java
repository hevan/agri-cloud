package com.agri.authserver.config;

import com.agri.authserver.service.CustomAuthenticationProvider;
import com.agri.authserver.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static org.springframework.security.config.Customizer.withDefaults;

@EnableWebSecurity
public class DefaultSecurityConfig {

    private static final Logger LOGGER = LogManager.getLogger(DefaultSecurityConfig.class);


    @Autowired
    private CustomAuthenticationProvider authenticationProvider;

    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    // @formatter:off
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests.antMatchers("/v2/open/**").permitAll().anyRequest().authenticated()
                )
                .formLogin(withDefaults());
        return http.build();
    }
    // @formatter:on

    /*
    // @formatter:off
    @Bean
    UserDetailsService users() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user1")
                .password("password")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }
     */


    @Autowired
    protected void whateverMethodName(AuthenticationManagerBuilder builder) throws Exception {
        LOGGER.debug("in configureGlobal");
        builder.authenticationProvider(authenticationProvider);

    }
}
