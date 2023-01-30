package com.se2212.web_service_for_jokes.controller;

import com.se2212.web_service_for_jokes.service.JokeCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
    @Autowired
    private JokeCategoryService jokeCategoryService;

    @GetMapping("/")
    public String greeting() {
        return "greeting";
    }

    @GetMapping("/categories")
    public String showHomepage(Model model) {
        model.addAttribute("joke_categories", jokeCategoryService.getAllCategories());
        return "categories";
    }
}
