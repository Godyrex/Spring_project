package com.example.oussema.Interface;

import com.example.oussema.entity.Cours;

import java.util.List;

public interface ICoursService {
    Cours saveCours(Cours cours);
    Cours getCoursById(Long id);
    List<Cours> getAllCours();
    void deleteCours(Long id);
}
