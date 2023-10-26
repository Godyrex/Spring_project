package com.example.oussema.Services;

import com.example.oussema.entity.Cours;
import com.example.oussema.repository.CoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursService {

    private final CoursRepository coursRepository;

    @Autowired
    public CoursService(CoursRepository coursRepository) {
        this.coursRepository = coursRepository;
    }


    public Cours saveCours(Cours cours) {
        return coursRepository.save(cours);
    }


    public Cours getCoursById(Long id) {
        return coursRepository.findById(id).orElse(null);
    }


    public List<Cours> getAllCours() {
        return coursRepository.findAll();
    }


    public void deleteCours(Long id) {
        coursRepository.deleteById(id);
    }
}

