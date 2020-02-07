package com.ilisi.roommatebackend.controller;

import com.ilisi.roommatebackend.core.exception.BusinessException;
import com.ilisi.roommatebackend.core.utility.ResponseBody;
import com.ilisi.roommatebackend.dto.ColocataireDto;
import com.ilisi.roommatebackend.dto.DemandeOffreDto;
import com.ilisi.roommatebackend.dto.DemandeOffreMapper;
import com.ilisi.roommatebackend.model.Colocataire;
import com.ilisi.roommatebackend.model.DemandeOffre;
import com.ilisi.roommatebackend.model.Offre;
import com.ilisi.roommatebackend.service.DemandeOffreService;
import com.ilisi.roommatebackend.service.OffreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/demandeOffre")
public class DemandeOffreController {

    @Autowired
    DemandeOffreService demandeOffreService;
    @Autowired
    OffreService offreService;
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

    @PostMapping("/delete")
    public ResponseEntity<ResponseBody<DemandeOffre>> delete(@RequestBody() DemandeOffre demandeOffre){
        demandeOffreService.delete(demandeOffre);
        return new ResponseEntity<ResponseBody<DemandeOffre>>
                (new ResponseBody<DemandeOffre>(), HttpStatus.OK) ;
    }
    @GetMapping("/offre/{id}")
    public ResponseEntity<ResponseBody<List<DemandeOffre>>> getByOffre(@PathVariable("id")int id){
        try{
            Offre off=offreService.findById(id);
            if(off==null) return new ResponseEntity<>
                    (new ResponseBody<>(null, "Offre not found"), HttpStatus.NOT_FOUND) ;
            List<DemandeOffre> list=
                    demandeOffreService.findDemandeOffreByOffre(off);
            return new ResponseEntity<>
                    (new ResponseBody<>(list),HttpStatus.OK) ;

        }catch(BusinessException e){
            return new ResponseEntity<>
                    (new ResponseBody<>(null, "Offre not found"),HttpStatus.NOT_FOUND) ;
        }
    }
}
