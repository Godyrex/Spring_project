package com.example.oussema.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Skieur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numSkieur;

    private String nomS;
    private String prenomS;
    private Date dateNaissance;
    private String ville;

    @OneToMany(mappedBy = "skieur")
    Set<Inscription> inscriptionSet = new HashSet<>(); ;


    @ManyToMany
    @JsonIgnore
    @JoinTable(
            name = "skieur_piste",
            joinColumns = @JoinColumn(name = "num_skieur"),
            inverseJoinColumns = @JoinColumn(name = "num_piste")
    )
    private Set<Piste> pistes = new HashSet<>();
    @OneToOne(mappedBy = "skieur")
    private Abonnement abonnement;


    @Override
    public String toString() {
        return "Skieur{" +
                "numSkieur=" + numSkieur +
                ", nomS='" + nomS + '\'' +
                ", prenomS='" + prenomS + '\'' +
                ", dateNaissance=" + dateNaissance +
                ", ville='" + ville + '\'' +
                ", pistes=" + pistes +
                '}';
    }
}