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
public class Piste {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    long numPiste;
    String nomPiste;
    @Enumerated(EnumType.STRING)
    Couleur couleur;
    int longueur;
    int pente;

    @ManyToMany(mappedBy = "pistes")
    private Set<Skieur> skieurs;

}
