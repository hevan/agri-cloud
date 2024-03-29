package com.agri.mis.controller.open;

import com.agri.mis.domain.User;
import com.agri.mis.domain.UserPrincipal;
import com.agri.mis.jwt.JwtUtil;
import com.agri.mis.service.UserService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/open/user")
public class OpenUserController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Mono<ResponseEntity<?>> login(@RequestBody UserPrincipal request) {
        return userService.findByMobile(request.getMobile()).map((user) -> {
            if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {

                UserPrincipal userPrincipal = new UserPrincipal(user);

                return ResponseEntity.ok(jwtUtil.generateToken(userPrincipal));
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        }).defaultIfEmpty(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }

    @RequestMapping(value = "/loginByMobile", method = RequestMethod.POST)
    public Mono<ResponseEntity<?>> loginByMobile(@RequestBody UserPrincipal request) {
        return userService.findByMobile(request.getMobile()).map((user) -> {
            if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {

                UserPrincipal userPrincipal = new UserPrincipal(user);

                return ResponseEntity.ok(jwtUtil.generateToken(userPrincipal));
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        }).switchIfEmpty(userService.add(new User(request.getMobile())).map((newUser)->{
            if (passwordEncoder.matches(request.getPassword(), newUser.getPassword())) {

                UserPrincipal userPrincipal = new UserPrincipal(newUser);

                return ResponseEntity.ok(jwtUtil.generateToken(userPrincipal));
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        }));
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public Mono<User> add(@RequestBody User user) {
        return userService.add(user);
    }

    @RequestMapping(value = "/parser", method = RequestMethod.GET)
    public Mono<Map<String, Object>> parser(@RequestParam String jwt) {
       return Mono.just(jwtUtil.getAllClaimsFromToken(jwt));
    }

    @RequestMapping(value = "/pageQuery", method = RequestMethod.GET)
    public Mono<Page<User>> pageQueryByExample(@RequestParam("nickName") String nickName, @RequestParam("mobile") String mobile,  @RequestParam("page") int page, @RequestParam("size") int size) {
        return userService.pageQueryByExample(nickName,mobile, PageRequest.of(page, size));
    }
}
