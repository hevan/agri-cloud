package com.agri.mis.controller.secure;


import com.agri.mis.domain.User;
import com.agri.mis.dto.ResetPassword;
import com.agri.mis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/secure/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public Mono<ResponseEntity<User>> find(@PathVariable long id) {
        return userService.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/pageQuery")
    public Mono<Page<User>> pageQuery(@RequestParam("nickName") String nickName, @RequestParam("mobile") String mobile, @RequestParam("page") int page, @RequestParam("size") int size) {
        return userService.pageQuery(nickName,mobile, PageRequest.of(page, size));
    }

    @PutMapping("/changePassword")
    public Mono<ResponseEntity<User>> changePassword(@RequestBody ResetPassword resetPassword) {
        return userService.changePassword(resetPassword.getUserId(), resetPassword.getOldPassword(), resetPassword.getNewPassword()).map(ResponseEntity::ok);
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<User>> update(@PathVariable Long id, @RequestBody User user) {
        return userService.update(id, user).map(ResponseEntity::ok);
    }

    @PostMapping("")
    public Mono<User> add( @RequestBody User user) {
        return userService.add(user);
    }
}
