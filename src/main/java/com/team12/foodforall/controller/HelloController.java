package com.team12.foodforall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: Heng Gao
 * @date: 08/03/2022 :15:13
 **/
@Controller
public class HelloController {

    @RequestMapping("/")
    public String hello(){
        return "index";
    }
}
