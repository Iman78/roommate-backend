package com.ilisi.roommatebackend.controller;

import com.ilisi.roommatebackend.core.exception.BusinessException;
import com.ilisi.roommatebackend.core.utility.ResponseBody;
import com.ilisi.roommatebackend.model.Colocataire;
import com.ilisi.roommatebackend.model.Faculte;
import com.ilisi.roommatebackend.service.FaculteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/faculte")
public class FaculteController  {
    @Autowired
    FaculteService faculteService;
    @GetMapping
    public ResponseEntity<ResponseBody<List<Faculte>>> get(){
        return new ResponseEntity<ResponseBody<List<Faculte>>>(
                new ResponseBody<>(faculteService.retrieve()), HttpStatus.OK) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseBody<Faculte>> getById(@PathVariable("id")int id){
        try {
            Faculte faculte =faculteService.findById(id);
            if(faculte!=null) return new ResponseEntity<ResponseBody<Faculte>>
                    (new ResponseBody<Faculte>(faculte), HttpStatus.OK) ;
            return new ResponseEntity<ResponseBody<Faculte>>
                    (new ResponseBody<>(null, "Entity not found"), HttpStatus.OK) ;
        }catch(BusinessException e){
            return new ResponseEntity<ResponseBody<Faculte>>
                    (new ResponseBody<Faculte>(null, "Entity not found"),HttpStatus.NOT_FOUND) ;
        }
    }

}
