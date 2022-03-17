package com.team12.foodforall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author: Heng Gao
 * @date: 08/03/2022 :15:13
 **/
@Controller
public class ProjectController {

    @RequestMapping("/")
    public String index(HttpSession session){

        session.setAttribute("loginStatus","true");
        session.setAttribute("userName","gh");
        session.setAttribute("userRole","admin");
        // the string tell which page to go, by deafult its under /resource and /resource/template and /resource/public and /rouserce/static
        return "index";
    }
}
