package com.ilisi.roommatebackend.controller;

import com.ilisi.roommatebackend.core.exception.BusinessException;
import com.ilisi.roommatebackend.core.utility.ResponseBody;
import com.ilisi.roommatebackend.dto.ColocataireDto;
import com.ilisi.roommatebackend.dto.DemandeOffreDto;
import com.ilisi.roommatebackend.dto.DemandeOffreMapper;
import com.ilisi.roommatebackend.model.Colocataire;
import com.ilisi.roommatebackend.model.DemandeOffre;
import com.ilisi.roommatebackend.service.DemandeOffreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/demandeOffre")
public class DemandeOffreController {

    @Autowired
    DemandeOffreService demandeOffreService;
    @Autowired
    DemandeOffreMapper demandeOffreMapper;

    @PostMapping
    public ResponseEntity<ResponseBody<DemandeOffre>> insert(@RequestBody() DemandeOffreDto demandeOffredto)  {

        try {
            DemandeOffre demandeOffre = demandeOffreMapper.getEntity(demandeOffredto);

            demandeOffreService.create(demandeOffre);

            return new ResponseEntity<ResponseBody<DemandeOffre>>
                    (new ResponseBody<DemandeOffre>(demandeOffre), HttpStatus.OK);
        }catch(BusinessException e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>
                    (new ResponseBody<>(null, "Entity not found"), HttpStatus.NOT_FOUND);
        }
    }
}
