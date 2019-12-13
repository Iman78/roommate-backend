package com.ilisi.roommatebackend.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name="Filiere")
public class Filiere {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    int id;

    @Column(name = "nomFiliere")
    @Getter @Setter
    private String nomFiliere;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "faculte_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Faculte faculte;
}