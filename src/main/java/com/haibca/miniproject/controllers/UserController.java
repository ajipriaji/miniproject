package com.haibca.miniproject.controllers;

import com.haibca.miniproject.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String viewLoginPage() {
        return "login_page";
    }
    
}
