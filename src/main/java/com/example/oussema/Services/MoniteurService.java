package com.example.oussema.Services;

import com.example.oussema.entity.Moniteur;
import com.example.oussema.repository.MoniteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoniteurService{

    private final MoniteurRepository moniteurRepository;

    @Autowired
    public MoniteurService(MoniteurRepository moniteurRepository) {
        this.moniteurRepository = moniteurRepository;
    }


    public Moniteur saveMoniteur(Moniteur moniteur) {
        return moniteurRepository.save(moniteur);
    }


    public Moniteur getMoniteurById(Long id) {
        return moniteurRepository.findById(id).orElse(null);
    }


    public List<Moniteur> getAllMoniteurs() {
        return moniteurRepository.findAll();
    }


    public void deleteMoniteur(Long id) {
        moniteurRepository.deleteById(id);
    }
}

