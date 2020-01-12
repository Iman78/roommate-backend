package com.ilisi.roommatebackend.dto;

import com.ilisi.roommatebackend.core.exception.BusinessException;
import com.ilisi.roommatebackend.model.Colocataire;
import com.ilisi.roommatebackend.model.DemandeOffre;
import com.ilisi.roommatebackend.service.ColocataireService;
import com.ilisi.roommatebackend.service.OffreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DemandeOffreMapper {
    @Autowired
    ColocataireService colocataireService;
    @Autowired
    OffreService offreService;

    public DemandeOffre getEntity(DemandeOffreDto dto) throws BusinessException {
        DemandeOffre demandeOffre=new DemandeOffre();
        demandeOffre.setDate(LocalDateTime.now());
        demandeOffre.setMessage(dto.getMessage());
       // int id =
        demandeOffre.setOffre(offreService.findById(dto.getOffre()));
        //Colocataire colocataire=colocataireService.findById(dto.getColocataire(););
        demandeOffre.setColocataire(colocataireService.findById(dto.getColocataire()));
        return demandeOffre;
    }
}
