package com.ilisi.roommatebackend.dto;

import com.ilisi.roommatebackend.model.Locateur;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class OffreLocationGetDetailsDto extends AOffreGetDto {

    @Getter
    @Setter
    private Locateur locateur;

    @Getter
    @Setter
    private String mainImage;

    @Getter
    @Setter
    private ArrayList<String> listImg;


}
