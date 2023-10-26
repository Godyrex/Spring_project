package com.example.oussema.repository;

import com.example.oussema.entity.Piste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PisteRepository extends JpaRepository<Piste, Long> {
    // You can add custom queries here if needed
}
