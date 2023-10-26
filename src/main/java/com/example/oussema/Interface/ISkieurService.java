package com.example.oussema.Interface;

import com.example.oussema.entity.Skieur;

import java.util.List;

public interface ISkieurService {
    Skieur saveSkieur(Skieur skieur);
    Skieur getSkieurById(Long id);
    List<Skieur> getAllSkieurs();
    void deleteSkieur(Long id);
}
