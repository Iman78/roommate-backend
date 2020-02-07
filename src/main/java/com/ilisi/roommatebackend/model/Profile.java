package com.ilisi.roommatebackend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class Profile {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    int id;

    @Column(name = "name", nullable = false, unique=true)
    @Getter @Setter
    private String name;
}
