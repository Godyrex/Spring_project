package com.example.oussema.repository;

import com.example.oussema.entity.Moniteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoniteurRepository extends JpaRepository<Moniteur, Long> {
    // You can add custom queries here if needed
}
