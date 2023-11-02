package com.example.oussema.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor

@Getter
@Setter
@Entity
public class Inscription {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    long numInscription;
    int numSemaine;
    @ManyToOne
    @JsonIgnore
    private Cours cours;

    @ManyToOne
    @JsonIgnore
    private Skieur skieur;

    public Inscription(int numSemaine) {
        this.numSemaine = numSemaine;
    }

    public Inscription(int numSemaine, Cours cours, Skieur skieur) {
        this.numSemaine = numSemaine;
        this.cours = cours;
        this.skieur = skieur;
    }
}
