package com.ilisi.roommatebackend.dto;

import com.ilisi.roommatebackend.model.Colocataire;
import lombok.Getter;
import lombok.Setter;

public class ColocataireDto {


    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    private String username;

    @Getter
    @Setter
    private String password;

    @Getter
    @Setter
    private String nom;

    @Getter
    @Setter
    private String prenom;

    @Getter
    @Setter
    private String telephone;

    @Getter
    @Setter
    private String mobile;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private String addresse;

    @Getter
    @Setter
    private String sexe;

    @Getter
    @Setter
    private String nationalite;


    @Getter
    @Setter
    private String nivEtude;

    @Getter
    @Setter
    private String origine;

    @Getter
    @Setter
    private int filiere;

    public Colocataire getEntity(){
        Colocataire coloc=new Colocataire();
        coloc.setUsername(username);
        coloc.setPassword(password);
        coloc.setNom(nom);
        coloc.setPrenom(prenom);
        coloc.setAddresse(addresse);
        coloc.setTelephone(telephone);
        coloc.setMobile(mobile);
        coloc.setEmail(email);
        coloc.setSexe(sexe);
        coloc.setOrigine(origine);
        coloc.setNationalite(nationalite);
        coloc.setNivEtude(nivEtude);
        return coloc;
    }
}
