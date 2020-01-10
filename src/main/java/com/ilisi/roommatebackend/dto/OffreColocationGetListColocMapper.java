package com.ilisi.roommatebackend.dto;

import com.ilisi.roommatebackend.model.OffreColocation;
import com.ilisi.roommatebackend.model.OffreImages;
import org.springframework.stereotype.Component;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Component
public class OffreColocationGetListColocMapper extends AOffreGetMapper {

    public OffreColocationGetListColocDto getDto(OffreColocation entity) {
        OffreColocationGetListColocDto dto=new OffreColocationGetListColocDto();
        super.getDto(entity, dto);
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

    public List<OffreColocationGetListColocDto> getDto(List<OffreColocation> entities) {
        List<OffreColocationGetListColocDto> dtos=new ArrayList<>();
        for(OffreColocation offre: entities) dtos.add(getDto(offre));
        return dtos;
    }
}
