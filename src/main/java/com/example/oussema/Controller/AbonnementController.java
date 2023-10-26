package com.example.oussema.Controller;

import com.example.oussema.Services.AbonnementService;
import com.example.oussema.entity.Abonnement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/abonnements")
public class AbonnementController {

    private final AbonnementService abonnementService;

    @Autowired
    public AbonnementController(AbonnementService abonnementService) {
        this.abonnementService = abonnementService;
    }

    @PostMapping
    public Abonnement createAbonnement(@RequestBody Abonnement abonnement) {
        return abonnementService.saveAbonnement(abonnement);
    }

    @GetMapping("/{id}")
    public Abonnement getAbonnementById(@PathVariable Long id) {
        return abonnementService.getAbonnementById(id);
    }

    @GetMapping("/all")
    public List<Abonnement> getAllAbonnements() {
        return abonnementService.getAllAbonnements();
    }

    @DeleteMapping("/{id}")
    public void deleteAbonnement(@PathVariable Long id) {
        abonnementService.deleteAbonnement(id);
    }
}

