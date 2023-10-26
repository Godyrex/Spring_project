package com.example.oussema.repository;

import com.example.oussema.entity.Cours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursRepository extends JpaRepository<Cours, Long> {
    // You can add custom queries here if needed
}