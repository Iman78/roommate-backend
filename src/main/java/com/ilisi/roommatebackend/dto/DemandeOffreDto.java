package com.ilisi.roommatebackend.dto;

import com.ilisi.roommatebackend.model.Colocataire;
import com.ilisi.roommatebackend.model.Offre;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

public class DemandeOffreDto {

    @Getter
    @Setter
    private String message;

    @Getter
    @Setter
    String email;

    @Getter
    @Setter
    String telephone;

    @Getter
    @Setter
    private int colocataire;


    @Getter
    @Setter
    private int offre;
}
