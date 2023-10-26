package com.example.oussema.Services;

import com.example.oussema.entity.Piste;
import com.example.oussema.repository.PisteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PisteService {

    private final PisteRepository pisteRepository;

    @Autowired
    public PisteService(PisteRepository pisteRepository) {
        this.pisteRepository = pisteRepository;
    }


    public Piste savePiste(Piste piste) {
        return pisteRepository.save(piste);
    }


    public Piste getPisteById(Long id) {
        return pisteRepository.findById(id).orElse(null);
    }


    public List<Piste> getAllPistes() {
        return pisteRepository.findAll();
    }


    public void deletePiste(Long id) {
        pisteRepository.deleteById(id);
    }
}
