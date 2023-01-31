package com.se2212.web_service_for_jokes.controller;

import com.se2212.web_service_for_jokes.entity.JokeCategory;
import com.se2212.web_service_for_jokes.service.JokeCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoriesRestController {

    @Autowired
    private JokeCategoryService jokeCategoryService;
    @GetMapping("/categories")
    public List<JokeCategory> showAllCategories(){
        List<JokeCategory> categories = jokeCategoryService.getAllCategories();
        return categories;
    }

    @GetMapping("/categories/{id}")
    public JokeCategory showCategory(@PathVariable int id){
        JokeCategory jokeCategory = jokeCategoryService.getJokeCategoryById(id);
        return jokeCategory;
    }




}
