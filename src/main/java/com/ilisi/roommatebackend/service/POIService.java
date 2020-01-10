package com.ilisi.roommatebackend.service;

import com.ilisi.roommatebackend.model.Offre;
import com.ilisi.roommatebackend.model.POI;
import com.ilisi.roommatebackend.repository.POIRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class POIService extends  BasicService<POI, Integer> {

    @Autowired
    private POIRepository poiRepository;
    @Override
    public JpaRepository<POI, Integer> getRepository() {
        return poiRepository;
    }
}
