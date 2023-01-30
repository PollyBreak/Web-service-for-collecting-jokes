package com.se2212.web_service_for_jokes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

    @GetMapping("/")
    public String greeting() {
        return "greeting";
    }
}
