package com.se2212.web_service_for_jokes.controller;

import com.se2212.web_service_for_jokes.entity.JokeCategory;
import com.se2212.web_service_for_jokes.service.JokeCategoryService;
import jakarta.validation.Valid;
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
<<<<<<< Updated upstream




=======
    @GetMapping("/categories/{id}")
    public JokeCategory showCategory(@PathVariable int id){
        JokeCategory jokeCategory = jokeCategoryService.getJokeCategoryById(id);
        return jokeCategory;
    }
    @PostMapping("/categories")
    public void saveCategory(@Valid JokeCategory jokeCategory){
        jokeCategoryService.saveCategory(jokeCategory);
    }
    @PostMapping("/categories/{id}")
    public JokeCategory updateCategory(@PathVariable int id,@Valid JokeCategory newcategory){
        JokeCategory crashcaller = jokeCategoryService.getJokeCategoryById(id); //if trying to update when does not exist it adds, so i just crash the whole thing
        newcategory.setId(id);
        jokeCategoryService.saveCategory(newcategory);
        return newcategory;
    }
    @GetMapping("/categories/{id}/delete")
    public List<JokeCategory> deleteCategory(@PathVariable int id){
        jokeCategoryService.deleteCategory(id);
        return showAllCategories();
    }
>>>>>>> Stashed changes
}
