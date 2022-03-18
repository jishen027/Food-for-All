package com.team12.foodforall.controller.user;

import com.team12.foodforall.domain.User;
import com.team12.foodforall.repository.UserRepository;
import com.team12.foodforall.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author: Heng Gao
 * @date: 08/03/2022 :17:06
 **/
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/register_abi")
    public String showRegisterForm_abi(User user) {
        return "register_abi";
    }

    @GetMapping("/register")
    public String showRegisterForm(User user) {
        return "register";
    }

    /**
     * Returns the target page in string form based on the registration result.
     * <p>
     * This method will validate and register the given user.
     * Password will be encrypted.
     * @param  user  an user constructed of a user input form
     * @param  result result can be used to store errors, which will be further
     *                used by thymeleaf to control DOM visibility
     * @param  model the model is basically the page, you can add attributes(simply key/value pairs)
     *               which can be accessed by thymeleaf templates.
     * @return      a string of page name which can be found insequence
     *              under /resources, /resources/template, /resources/static /resources/public.
     */
    @PostMapping("/register")
    public String addUser(@Valid User user, BindingResult result, Model model) {

        // handle error actively here
        // if not, redirect to default error pages(if exist).
        if (result.hasErrors()) {
            return "register";
        }

        // business logic
        User savedUser = userService.addUser(user);

        // if success
        return "redirect:/users";
    }

    @GetMapping("/users")
    public String showUserList(Model model) {
        model.addAttribute("users", userService.findAllUsers());
        return "users";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        User user = userService.findUserById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        model.addAttribute("user", user);
        return "update-user";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, @Valid User user,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            System.err.println(result.getAllErrors());
            user.setId(id);
            return "update-user";
        }

        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        User user = userService.findUserById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        userService.deleteUserById(id);
        return "redirect:/users";
    }

}
