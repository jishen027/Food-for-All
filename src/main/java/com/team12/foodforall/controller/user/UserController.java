package com.team12.foodforall.controller.user;

import com.team12.foodforall.domain.LoginForm;
import com.team12.foodforall.domain.Response;
import com.team12.foodforall.domain.User;
import com.team12.foodforall.repository.UserRepository;
import com.team12.foodforall.service.user.UserService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

/**
 * @author: Heng Gao
 * @date: 08/03/2022 :17:06
 **/
@Controller
@Validated
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String _login() {
        //TODO:

        return "login";
    }
 
    @PostMapping("/login")
    @ResponseBody // 一般返回json
    public ResponseEntity<Response<String>> auth(@RequestBody LoginForm loginForm) {
        val form = Optional.ofNullable(loginForm)
                .orElseThrow(() -> new RuntimeException("body cannot be null"));

        if ("gh".equals(form.getUsername()) && "1233".equals(form.getPassword())) {
            return ResponseEntity.ok(Response.<String>builder().code(HttpStatus.OK.value()).data("succ").build());
        }

        // TODO：改成统一处理
//        return ResponseEntity.ok("200"); //spring 会检测并设置成text
        return ResponseEntity.status(401).body(Response.<String>builder().code(HttpStatus.UNAUTHORIZED.value()).data("invalid password").build());
    }

    @GetMapping("/register")
    public String showSignUpForm(User user) {
        return "register";
    }

    @PostMapping("/register")
    public String addUser(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("errorMessage","Login failed");

            throw new RuntimeException("shit");
//            return "error";


        }

        User savedUser = userService.createUser(user);

        //若注册成功直接跳转，/users，等于重新请求所有用户
        return "redirect:/users";
    }

    @GetMapping("/users")
    public String showUserList(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "users";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        model.addAttribute("user", user);
        return "update-user";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, @Valid User user,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            user.setId(id);
            return "update-user";
        }

        userRepository.save(user);
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        userRepository.delete(user);
        return "redirect:/users";
    }

}
