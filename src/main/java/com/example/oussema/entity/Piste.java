package com.example.oussema.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
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
    private Set<Skieur> skieurs = new HashSet<>();

    @Override
    public String toString() {
        return "Piste{" +
                "numPiste=" + numPiste +
                ", nomPiste='" + nomPiste + '\'' +
                ", couleur=" + couleur +
                ", longueur=" + longueur +
                ", pente=" + pente +
                ", skieurs=" + skieurs +
                '}';
    }
}
