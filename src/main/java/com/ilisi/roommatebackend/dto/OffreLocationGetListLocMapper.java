package com.ilisi.roommatebackend.dto;

import com.ilisi.roommatebackend.model.Offre;
import com.ilisi.roommatebackend.model.OffreImages;
import com.ilisi.roommatebackend.model.OffreLocation;
import org.springframework.stereotype.Component;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Component
public class OffreLocationGetListLocMapper extends AOffreGetMapper {

    public OffreLocationGetListLocDto getDto(OffreLocation entity) {
        OffreLocationGetListLocDto dto=new OffreLocationGetListLocDto();
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

    public List<OffreLocationGetListLocDto> getDto(List<OffreLocation> entities) {
        List<OffreLocationGetListLocDto> dtos=new ArrayList<>();
        for(OffreLocation offre: entities) dtos.add(getDto(offre));
        return dtos;
    }

}
