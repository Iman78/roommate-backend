package com.ilisi.roommatebackend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    int id;

    @Column(name = "username", nullable = false, unique=true)
    @Getter @Setter
    private String username;

    @Column(name = "password", nullable = false, unique=true)
    @Getter @Setter
    private String password;

    @Column(name = "nom")
    @Getter @Setter
    private String nom;

    @Column(name = "prenom")
    @Getter @Setter
    private String prenom;

    @Column(name = "email", nullable = false)
    @Getter @Setter
    private String email;

    @Column(name = "mobile")
    @Getter @Setter
    private String mobile;

    @Column(name = "phone")
    @Getter @Setter
    private String telephone;

    @Column(name = "score")
    @Getter @Setter
    private double score=0;

    @Column(name = "nbrVote")
    @Getter @Setter
    private int nbrVote=0;

}
