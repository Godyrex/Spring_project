package com.example.oussema.Services;

import com.example.oussema.entity.Inscription;
import com.example.oussema.repository.InscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscriptionService  {

    private final InscriptionRepository inscriptionRepository;

    @Autowired
    public InscriptionService(InscriptionRepository inscriptionRepository) {
        this.inscriptionRepository = inscriptionRepository;
    }


    public Inscription saveInscription(Inscription inscription) {
        return inscriptionRepository.save(inscription);
    }


    public Inscription getInscriptionById(Long id) {
        return inscriptionRepository.findById(id).orElse(null);
    }


    public List<Inscription> getAllInscriptions() {
        return inscriptionRepository.findAll();
    }


    public void deleteInscription(Long id) {
        inscriptionRepository.deleteById(id);
    }
}

