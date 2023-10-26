package com.example.oussema.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Moniteur {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    long numMoniteur;
    String nomM;
    String prenomM;
    Date dateRecru;
    @OneToMany(mappedBy = "moniteur")
    Set<Cours> coursSet;

}
