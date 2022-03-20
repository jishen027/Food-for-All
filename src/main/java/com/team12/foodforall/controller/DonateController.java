package com.team12.foodforall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: Long Hin Vong
 * @date: 19/03/2022 :23:12
 **/
@Controller
public class DonateController {

    @RequestMapping("/donate")
    public String donate(){
        return "donate";
    }
}
