package com.example.oussema.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Abonnement {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    long numAbon;
    Date dateDebut= new Date();
    Date datefin;
    float prixAbon;
    @Enumerated(EnumType.STRING)
    TypeAbonnement typeAbonnement;
    @OneToOne
    @JsonIgnore
    private Skieur skieur;

    public Abonnement(Date datefin, float prixAbon, TypeAbonnement typeAbonnement) {
        this.datefin = datefin;
        this.prixAbon = prixAbon;
        this.typeAbonnement = typeAbonnement;
    }

    public Abonnement(float prixAbon, TypeAbonnement typeAbonnement) {
        this.prixAbon = prixAbon;
        this.typeAbonnement = typeAbonnement;
    }
}
