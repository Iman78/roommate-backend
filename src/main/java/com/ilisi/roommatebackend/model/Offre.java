package com.ilisi.roommatebackend.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Set;

@Entity
@Table(name="Offre")
public class Offre {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    int id;
    @Column(name = "titre")
    @Getter
    @Setter
    private String titre;
    @Column(name = "adresse")
    @Getter
    @Setter
    private String adresse;
    @Column(name = "detail")
    @Getter
    @Setter
    private String detail;
    @Column(name = "type")
    @Getter
    @Setter
    private String type;
    @Column(name = "nbrPrs")
    @Getter
    @Setter
    private int nbrPrs;
    @Column(name = "nbrPiece")
    @Getter
    @Setter
    private int nbrPiece;
    @Column(name = "surface")
    @Getter
    @Setter
    private int surface;
    @Column(name = "wifi")
    @Getter
    @Setter
    private boolean wifi;
    @Column(name = "meuble")
    @Getter
    @Setter
    private boolean meuble;
    @Column(name = "prixPers")
    @Getter
    @Setter
    private double prixPers;
    @Column(name = "prixLog")
    @Getter
    @Setter
    private double prixLog;

    @Getter
    @Setter
    private LocalDateTime date;

    @Getter
    @Setter
    private ArrayList<String> listImg;

    @ManyToMany
    @JoinTable(
            name = "offre_poi",
            joinColumns = @JoinColumn(name = "offre_id"),
            inverseJoinColumns = @JoinColumn(name = "poi_id"))
    @Getter
    @Setter
    private Set<POI> listPOI;
    @ManyToMany
    @JoinTable(
            name = "offre_fac",
            joinColumns = @JoinColumn(name = "offre_id"),
            inverseJoinColumns = @JoinColumn(name = "faculte_id"))
    @Getter
    @Setter
    private Set<Faculte> listFac;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "locateur_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @Getter
    @Setter
    private Locateur locateur;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ville_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @Getter
    @Setter
    private Ville ville;


}

