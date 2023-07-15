package com.spring.myspringsecurity.controller;

import com.spring.myspringsecurity.model.User;
import com.spring.myspringsecurity.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(){
        return "account/login";
    }

    @GetMapping("/register")
    public String register(){

        return "account/register";
    }

    @PostMapping("/register")
    public String register(User user){
        userService.save(user);
        return "redirect:/";
    }
}
