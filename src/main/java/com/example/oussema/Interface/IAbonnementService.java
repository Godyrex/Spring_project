package com.example.oussema.Interface;

import com.example.oussema.entity.Abonnement;

import java.util.List;

public interface IAbonnementService {
    Abonnement saveAbonnement(Abonnement abonnement);
    Abonnement getAbonnementById(Long id);
    List<Abonnement> getAllAbonnements();
    void deleteAbonnement(Long id);
}
