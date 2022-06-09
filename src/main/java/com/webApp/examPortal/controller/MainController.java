package com.webApp.examPortal.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/login")
    public String login() {
        return "login/form";
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }
}
