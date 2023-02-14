package com.se2212.web_service_for_jokes.service;

import com.se2212.web_service_for_jokes.entity.Meme;
import com.se2212.web_service_for_jokes.repository.MemesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemeService {
    private final MemesRepository memesRepository;

    public MemeService(MemesRepository memesRepository){
        this.memesRepository=memesRepository;
    }

    public List<Meme> getAllMemes(){
        return memesRepository.findAll();
    }

    public Meme getMemeById(int id){
        Optional<Meme> optional=memesRepository.findById(id);
        return optional.orElse(null);
    }

    public void saveMeme(Meme newmeme){
        memesRepository.save(newmeme);
    }

    public void deleteMeme(int id){
        memesRepository.deleteById(id);
    }
}
