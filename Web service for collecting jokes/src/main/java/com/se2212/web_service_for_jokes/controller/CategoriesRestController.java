package com.se2212.web_service_for_jokes.controller;

import com.se2212.web_service_for_jokes.entity.JokeCategory;
import com.se2212.web_service_for_jokes.service.JokeCategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/categories")
    public void saveCategory(@RequestBody JokeCategory jokeCategory){
        jokeCategoryService.saveCategory(jokeCategory);
    }

    @PutMapping("/categories")
    public JokeCategory updateCategory(@RequestBody JokeCategory updatedCategory){
        jokeCategoryService.saveCategory(updatedCategory);
        return updatedCategory;
    }
    
    @DeleteMapping("/categories/{id}")
    public List<JokeCategory> deleteCategory(@PathVariable int id){
        jokeCategoryService.deleteCategory(id);
        return showAllCategories();
    }

}
