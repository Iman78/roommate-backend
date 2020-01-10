package com.ilisi.roommatebackend.dto;

import com.ilisi.roommatebackend.model.OffreImages;
import com.ilisi.roommatebackend.model.OffreLocation;
import org.springframework.stereotype.Component;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;

@Component
public class OffreLocationGetDetailsMapper extends AOffreGetMapper {

    public OffreLocationGetDetailsDto getDto(OffreLocation entity) {
        OffreLocationGetDetailsDto dto=new OffreLocationGetDetailsDto();
        super.getDto(entity, dto);
        dto.setLocateur(entity.getLocateur());
        ArrayList<String> imgsDto=new ArrayList<>();
        for(OffreImages i: entity.getListImg()){
            Blob blob =i.getImage();
            try {
                String img=Base64.getEncoder().encodeToString(blob.getBytes(1, (int)blob.length()));
                if(i.isMain()) dto.setMainImage(img);
                else imgsDto.add(img);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        dto.setListImg(imgsDto);

        return dto;
    }
}
