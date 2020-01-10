package com.ilisi.roommatebackend.dto;

import com.ilisi.roommatebackend.model.Colocataire;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class OffreColocationGetDetailsDto extends AOffreGetDto {

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
