package com.example.oussema.Controller;

import com.example.oussema.Services.CoursService;
import com.example.oussema.entity.Cours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cours")
public class CoursController {

    private final CoursService coursService;

    @Autowired
    public CoursController(CoursService coursService) {
        this.coursService = coursService;
    }

    @PostMapping
    public Cours createCours(@RequestBody Cours cours) {
        return coursService.saveCours(cours);
    }

    @GetMapping("/{id}")
    public Cours getCoursById(@PathVariable Long id) {
        return coursService.getCoursById(id);
    }

    @GetMapping("/all")
    public List<Cours> getAllCours() {
        return coursService.getAllCours();
    }

    @DeleteMapping("/{id}")
    public void deleteCours(@PathVariable Long id) {
        coursService.deleteCours(id);
    }
}

