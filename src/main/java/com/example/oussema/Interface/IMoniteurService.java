package com.example.oussema.Interface;

import com.example.oussema.entity.Moniteur;

import java.util.List;

public interface IMoniteurService {
    Moniteur saveMoniteur(Moniteur moniteur);
    Moniteur getMoniteurById(Long id);
    List<Moniteur> getAllMoniteurs();
    void deleteMoniteur(Long id);
}
