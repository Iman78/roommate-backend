package com.ilisi.roommatebackend.dto;

import com.ilisi.roommatebackend.model.Offre;
import com.ilisi.roommatebackend.model.OffreImages;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AOffreGetMapper {

    public void getDto(Offre entity, AOffreGetDto dto) {
        dto.setId(entity.getId());
        dto.setAdresse(entity.getAdresse());
        dto.setDetail(entity.getDetail());
        dto.setMeuble(entity.isMeuble());
        dto.setWifi(entity.isWifi());
        dto.setNbrPiece(entity.getNbrPiece());
        dto.setNbrPrs(entity.getNbrPrs());
        dto.setPrixLog(entity.getPrixLog());
        dto.setPrixPers(entity.getPrixPers());
        dto.setTitre(entity.getTitre());
        dto.setType(entity.getType());
        dto.setSurface(entity.getSurface());
        dto.setDate(entity.getDate());
        dto.setVille(entity.getVille());
        dto.setListPOI(new ArrayList<>(entity.getListPOI()));
        dto.setListFac(new ArrayList<>(entity.getListFac()));
        List<OffreImages> imgs= entity.getListImg();
        ArrayList<String> imgsDto=new ArrayList<>();

    }

}
