package com.ilisi.roommatebackend.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

public class OffreLocationGetListLocDto extends  AOffreGetDto {
    @Getter
    @Setter
    private String mainImage;

}
