package com.ilisi.roommatebackend.controller;

import com.ilisi.roommatebackend.core.exception.BusinessException;
import com.ilisi.roommatebackend.core.utility.ResponseBody;
import com.ilisi.roommatebackend.dto.OffreDto;
import com.ilisi.roommatebackend.dto.OffreMapper;
import com.ilisi.roommatebackend.model.Offre;
import com.ilisi.roommatebackend.model.OffreLocation;
import com.ilisi.roommatebackend.service.OffreLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/offrelocation")
public class OffreLocationController {

    @Autowired
    OffreLocationService offreService;

    @Autowired
    OffreMapper offreMapper;

    @PostMapping
    public ResponseEntity<ResponseBody<OffreLocation>> insert(@RequestBody() OffreDto offre){
        try {
            OffreLocation offreEntity = offreMapper.getEntity(offre);
            offreService.create(offreEntity);
            return new ResponseEntity<>
                    (new ResponseBody<>(offreEntity), HttpStatus.OK);
        }catch(BusinessException e){
            return new ResponseEntity<>
                    (new ResponseBody<>(null, e.getMessage()), HttpStatus.OK);
        }
    }
    @PostMapping("/edit")
    public ResponseEntity<ResponseBody<OffreLocation>> edit(@RequestBody() OffreDto offre){
        try {
            OffreLocation offreEntity = offreMapper.getEntity(offre);
            offreService.update(offreEntity);
            return new ResponseEntity<>
                    (new ResponseBody<>(offreEntity), HttpStatus.OK);
        }catch(BusinessException e){
            return new ResponseEntity<>
                    (new ResponseBody<>(null, e.getMessage()), HttpStatus.OK);
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<ResponseBody<OffreLocation>> delete(@RequestBody() OffreLocation offre){
        offreService.delete(offre);
        return new ResponseEntity<>
                (new ResponseBody<>(), HttpStatus.OK) ;
    }
    @GetMapping
    public ResponseEntity<ResponseBody<List<OffreLocation>>> get(){
        return new ResponseEntity<>(
                new ResponseBody<>(offreService.retrieve()), HttpStatus.OK) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseBody<OffreLocation>> getById(@PathVariable("id")int id){
        try {
            OffreLocation offre =offreService.findById(id);
            if(offre!=null) return new ResponseEntity<>
                    (new ResponseBody<>(offre), HttpStatus.OK) ;
            return new ResponseEntity<>
                    (new ResponseBody<>(null, "Entity not found"), HttpStatus.OK) ;
        }catch(BusinessException e){
            return new ResponseEntity<>
                    (new ResponseBody<>(null, "Entity not found"),HttpStatus.NOT_FOUND) ;
        }
    }

}
