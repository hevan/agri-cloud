package com.agri.mis.config;

import com.agri.mis.domain.UserPrincipal;
import com.agri.mis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import reactor.core.publisher.Mono;

@EnableReactiveMethodSecurity
public class UserDetailsServiceConfig {


    @Autowired
    private UserRepository userRepository;

    @Bean
    public ReactiveUserDetailsService userDetailsService(){
       return (username -> {
           return userRepository.findByUsername(username).flatMap(s->{
               UserPrincipal userPrincipal = new UserPrincipal(s);
               return Mono.just(userPrincipal);
           });
       });
    }
}
