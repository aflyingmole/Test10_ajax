package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/member")
    public String member() {
        return "member";
    }

    @GetMapping("/find")
    public String find() {
        return "findid";
    }
}
