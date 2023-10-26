package com.example.oussema.entity;

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
    Date dateDebut;
    Date datefin;
    float prixAbon;
    @Enumerated(EnumType.STRING)
    TypeAbonnement typeAbonnement;

}
