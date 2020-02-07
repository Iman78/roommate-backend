package com.ilisi.roommatebackend.controller;

import com.ilisi.roommatebackend.core.exception.BusinessException;
import com.ilisi.roommatebackend.core.utility.ResponseBody;
import com.ilisi.roommatebackend.dto.*;
import com.ilisi.roommatebackend.model.Locateur;
import com.ilisi.roommatebackend.model.OffreImages;
import com.ilisi.roommatebackend.model.OffreLocation;
import com.ilisi.roommatebackend.service.LocateurService;
import com.ilisi.roommatebackend.service.OffreLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/offrelocation")
public class OffreLocationController {

    @Autowired
    OffreLocationService offreService;

    @Autowired
    LocateurService locateurService;

    @Autowired
    OffreMapper offreMapper;

    @Autowired
    OffreLocationGetListMapper offreLocationGetListMapper;

    @Autowired
    OffreLocationGetDetailsMapper offreLocationGetDetailsMapper;

    @Autowired
    OffreLocationGetListLocMapper offreLocationGetListLocMapper;
/*
    @GetMapping("/image/{id}")
    public @org.springframework.web.bind.annotation.ResponseBody
                 HttpEntity<byte[]> getImageOffre(@PathVariable int id) {
        byte[] bytes=null;
        try{
            //bytes = ;
            System.out.println(offreService.findById(id).getListImg());
            OffreLocation offre=offreService.findById(id);
            List<OffreImages> list=offre.getListImg();
            OffreImages img= list.get(0);
            bytes=img.getImage().getBytes(1, -1);

        }catch(Exception e){

        }

        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=image=.jpeg");
        headers.setContentLength(bytes.length);
        return new HttpEntity<>(bytes, headers);
    }
    */

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
    public ResponseEntity<ResponseBody<List<OffreLocationGetListDto>>> get(){
        return new ResponseEntity<>(
                new ResponseBody<>(offreLocationGetListMapper.getDto(offreService.retrieve())), HttpStatus.OK) ;
    }

    @GetMapping("/locateur/{id}")
    public ResponseEntity<ResponseBody<List<OffreLocationGetListLocDto>>> getByLocateur(@PathVariable("id")int id){
        try{
            Locateur loc=locateurService.findById(id);
            if(loc==null) return new ResponseEntity<>
                    (new ResponseBody<>(null, "Locateur not found"), HttpStatus.NOT_FOUND) ;
            List<OffreLocationGetListLocDto> list=this.offreLocationGetListLocMapper.getDto(
                    offreService.findOffreByLocateur(loc));

            return new ResponseEntity<>
                    (new ResponseBody<>(list),HttpStatus.OK) ;

        }catch(BusinessException e){
            return new ResponseEntity<>
                    (new ResponseBody<>(null, "Locateur not found"),HttpStatus.NOT_FOUND) ;
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseBody<OffreLocationGetDetailsDto>> getById(@PathVariable("id")int id){
        try {
            OffreLocation offre =offreService.findById(id);
            if(offre!=null) return new ResponseEntity<>
                    (new ResponseBody<>(offreLocationGetDetailsMapper.getDto(offre)), HttpStatus.OK) ;
            return new ResponseEntity<>
                    (new ResponseBody<>(null, "Entity not found"), HttpStatus.OK) ;
        }catch(BusinessException e){
            return new ResponseEntity<>
                    (new ResponseBody<>(null, "Entity not found"),HttpStatus.NOT_FOUND) ;
        }
    }

}
