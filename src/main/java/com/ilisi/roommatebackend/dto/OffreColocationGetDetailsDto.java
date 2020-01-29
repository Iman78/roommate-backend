package com.ilisi.roommatebackend.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ilisi.roommatebackend.model.Colocataire;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class OffreColocationGetDetailsDto extends AOffreGetDto {
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @Getter
    @Setter
    private Colocataire colocataire;

    @Getter
    @Setter
    private String mainImage;

    @Getter
    @Setter
    private ArrayList<String> listImg;
}
