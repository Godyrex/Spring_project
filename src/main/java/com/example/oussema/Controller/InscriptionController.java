package com.example.oussema.Controller;

import com.example.oussema.Services.InscriptionService;
import com.example.oussema.entity.Inscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inscriptions")
public class InscriptionController {

    private final InscriptionService inscriptionService;

    @Autowired
    public InscriptionController(InscriptionService inscriptionService) {
        this.inscriptionService = inscriptionService;
    }

    @PostMapping
    public Inscription createInscription(@RequestBody Inscription inscription) {
        return inscriptionService.saveInscription(inscription);
    }

    @GetMapping("/{id}")
    public Inscription getInscriptionById(@PathVariable Long id) {
        return inscriptionService.getInscriptionById(id);
    }

    @GetMapping("/all")
    public List<Inscription> getAllInscriptions() {
        return inscriptionService.getAllInscriptions();
    }

    @DeleteMapping("/{id}")
    public void deleteInscription(@PathVariable Long id) {
        inscriptionService.deleteInscription(id);
    }
}
