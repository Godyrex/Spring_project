package com.example.oussema.Controller;

import com.example.oussema.Services.SkieurService;
import com.example.oussema.entity.Skieur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skieurs")
public class SkieurController {

    private final SkieurService skieurService;

    @Autowired
    public SkieurController(SkieurService skieurService) {
        this.skieurService = skieurService;
    }

    @PostMapping
    public Skieur createSkieur(@RequestBody Skieur skieur) {
        return skieurService.saveSkieur(skieur);
    }

    @GetMapping("/{id}")
    public Skieur getSkieurById(@PathVariable Long id) {
        return skieurService.getSkieurById(id);
    }

    @GetMapping("/all")
    public List<Skieur> getAllSkieurs() {
        return skieurService.getAllSkieurs();
    }

    @DeleteMapping("/{id}")
    public void deleteSkieur(@PathVariable Long id) {
        skieurService.deleteSkieur(id);
    }
}
