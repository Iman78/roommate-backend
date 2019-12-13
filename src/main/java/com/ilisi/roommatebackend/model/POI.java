package com.ilisi.roommatebackend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="POI")
public class POI {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    int id;
    @Column(name = "nomPOI")
    @Getter
    @Setter
    private String nomPOI;
/*
    @ManyToMany(mappedBy = "offre_poi")
    Set<Offre> offres;*/
}
