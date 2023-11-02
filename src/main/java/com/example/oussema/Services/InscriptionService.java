package com.example.oussema.Services;

import com.example.oussema.entity.Cours;
import com.example.oussema.entity.Inscription;
import com.example.oussema.entity.Skieur;
import com.example.oussema.repository.CoursRepository;
import com.example.oussema.repository.InscriptionRepository;
import com.example.oussema.repository.SkieurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InscriptionService  {

    private final InscriptionRepository inscriptionRepository;
    private  final CoursRepository coursRepository;
    private final SkieurRepository skieurRepository;
    @Autowired
    public InscriptionService(InscriptionRepository inscriptionRepository, CoursRepository coursRepository, SkieurRepository skieurRepository) {
        this.inscriptionRepository = inscriptionRepository;
        this.coursRepository = coursRepository;
        this.skieurRepository = skieurRepository;
    }
    public Inscription assignInscriptionToCourse(Long numInscription, Long numCourse){
        Optional<Cours> coursOptional = coursRepository.findById(numCourse);
        Optional<Inscription> inscriptionOptional = inscriptionRepository.findById(numInscription);
        if(coursOptional.isPresent()&&inscriptionOptional.isPresent()){
            Cours cours = coursOptional.get();
            Inscription inscription = inscriptionOptional.get();
            inscription.setCours(cours);
            return  inscriptionRepository.save(inscription);
        }else {
            throw new RuntimeException("Course not found with ID: "
                    + numCourse
                    + "Or Inscription not found with ID: "
                    + numInscription );
        }
    }

    public Inscription addInscriptionAndAssignToSkier(Inscription inscription, Long numSkier) {
        Optional<Skieur> skieurOptional = skieurRepository.findById(numSkier);
        if (skieurOptional.isPresent()) {
            Skieur skieur = skieurOptional.get();
            inscription.setSkieur(skieur);
            return inscriptionRepository.save(inscription);
        } else {
            throw new SkieurNotFoundException("Skieur not found with ID: " + numSkier);
        }
    }

    public Inscription saveInscription(Inscription inscription) {
        return inscriptionRepository.save(inscription);
    }


    public Inscription getInscriptionById(Long id) {
        return inscriptionRepository.findById(id).orElse(null);
    }


    public List<Inscription> getAllInscriptions() {
        return inscriptionRepository.findAll();
    }


    public void deleteInscription(Long id) {
        inscriptionRepository.deleteById(id);
    }
}

