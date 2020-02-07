package com.ilisi.roommatebackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "locateur_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @Getter
    @Setter
    private Profile profile;

}
