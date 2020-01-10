package com.ilisi.roommatebackend.service;

import com.ilisi.roommatebackend.model.Locateur;
import com.ilisi.roommatebackend.model.OffreLocation;
import com.ilisi.roommatebackend.model.OffreLocation;
import com.ilisi.roommatebackend.repository.OffreLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OffreLocationService extends  BasicService<OffreLocation, Integer>{

    @Autowired
    private OffreLocationRepository offreRepository;

    @Override
    public JpaRepository<OffreLocation, Integer> getRepository() {
        return offreRepository;
    }


    public List<OffreLocation> findOffreByLocateur(Locateur locateur){
        return this.offreRepository.findAllByLocateur(locateur);
    }
}
