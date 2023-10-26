package com.example.oussema.repository;

import com.example.oussema.entity.Skieur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkieurRepository extends JpaRepository<Skieur, Long> {
    // You can add custom queries here if needed
}
