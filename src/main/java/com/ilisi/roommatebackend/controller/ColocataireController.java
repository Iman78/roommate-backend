package com.ilisi.roommatebackend.controller;

import com.ilisi.roommatebackend.core.exception.BusinessException;
import com.ilisi.roommatebackend.core.exception.utility.ResponseBody;
import com.ilisi.roommatebackend.model.Colocataire;
import com.ilisi.roommatebackend.service.ColocataireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/colocataire")
public class ColocataireController {

    @Autowired
    ColocataireService colocataireService;

    @PostMapping
    public ResponseEntity<ResponseBody<Colocataire>> insert(@RequestBody() Colocataire colocataire){
        Colocataire coloc=colocataireService.create(colocataire);
        return new ResponseEntity<ResponseBody<Colocataire>>
                (new ResponseBody<Colocataire>(), HttpStatus.OK) ;
    }

    @PostMapping("/edit")
    public ResponseEntity<Colocataire> edit(@RequestBody() Colocataire colocataire){
        return new ResponseEntity<Colocataire>(colocataireService.update(colocataire), HttpStatus.OK) ;
    }

    @PostMapping("/delete")
    public ResponseEntity<Colocataire> delete(@RequestBody() Colocataire colocataire){
        colocataireService.delete(colocataire);
        return new ResponseEntity<>(null, HttpStatus.OK) ;
    }

    @GetMapping
    public ResponseEntity<List<Colocataire>> get(){
        return new ResponseEntity<List<Colocataire>>(colocataireService.retrieve(), HttpStatus.OK) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Colocataire> getById(@PathVariable("id")int id){
        try {
            return new ResponseEntity<Colocataire>(colocataireService.findById(id), HttpStatus.OK) ;
        }catch(BusinessException e){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND) ;
        }
    }
}
