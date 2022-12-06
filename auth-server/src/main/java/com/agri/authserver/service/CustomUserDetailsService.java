package com.agri.authserver.service;

import com.agri.authserver.domain.User;
import com.agri.authserver.domain.UserPrincipal;
import com.agri.authserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserPrincipal loadUserByUsername(String username) throws UsernameNotFoundException {


        User principal = userRepository.findByUsername(username);

        System.out.println(principal.getPassword());

        if(null != principal) {
            UserPrincipal userPrincipal = new UserPrincipal(principal);

            return userPrincipal;
        }else throw new UsernameNotFoundException("用户不存在!");
    }



}
