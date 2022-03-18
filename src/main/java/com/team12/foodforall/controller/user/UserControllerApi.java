package com.team12.foodforall.controller.user;

import com.team12.foodforall.domain.LoginForm;
import com.team12.foodforall.domain.Response;
import com.team12.foodforall.domain.User;
import com.team12.foodforall.service.user.UserService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

/**
 * @author: Heng Gao
 * @date: 17/03/2022 :22:31
 **/
@RestController
@RequestMapping("/api/")
public class UserControllerApi {

    @Autowired
    private UserService userService;

    @PostMapping("users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User savedUser = userService.addUser(user);
        return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    @ResponseBody // 一般返回json
    public ResponseEntity<Response<String>> auth(@RequestBody LoginForm loginForm) {
        val form = Optional.ofNullable(loginForm)
                .orElseThrow(() -> new RuntimeException("body cannot be null"));

        if ("gh".equals(form.getUsername()) && "1233".equals(form.getPassword())) {
            return ResponseEntity.ok(Response.<String>builder().code(HttpStatus.OK.value()).data("succ").build());
        }

        // TODO：改成统一处理
//        return ResponseEntity.ok("200"); //spring 会检测并设置成text
        return ResponseEntity.status(401).body(Response.<String>builder().code(HttpStatus.UNAUTHORIZED.value()).data("invalid password").build());
    }
}
