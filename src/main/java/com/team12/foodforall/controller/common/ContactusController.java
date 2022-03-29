package com.team12.foodforall.controller.common;


import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contact-us")
@Validated
public class ContactusController {

    @GetMapping()
    public String _contactus() {
        //TODO:

        return "contact-us";
    }
}
