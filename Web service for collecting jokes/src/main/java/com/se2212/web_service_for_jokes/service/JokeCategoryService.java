package com.se2212.web_service_for_jokes.service;

import com.se2212.web_service_for_jokes.entity.JokeCategory;
import com.se2212.web_service_for_jokes.repository.JokeCategoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class JokeCategoryService {
    @Autowired
    private JokeCategoryRepository jokeCategoryRepository;

    public List<JokeCategory> getAllCategories(){
        return jokeCategoryRepository.findAll();
    }

    public JokeCategory getJokeCategoryById(int id) {
        JokeCategory jokeCategory = null;
        Optional<JokeCategory> optional = jokeCategoryRepository.findById(id); //as findById returns Optional
        if (optional.isPresent()) {
            jokeCategory = optional.get();
        }
        return jokeCategory;
    }

    public void saveCategory(JokeCategory jokeCategory){
        jokeCategoryRepository.save(jokeCategory);
    }

    public void deleteCategory(int id){
        jokeCategoryRepository.deleteById(id);
    }

}
