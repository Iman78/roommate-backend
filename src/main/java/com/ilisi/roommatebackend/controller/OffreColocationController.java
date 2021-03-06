package com.ilisi.roommatebackend.controller;


import com.ilisi.roommatebackend.core.exception.BusinessException;
import com.ilisi.roommatebackend.core.utility.ResponseBody;
import com.ilisi.roommatebackend.dto.*;
import com.ilisi.roommatebackend.model.Colocataire;
import com.ilisi.roommatebackend.model.OffreColocation;
import com.ilisi.roommatebackend.service.ColocataireService;
import com.ilisi.roommatebackend.service.OffreColocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/offrecolocation")
public class OffreColocationController {

    @Autowired
    OffreColocationService offreService;

    @Autowired
    OffreColocationMapper offreMapper;

    @Autowired
    ColocataireService colocataireService;

    @Autowired
    OffreColocationGetListMapper  offreColocationGetListMapper;

    @Autowired
    OffreColocationGetDetailsMapper offreColocationGetDetailsMapper;

    @Autowired
    OffreColocationGetListColocMapper offreColocationGetListColocMapper;


    @PostMapping
    public ResponseEntity<ResponseBody<OffreColocation>> insert(@RequestBody() OffreColocationDto offre){
        try {
            OffreColocation offreEntity = offreMapper.getEntity(offre);
            offreService.create(offreEntity);
            return new ResponseEntity<>
                    (new ResponseBody<>(offreEntity), HttpStatus.OK);
        }catch(BusinessException e){
            return new ResponseEntity<>
                    (new ResponseBody<>(null, e.getMessage()), HttpStatus.OK);
        }
    }
    @PostMapping("/edit")
    public ResponseEntity<ResponseBody<OffreColocation>> edit(@RequestBody() OffreColocationDto offre){
        try {
        OffreColocation offreEntity = offreMapper.getEntity(offre);
        return new ResponseEntity<>
                (new ResponseBody<>(offreService.update(offreEntity), "Entity updated"), HttpStatus.OK) ;
        }catch(BusinessException e){
            return new ResponseEntity<>
                    (new ResponseBody<>(null, e.getMessage()), HttpStatus.OK);
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<ResponseBody<OffreColocation>> delete(@RequestBody() OffreColocation offre){
        offreService.delete(offre);
        return new ResponseEntity<>
                (new ResponseBody<>(), HttpStatus.OK) ;
    }
    @GetMapping
    public ResponseEntity<ResponseBody<List<OffreColocationGetListDto>>> get(){
        return new ResponseEntity<>(
                new ResponseBody<>(offreColocationGetListMapper.getDto(offreService.retrieve())), HttpStatus.OK) ;
    }

    @GetMapping("/colocataire/{id}")
    public ResponseEntity<ResponseBody<List<OffreColocationGetListColocDto>>> getByLocateur(@PathVariable("id")int id){
        try{
            Colocataire loc=colocataireService.findById(id);
            if(loc==null) return new ResponseEntity<>
                    (new ResponseBody<>(null, "Locateur not found"), HttpStatus.NOT_FOUND) ;
            List<OffreColocationGetListColocDto> list=offreColocationGetListColocMapper.getDto(
                    offreService.findOffreByColocataire(loc)
            );
            return new ResponseEntity<>
                    (new ResponseBody<>(list),HttpStatus.OK) ;

        }catch(BusinessException e){
            return new ResponseEntity<>
                    (new ResponseBody<>(null, "Locateur not found"),HttpStatus.NOT_FOUND) ;
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseBody<OffreColocationGetDetailsDto>> getById(@PathVariable("id")int id){
        try {
            OffreColocation offre =offreService.findById(id);
            if(offre!=null) return new ResponseEntity<>
                    (new ResponseBody<>(offreColocationGetDetailsMapper.getDto(offre)), HttpStatus.OK) ;
            return new ResponseEntity<>
                    (new ResponseBody<>(null, "Entity not found"), HttpStatus.OK) ;
        }catch(BusinessException e){
            return new ResponseEntity<>
                    (new ResponseBody<>(null, "Entity not found"),HttpStatus.NOT_FOUND) ;
        }
    }
}
