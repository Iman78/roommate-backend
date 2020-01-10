package com.ilisi.roommatebackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
public class OffreColocation extends Offre {

    @Getter
    @Setter
    private String sexe;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "colocataire_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @Getter
    @Setter
    private Colocataire colocataire;

}
