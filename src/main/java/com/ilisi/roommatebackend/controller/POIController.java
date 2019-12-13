package com.ilisi.roommatebackend.controller;

import com.ilisi.roommatebackend.core.exception.BusinessException;
import com.ilisi.roommatebackend.core.utility.ResponseBody;
import com.ilisi.roommatebackend.model.POI;
import com.ilisi.roommatebackend.model.Ville;
import com.ilisi.roommatebackend.service.POIService;
import com.ilisi.roommatebackend.service.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/poi")

public class POIController {
    @Autowired
    POIService poiService;
    @GetMapping
    public ResponseEntity<ResponseBody<List<POI>>> get(){
        return new ResponseEntity<ResponseBody<List<POI>>>(
                new ResponseBody<>(poiService.retrieve()), HttpStatus.OK) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseBody<POI>> getById(@PathVariable("id")int id){
        try {
            POI poi =poiService.findById(id);
            if(poi!=null) return new ResponseEntity<ResponseBody<POI>>
                    (new ResponseBody<POI>(poi), HttpStatus.OK) ;
            return new ResponseEntity<ResponseBody<POI>>
                    (new ResponseBody<>(null, "Entity not found"), HttpStatus.OK) ;
        }catch(BusinessException e){
            return new ResponseEntity<ResponseBody<POI>>
                    (new ResponseBody<POI>(null, "Entity not found"),HttpStatus.NOT_FOUND) ;
        }
    }
}
