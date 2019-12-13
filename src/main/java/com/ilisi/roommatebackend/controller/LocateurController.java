package com.ilisi.roommatebackend.controller;

import com.ilisi.roommatebackend.core.exception.BusinessException;
import com.ilisi.roommatebackend.core.utility.ResponseBody;
import com.ilisi.roommatebackend.model.Locateur;
import com.ilisi.roommatebackend.service.LocateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/locateur")
public class LocateurController {

    @Autowired
    LocateurService locateurService;

    @PostMapping
    public ResponseEntity<ResponseBody<Locateur>> insert(@RequestBody() Locateur locateur){
        Locateur locat=locateurService.create(locateur);
        return new ResponseEntity<ResponseBody<Locateur>>
                (new ResponseBody<Locateur>(locat), HttpStatus.OK) ;
    }

    @PostMapping("/edit")
    public ResponseEntity<ResponseBody<Locateur>> edit(@RequestBody() Locateur locateur){
        return new ResponseEntity<ResponseBody<Locateur>>
                (new ResponseBody<Locateur>(locateurService.update(locateur), "Entity updated"), HttpStatus.OK) ;
    }

    @PostMapping("/delete")
    public ResponseEntity<ResponseBody<Locateur>> delete(@RequestBody() Locateur locateur){
        locateurService.delete(locateur);
        return new ResponseEntity<ResponseBody<Locateur>>
                (new ResponseBody<Locateur>(), HttpStatus.OK) ;
    }

    @GetMapping
    public ResponseEntity<ResponseBody<List<Locateur>>> get(){
        return new ResponseEntity<ResponseBody<List<Locateur>>>(
                new ResponseBody<>(locateurService.retrieve()), HttpStatus.OK) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseBody<Locateur>> getById(@PathVariable("id")int id){
        try {
            Locateur locateur =locateurService.findById(id);
            if(locateur!=null) return new ResponseEntity<ResponseBody<Locateur>>
                    (new ResponseBody<Locateur>(locateur), HttpStatus.OK) ;
            return new ResponseEntity<ResponseBody<Locateur>>
                    (new ResponseBody<>(null, "Entity not found"), HttpStatus.OK) ;
        }catch(BusinessException e){
            return new ResponseEntity<ResponseBody<Locateur>>
                    (new ResponseBody<Locateur>(null, "Entity not found"),HttpStatus.NOT_FOUND) ;
        }
    }
}
