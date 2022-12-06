package com.agri.mis.service;

import com.agri.mis.domain.User;
import com.agri.mis.repository.UserRepository;
import com.agri.mis.util.AESUtil;
import com.agri.mis.util.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.UUID;


@Service
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;


    public UserService() {
    }

    public Mono<User> findByUsername( String username){
        return userRepository.findByUsername(username);
    }

    public Mono<User> findByMobile( String mobile){
        return userRepository.findByMobile(mobile);
    }

    public Mono<User> findById(Long id) {
      return userRepository.findById(id);
    }

    public Mono<User> add(User user) {

        user.setUsername(UUID.randomUUID().toString());

        if(!StringUtils.hasLength(user.getPassword())){
            user.setPassword("123456");
        }

        user.setSignText(AESUtil.AESEncode("agri", user.getPassword() ));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setCreatedDate(LocalDateTime.now());

        return userRepository.findByMobile(user.getMobile()).flatMap(exists -> (null == exists) ? Mono.error(new RuntimeException("用户已经存在")) : userRepository.save(user));
    }

    public Mono<User> update(Long id, User user) {
        return userRepository.findById(id)
                .flatMap(s -> {
                    s.setNickName(user.getNickName());
                    s.setHeaderUrl(user.getHeaderUrl());
                    s.setEnabled(user.getEnabled());
                    s.setDescription(user.getDescription());
                    return userRepository.save(s);
                });
    }

    public Mono<User> changePassword(Long id, String oldPassword, String newPassword) {
        return userRepository.findById(id)
                .flatMap(s -> {
                    String signText = AESUtil.AESEncode("agri", oldPassword);
                    if(signText.equals(s.getSignText())){
                        s.setSignText(AESUtil.AESEncode("agri", newPassword));
                        s.setPassword(passwordEncoder.encode(newPassword));
                        return userRepository.save(s);
                    }else{
                        return Mono.error(new CustomException(1500,"账号密码错误"));
                    }
                });
    }

    public Mono<Void> delete(User user) {
        return userRepository.delete(user);
    }


    public Mono<Page<User>> pageQuery(String nickName,String mobile, PageRequest pageRequest){
        if(StringUtils.hasLength(nickName)){
            return this.userRepository.findAllByNickNameLike(nickName, pageRequest)
                    .collectList()
                    .zipWith(this.userRepository.countAllByNickNameLike(nickName))
                    .map(t -> new PageImpl<>(t.getT1(), pageRequest, t.getT2()));
        }else if(StringUtils.hasLength(mobile)){
            return this.userRepository.findAllByMobileLike(mobile, pageRequest)
                    .collectList()
                    .zipWith(this.userRepository.countAllByMobileLike(mobile))
                    .map(t -> new PageImpl<>(t.getT1(), pageRequest, t.getT2()));
        }else{
            return this.userRepository.findAllBy(pageRequest)
                    .collectList()
                    .zipWith(this.userRepository.count())
                    .map(t -> new PageImpl<>(t.getT1(), pageRequest, t.getT2()));
        }

    }
}
