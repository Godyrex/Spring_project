package com.example.oussema.repository;

import com.example.oussema.entity.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscriptionRepository extends JpaRepository<Inscription, Long> {
    // You can add custom queries here if needed
}