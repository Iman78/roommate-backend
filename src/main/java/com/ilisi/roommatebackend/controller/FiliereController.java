package com.ilisi.roommatebackend.controller;

import com.ilisi.roommatebackend.core.exception.BusinessException;
import com.ilisi.roommatebackend.core.utility.ResponseBody;
import com.ilisi.roommatebackend.model.Faculte;
import com.ilisi.roommatebackend.model.Filiere;
import com.ilisi.roommatebackend.service.FaculteService;
import com.ilisi.roommatebackend.service.FiliereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/filiere")
public class FiliereController  {

    @Autowired
    FiliereService filiereService;

    @Autowired
    FaculteService faculteService;

    @GetMapping
    public ResponseEntity<ResponseBody<List<Filiere>>> get(){
        return new ResponseEntity<ResponseBody<List<Filiere>>>(
                new ResponseBody<>(filiereService.retrieve()), HttpStatus.OK) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseBody<Filiere>> getById(@PathVariable("id")int id){
        try {
            Filiere faculte =filiereService.findById(id);
            if(faculte!=null) return new ResponseEntity<ResponseBody<Filiere>>
                    (new ResponseBody<Filiere>(faculte), HttpStatus.OK) ;
            return new ResponseEntity<ResponseBody<Filiere>>
                    (new ResponseBody<>(null, "Entity not found"), HttpStatus.OK) ;
        }catch(BusinessException e){
            return new ResponseEntity<ResponseBody<Filiere>>
                    (new ResponseBody<Filiere>(null, "Entity not found"),HttpStatus.NOT_FOUND) ;
        }
    }

    @GetMapping("/faculte/{faculteId}")
    public ResponseEntity<ResponseBody<List<Filiere>>> getByFaculte(@PathVariable("faculteId")int id){
        try {
            Faculte faculte =faculteService.findById(id);
            if(faculte!=null) {
                List<Filiere> filieres=filiereService.getByFaculte(faculte);
                if(filieres!=null && !filieres.isEmpty())
                return new ResponseEntity<ResponseBody<List<Filiere>>>
                        (new ResponseBody<List<Filiere>>(filieres), HttpStatus.OK) ;
                else return new ResponseEntity<>
                        (new ResponseBody<>(null, "No entites found"), HttpStatus.OK) ;
            }
            else return new ResponseEntity<>
                    (new ResponseBody<>(null, "Faculty not found"), HttpStatus.OK) ;
        }catch(BusinessException e){
            return new ResponseEntity<>
                    (new ResponseBody<>(null, "Entity not found"),HttpStatus.NOT_FOUND) ;
        }
    }

}