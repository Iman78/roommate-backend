package com.ilisi.roommatebackend.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class OffreColocationDto {

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
    private String sexe;

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
    private List<String> listImg;


    @Getter
    @Setter
    private List<Integer> listPOI;

    @Getter
    @Setter
    private List<Integer> listFac;

    @Getter
    @Setter
    private int colocataire;


    @Getter
    @Setter
    private int ville;
}
