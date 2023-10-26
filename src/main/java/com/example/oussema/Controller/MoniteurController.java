package com.example.oussema.Controller;

import com.example.oussema.Services.MoniteurService;
import com.example.oussema.entity.Moniteur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/moniteurs")
public class MoniteurController {

    private final MoniteurService moniteurService;

    @Autowired
    public MoniteurController(MoniteurService moniteurService) {
        this.moniteurService = moniteurService;
    }

    @PostMapping
    public Moniteur createMoniteur(@RequestBody Moniteur moniteur) {
        return moniteurService.saveMoniteur(moniteur);
    }

    @GetMapping("/{id}")
    public Moniteur getMoniteurById(@PathVariable Long id) {
        return moniteurService.getMoniteurById(id);
    }

    @GetMapping("/all")
    public List<Moniteur> getAllMoniteurs() {
        return moniteurService.getAllMoniteurs();
    }

    @DeleteMapping("/{id}")
    public void deleteMoniteur(@PathVariable Long id) {
        moniteurService.deleteMoniteur(id);
    }
}

