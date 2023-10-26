package com.example.oussema.entity;

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
    private Cours cours;

    @ManyToOne
    private Skieur skieur;

}
