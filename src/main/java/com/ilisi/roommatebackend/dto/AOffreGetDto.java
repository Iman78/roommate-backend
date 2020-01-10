package com.ilisi.roommatebackend.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ilisi.roommatebackend.model.Faculte;
import com.ilisi.roommatebackend.model.POI;
import com.ilisi.roommatebackend.model.Ville;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class AOffreGetDto {
    @Getter
    @Setter
    int id;

    @Getter
    @Setter
    private String titre;

    @Getter
    @Setter
    private String adresse;

    @Getter
    @Setter
    private String detail;

    @Getter
    @Setter
    private String type;


    @Getter
    @Setter
    private int nbrPrs;

    @Getter
    @Setter
    private int nbrPiece;

    @Getter
    @Setter
    private int surface;

    @Getter
    @Setter
    private boolean wifi;

    @Getter
    @Setter
    private boolean meuble;

    @Getter
    @Setter
    private double prixPers;

    @Getter
    @Setter
    private double prixLog;

    @Getter
    @Setter
    private LocalDateTime date;

    @Getter
    @Setter
    private ArrayList<POI> listPOI;

    @Getter
    @Setter
    private ArrayList<Faculte> listFac;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @Getter
    @Setter
    private Ville ville;
}
