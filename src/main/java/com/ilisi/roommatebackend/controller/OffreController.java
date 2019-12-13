package com.ilisi.roommatebackend.controller;

import com.ilisi.roommatebackend.core.exception.BusinessException;
import com.ilisi.roommatebackend.core.utility.ResponseBody;
import com.ilisi.roommatebackend.model.Offre;
import com.ilisi.roommatebackend.service.OffreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/offre")
public class OffreController {
    @Autowired
    OffreService offreService;

    @PostMapping
    public ResponseEntity<ResponseBody<Offre>> insert(@RequestBody() Offre offre){
        Offre off=offreService.create(offre);
        return new ResponseEntity<ResponseBody<Offre>>
                (new ResponseBody<Offre>(offre), HttpStatus.OK) ;
    }
    @PostMapping("/edit")
    public ResponseEntity<ResponseBody<Offre>> edit(@RequestBody() Offre offre){
        return new ResponseEntity<ResponseBody<Offre>>
                (new ResponseBody<Offre>(offreService.update(offre), "Entity updated"), HttpStatus.OK) ;
    }

    @PostMapping("/delete")
    public ResponseEntity<ResponseBody<Offre>> delete(@RequestBody() Offre offre){
        offreService.delete(offre);
        return new ResponseEntity<ResponseBody<Offre>>
                (new ResponseBody<Offre>(), HttpStatus.OK) ;
    }
    @GetMapping
    public ResponseEntity<ResponseBody<List<Offre>>> get(){
        return new ResponseEntity<ResponseBody<List<Offre>>>(
                new ResponseBody<>(offreService.retrieve()), HttpStatus.OK) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseBody<Offre>> getById(@PathVariable("id")int id){
        try {
            Offre offre =offreService.findById(id);
            if(offre!=null) return new ResponseEntity<ResponseBody<Offre>>
                    (new ResponseBody<Offre>(offre), HttpStatus.OK) ;
            return new ResponseEntity<ResponseBody<Offre>>
                    (new ResponseBody<>(null, "Entity not found"), HttpStatus.OK) ;
        }catch(BusinessException e){
            return new ResponseEntity<ResponseBody<Offre>>
                    (new ResponseBody<Offre>(null, "Entity not found"),HttpStatus.NOT_FOUND) ;
        }
    }

}
