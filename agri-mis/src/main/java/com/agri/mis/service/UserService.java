package com.agri.mis.service;

import com.agri.mis.domain.User;
import com.agri.mis.repository.UserRepository;
import com.agri.mis.util.AESUtil;
import com.agri.mis.util.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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


    public Mono<User> findByMobile( String mobile){
        return userRepository.findByMobile(mobile);
    }

    public Mono<User> findById(Long id) {
      return userRepository.findById(id);
    }

    @Transactional
    public Mono<User> add(User user) {

        user.setUsername(UUID.randomUUID().toString());

        if(!StringUtils.hasLength(user.getPassword())){
            user.setPassword("123456");
        }

        if(!StringUtils.hasLength(user.getNickName())){
            user.setNickName("用户" + user.getMobile().substring(7));
        }

        user.setSignText(AESUtil.AESEncode("agri", user.getPassword() ));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setCreatedAt(LocalDateTime.now());
        user.setEnabled(true);

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


    public Mono<Page<User>> pageQueryByExample(String nickName, String mobile, PageRequest pageRequest){

        User user = new User();
        user.setMobile(mobile);
        user.setNickName(nickName);
        ExampleMatcher exampleObjectMatcher = ExampleMatcher.matching()
                .withMatcher("nickName", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("mobile", ExampleMatcher.GenericPropertyMatchers.contains());

        /*
        List<Criteria> listWeres = new ArrayList<Criteria>();

        if(StringUtils.hasLength(nickName)){
            listWeres.add(where("nick_name").like("%" + nickName + "%"));
        }
        if(StringUtils.hasLength(nickName)){
            listWeres.add(where("mobile").like("%" + mobile + "%"));
        }
        Query queryA = null;
        if(listWeres.size() > 0){
            queryA = Query.query(Criteria.from(listWeres)).offset((pageRequest.getPageNumber() - 1) * pageRequest.getPageSize()).limit(pageRequest.getPageSize()) ;

        }else{
            queryA =  Query.empty().offset((pageRequest.getPageNumber() - 1) * pageRequest.getPageSize()).limit(pageRequest.getPageSize()) ;
        }

         */

        return this.userRepository.findAllBy(Example.of(user, exampleObjectMatcher), pageRequest).collectList()
                .zipWith(this.userRepository.count(Example.of(user, exampleObjectMatcher)))
                .map(t -> new PageImpl<>(t.getT1(), pageRequest, t.getT2()));


    }
}
