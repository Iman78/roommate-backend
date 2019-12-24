package com.ilisi.roommatebackend.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OffreLocation extends Offre  {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "locateur_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @Getter
    @Setter
    private Locateur locateur;
}
