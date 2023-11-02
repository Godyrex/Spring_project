package com.example.oussema.Services;

import com.example.oussema.entity.*;
import com.example.oussema.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static com.example.oussema.entity.TypeAbonnement.MENSUEL;

@Service
public class SkieurService {

    private final SkieurRepository skieurRepository;
    private final PisteRepository pisteRepository;
    private  final CoursRepository coursRepository;
    private final InscriptionRepository inscriptionRepository;
    private final AbonnementRepository abonnementRepository;

    @Autowired
    public SkieurService(SkieurRepository skieurRepository, PisteRepository pisteRepository, CoursRepository coursRepository, AbonnementRepository abonnementRepository, InscriptionRepository inscriptionRepository, AbonnementRepository abonnementRepository1) {
        this.skieurRepository = skieurRepository;
        this.pisteRepository = pisteRepository;
        this.coursRepository = coursRepository;
        this.inscriptionRepository = inscriptionRepository;
        this.abonnementRepository = abonnementRepository1;
    }
    public Skieur addSkierAndAssignToCourse(Skieur skier, Long numCourse){
        Optional<Cours> coursOptional = coursRepository.findById(numCourse);
        if(coursOptional.isPresent()){
            Cours cours = coursOptional.get();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.add(Calendar.MONTH, 1);
            Abonnement abonnement = new Abonnement(calendar.getTime(),10,MENSUEL);
            abonnementRepository.save(abonnement);
            skier.setAbonnement(abonnement);
            skier = skieurRepository.save(skier);
            cours = coursRepository.save(cours);
            abonnement.setSkieur(skier);
            abonnementRepository.save(abonnement);
            Inscription inscription = new Inscription(2,cours,skier);
            inscription = inscriptionRepository.save(inscription);
            cours.getInscriptionSet().add(inscription);
            skier.getInscriptionSet().add(inscription);
            return skieurRepository.save(skier);
        }else{
            throw new SkieurNotFoundException("Course not found with ID: "
                    + numCourse);
        }
    }
    public Skieur assignSkierToPiste(Long numSkieur, Long numPiste){
        Optional<Skieur> skieurOptional = skieurRepository.findById(numSkieur);
        Optional<Piste> pisteOptional = pisteRepository.findById(numPiste);
        if(skieurOptional.isPresent()&&pisteOptional.isPresent()){
            Skieur skieur = skieurOptional.get();
            Piste piste = pisteOptional.get();
            skieur.getPistes().add(piste);
            piste.getSkieurs().add(skieur);
            pisteRepository.save(piste);
            return skieurRepository.save(skieur);
        }else {
            throw new SkieurNotFoundException("Skieur not found with ID: "
                    + numSkieur
                    + " Or Piste not found with ID: "
                    + numPiste );
        }
    }
    public Skieur saveSkieur(Skieur skieur) {
        return skieurRepository.save(skieur);
    }


    public Skieur getSkieurById(Long id) {
        return skieurRepository.findById(id).orElse(null);
    }


    public List<Skieur> getAllSkieurs() {
        return skieurRepository.findAll();
    }


    public void deleteSkieur(Long id) {
        skieurRepository.deleteById(id);
    }
}

