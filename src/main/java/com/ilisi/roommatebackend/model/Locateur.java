package com.ilisi.roommatebackend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Locateur")
public class Locateur extends User {

    @Column(name = "nomAgence")
    @Getter
    @Setter
    private String nomAgence;

}
