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
public class Skieur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numSkieur;

    private String nomS;
    private String prenomS;
    private Date dateNaissance;
    private String ville;

    @ManyToMany
    @JoinTable(
            name = "skieur_piste",
            joinColumns = @JoinColumn(name = "skieur_id"),
            inverseJoinColumns = @JoinColumn(name = "piste_id")
    )
    private Set<Piste> pistes;




}