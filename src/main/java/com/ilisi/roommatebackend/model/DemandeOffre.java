package com.ilisi.roommatebackend.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class DemandeOffre {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    int id;

    @Getter
    @Setter
    private LocalDateTime date;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "colocataire_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @Getter
    @Setter
    private Colocataire colocateur;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "offre_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @Getter
    @Setter
    private Offre offre;

}
