package com.example.oussema.Services;

import com.example.oussema.entity.Skieur;
import com.example.oussema.repository.SkieurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkieurService {

    private final SkieurRepository skieurRepository;

    @Autowired
    public SkieurService(SkieurRepository skieurRepository) {
        this.skieurRepository = skieurRepository;
    }


    public Skieur saveSkieur(Skieur skieur) {
        return skieurRepository.save(skieur);
    }


    public Skieur getSkieurById(Long id) {
        return skieurRepository.findById(id).orElse(null);
    }


    public List<Skieur> getAllSkieurs() {
        return skieurRepository.findAll();
    }


    public void deleteSkieur(Long id) {
        skieurRepository.deleteById(id);
    }
}

