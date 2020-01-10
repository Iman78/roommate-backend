package com.ilisi.roommatebackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.sql.Blob;

@Entity
public class OffreImages {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    int id;

    @Getter @Setter
    @Lob
    private Blob image;

    @Getter @Setter
    private boolean main;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="offre_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @Getter @Setter
    public Offre offre;
}
