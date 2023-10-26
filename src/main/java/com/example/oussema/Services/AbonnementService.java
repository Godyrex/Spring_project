package com.example.oussema.Services;

import com.example.oussema.entity.Abonnement;
import com.example.oussema.repository.AbonnementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbonnementService{

    private final AbonnementRepository abonnementRepository;

    @Autowired
    public AbonnementService(AbonnementRepository abonnementRepository) {
        this.abonnementRepository = abonnementRepository;
    }


    public Abonnement saveAbonnement(Abonnement abonnement) {
        return abonnementRepository.save(abonnement);
    }


    public Abonnement getAbonnementById(Long id) {
        return abonnementRepository.findById(id).orElse(null);
    }


    public List<Abonnement> getAllAbonnements() {
        return abonnementRepository.findAll();
    }


    public void deleteAbonnement(Long id) {
        abonnementRepository.deleteById(id);
    }
}

