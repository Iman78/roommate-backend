package com.ilisi.roommatebackend.dto;

import com.ilisi.roommatebackend.core.exception.BusinessException;
import com.ilisi.roommatebackend.model.*;
import com.ilisi.roommatebackend.service.FaculteService;
import com.ilisi.roommatebackend.service.LocateurService;
import com.ilisi.roommatebackend.service.POIService;
import com.ilisi.roommatebackend.service.VilleService;
import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashSet;
import java.util.List;

@Component
public class OffreMapper {
    @Autowired
    LocateurService locateurService;

    @Autowired
    POIService poiService;

    @Autowired
    VilleService villeService;

    @Autowired
    FaculteService faculteService;

    public OffreLocation getEntity(OffreDto dto) throws BusinessException {

        OffreLocation offre=new OffreLocation();
        offre.setAdresse(dto.getAdresse());
        offre.setDetail(dto.getDetail());
        offre.setMeuble(dto.isMeuble());
        offre.setWifi(dto.isWifi());
        offre.setNbrPiece(dto.getNbrPiece());
        offre.setNbrPrs(dto.getNbrPrs());
        offre.setPrixLog(dto.getPrixLog());
        offre.setPrixPers(dto.getPrixPers());
        offre.setTitre(dto.getTitre());
        offre.setType(dto.getType());
        offre.setSurface(dto.getSurface());
        offre.setDate(LocalDateTime.now());

        Locateur locateur= locateurService.findById(dto.getLocateur());
        offre.setLocateur(locateur);

        Ville villeEntity=villeService.findById(dto.getVille());
        offre.setVille(villeEntity);

        offre.setListPOI(new HashSet<>());
        for(int id : dto.getListPOI()){
            POI poi =poiService.findById(id);
            offre.getListPOI().add(poi);
        }


        offre.setListFac(new HashSet<>());
        for(int id : dto.getListFac()){
            Faculte fac =faculteService.findById(id);
            offre.getListFac().add(fac);
        }

        List<String> imgsDto= dto.getListImg();
        ArrayList<OffreImages> imgs=new ArrayList<>();
        for(String i: imgsDto){
            byte[] img= Base64.getDecoder().decode(i.getBytes());
            OffreImages offreImages=new OffreImages();
            offreImages.setImage(BlobProxy.generateProxy(img));
            offreImages.setOffre(offre);
            imgs.add(offreImages);
        }
        offre.setListImg(imgs);

        return offre;

    }
}
