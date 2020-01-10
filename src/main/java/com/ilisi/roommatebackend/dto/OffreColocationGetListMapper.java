package com.ilisi.roommatebackend.dto;

import com.ilisi.roommatebackend.model.OffreColocation;
import com.ilisi.roommatebackend.model.OffreImages;
import com.ilisi.roommatebackend.model.OffreLocation;
import org.springframework.stereotype.Component;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Component
public class OffreColocationGetListMapper extends AOffreGetMapper {

    public OffreColocationGetListDto getDto(OffreColocation entity) {
        OffreColocationGetListDto dto=new OffreColocationGetListDto();
        super.getDto(entity, dto);
        dto.setColocataire(entity.getColocataire());
        for(OffreImages i: entity.getListImg()){
            if(i.isMain()) {
                Blob blob =i.getImage();
                try {
                    String img= Base64.getEncoder().encodeToString(blob.getBytes(1, (int)blob.length()));
                    dto.setMainImage(img);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return dto;
    }

    public List<OffreColocationGetListDto> getDto(List<OffreColocation> entities) {
        List<OffreColocationGetListDto> dtos=new ArrayList<>();
        for(OffreColocation offre: entities) dtos.add(getDto(offre));
        return dtos;
    }
}
