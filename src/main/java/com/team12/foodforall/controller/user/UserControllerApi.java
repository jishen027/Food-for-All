package com.team12.foodforall.controller.user;

import com.team12.foodforall.domain.User;
import com.team12.foodforall.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
        User savedUser = userService.createUser(user);
        return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
    }
}
