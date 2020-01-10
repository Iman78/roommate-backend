package com.ilisi.roommatebackend.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ilisi.roommatebackend.model.Colocataire;
import lombok.Getter;
import lombok.Setter;

public class OffreColocationGetListDto extends AOffreGetDto{

    @Getter
    @Setter
    private String mainImage;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @Getter
    @Setter
    private Colocataire colocataire;


}
