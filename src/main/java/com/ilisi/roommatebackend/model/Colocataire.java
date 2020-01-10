package com.ilisi.roommatebackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="Colocataire")
public class Colocataire extends User {

    @Column(name = "addresse")
    @Getter
    @Setter
    private String addresse;

    @Column(name = "sexe")
    @Getter
    @Setter
    private String sexe;

    @Column(name = "nationalite")
    @Getter
    @Setter
    private String nationalite;


    @Column(name = "nivEtude")
    @Getter
    @Setter
    private String nivEtude;

    @Column(name = "origine")
    @Getter
    @Setter
    private String origine;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="filiere_id")
    @Getter
    @Setter
    private Filiere filiere;

}
