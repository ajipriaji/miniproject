package com.haibca.miniproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    // Menampilkan halaman login
    
    @GetMapping("/login")
    public String showLoginPage() {
        return "production/login";
    }
}
