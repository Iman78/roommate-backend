package com.ilisi.roommatebackend.controller;

import com.ilisi.roommatebackend.core.exception.BusinessException;
import com.ilisi.roommatebackend.core.utility.ResponseBody;
import com.ilisi.roommatebackend.model.Faculte;
import com.ilisi.roommatebackend.model.Ville;
import com.ilisi.roommatebackend.service.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/ville")
public class VilleController {
    @Autowired
    VilleService villeService;
    @GetMapping
    public ResponseEntity<ResponseBody<List<Ville>>> get(){
        return new ResponseEntity<ResponseBody<List<Ville>>>(
                new ResponseBody<>(villeService.retrieve()), HttpStatus.OK) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseBody<Ville>> getById(@PathVariable("id")int id){
        try {
            Ville ville =villeService.findById(id);
            if(ville!=null) return new ResponseEntity<ResponseBody<Ville>>
                    (new ResponseBody<Ville>(ville), HttpStatus.OK) ;
            return new ResponseEntity<ResponseBody<Ville>>
                    (new ResponseBody<>(null, "Entity not found"), HttpStatus.OK) ;
        }catch(BusinessException e){
            return new ResponseEntity<ResponseBody<Ville>>
                    (new ResponseBody<Ville>(null, "Entity not found"),HttpStatus.NOT_FOUND) ;
        }
    }
}

