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

        // the string tell which page to go, by deafult its under /resource and /resource/template and /resource/public and /rouserce/static
        return "index";
    }

    @RequestMapping("/projects")
    public String projectsView(){

        // the string tell which page to go, by deafult its under /resource and /resource/template and /resource/public and /rouserce/static
        return "projects";
    }


}
