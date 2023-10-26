package com.example.oussema.Interface;

import com.example.oussema.entity.Inscription;

import java.util.List;

public interface IInscriptionService {
    Inscription saveInscription(Inscription inscription);
    Inscription getInscriptionById(Long id);
    List<Inscription> getAllInscriptions();
    void deleteInscription(Long id);
}
