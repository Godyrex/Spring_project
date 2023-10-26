package com.example.oussema.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Cours {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    long numCours;
    int niveau;
    @Enumerated(EnumType.STRING)
    TypeCours typeCours;
    @Enumerated(EnumType.STRING)
    Support support;
    float prix;
    int creneau;
    @OneToMany(mappedBy = "cours")
    Set<Inscription> inscriptionSet;
    @ManyToOne
    private Moniteur moniteur;

}
