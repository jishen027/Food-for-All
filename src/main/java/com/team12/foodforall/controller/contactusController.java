package com.team12.foodforall.controller;


import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Contact Us")
@Validated
public class contactusController {

    @GetMapping()
    public String _contactus() {
        //TODO:

        return "Contact Us";
    }
}
