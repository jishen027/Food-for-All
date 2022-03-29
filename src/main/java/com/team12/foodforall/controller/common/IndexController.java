package com.team12.foodforall.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author: Abhishek M Nagesh
 * @date: 26/03/2022 :12:43
 **/

@Controller
@RequestMapping("/index")
@Validated
public class IndexController {

    @GetMapping()
    public String _index() {
        //TODO:

        return "index";
    }
}