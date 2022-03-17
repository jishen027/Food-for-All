package com.team12.foodforall.controller;

import com.team12.foodforall.domain.LoginForm;
import com.team12.foodforall.domain.Response;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author: Heng Gao
 * @date: 08/03/2022 :17:06
 **/
@Controller
@RequestMapping("/")
@Validated
public class UserController {

    @GetMapping("/login")
    public String _login() {
        //TODO:

        return "login_backup";
    }

    @PostMapping("/login")
    @ResponseBody // 一般返回json
    public ResponseEntity<Response<String>> auth(@RequestBody LoginForm loginForm) {
        val form = Optional.ofNullable(loginForm)
                .orElseThrow(() -> new RuntimeException("body cannot be not"));

        if ("gh".equals(form.getUsername()) && "1233".equals(form.getPassword())) {
            return ResponseEntity.ok(Response.<String>builder().code(HttpStatus.OK.value()).data("succ").build());
        }

        // TODO：改成统一处理
//        return ResponseEntity.ok("200"); //spring 会检测并设置成text
        return ResponseEntity.status(401).body(Response.<String>builder().code(HttpStatus.UNAUTHORIZED.value()).data("invalid passwrod").build());
    }
}
