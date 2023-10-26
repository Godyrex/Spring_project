package com.example.oussema.Controller;

import com.example.oussema.Services.PisteService;
import com.example.oussema.entity.Piste;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pistes")
public class PisteController {

    private final PisteService pisteService;

    @Autowired
    public PisteController(PisteService pisteService) {
        this.pisteService = pisteService;
    }

    @PostMapping
    public Piste createPiste(@RequestBody Piste piste) {
        return pisteService.savePiste(piste);
    }

    @GetMapping("/{id}")
    public Piste getPisteById(@PathVariable Long id) {
        return pisteService.getPisteById(id);
    }

    @GetMapping("/all")
    public List<Piste> getAllPistes() {
        return pisteService.getAllPistes();
    }

    @DeleteMapping("/{id}")
    public void deletePiste(@PathVariable Long id) {
        pisteService.deletePiste(id);
    }
}
