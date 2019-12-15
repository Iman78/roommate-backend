package com.ilisi.roommatebackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name="Faculte")
public class Faculte {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    int id;
    @Column(name = "nomFaculte")
    @Getter
    @Setter
    private String nomFaculte;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ville_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @Getter
    @Setter
    private Ville ville;
}
