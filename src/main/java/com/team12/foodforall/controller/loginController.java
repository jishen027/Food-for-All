package com.team12.foodforall.controller;

import com.team12.foodforall.domain.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: Heng Gao
 * @date: 08/03/2022 :17:06
 **/
@Controller
@RequestMapping("/login")
public class loginController {


    @GetMapping()
    public String _login(){
        //TODO:

        return "redirect:";
    }

    @PostMapping()
    public String auth(@RequestBody LoginForm loginForm){
        //TODO:

        //解析

        //
        return "redirect:";
    }
}
