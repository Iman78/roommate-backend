package com.ilisi.roommatebackend.controller;

import com.ilisi.roommatebackend.core.exception.BusinessException;
import com.ilisi.roommatebackend.model.Locateur;
import com.ilisi.roommatebackend.service.LocateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/locateur")
public class LocateurController {

    @Autowired
    LocateurService colocataireService;

    @PostMapping
    public ResponseEntity<Locateur> insert(@RequestBody() Locateur colocataire){
        return new ResponseEntity<Locateur>(colocataireService.create(colocataire), HttpStatus.OK) ;
    }

    @PostMapping("/edit")
    public ResponseEntity<Locateur> edit(@RequestBody() Locateur colocataire){
        return new ResponseEntity<Locateur>(colocataireService.update(colocataire), HttpStatus.OK) ;
    }

    @PostMapping("/delete")
    public ResponseEntity<Locateur> delete(@RequestBody() Locateur colocataire){
        colocataireService.delete(colocataire);
        return new ResponseEntity<>(null, HttpStatus.OK) ;
    }

    @GetMapping
    public ResponseEntity<List<Locateur>> get(){
        return new ResponseEntity<List<Locateur>>(colocataireService.retrieve(), HttpStatus.OK) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Locateur> getById(@PathVariable("id")int id){
        try {
            return new ResponseEntity<Locateur>(colocataireService.findById(id), HttpStatus.OK) ;
        }catch(BusinessException e){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND) ;
        }
    }
}
