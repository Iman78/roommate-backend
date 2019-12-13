package com.ilisi.roommatebackend.service;

import com.ilisi.roommatebackend.model.Offre;
import com.ilisi.roommatebackend.repository.OffreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OffreService extends  BasicService<Offre, Integer>{
    @Autowired
    private OffreRepository offreRepository;
    @Override
    public JpaRepository<Offre, Integer> getRepository() {
        return offreRepository;
    }
}
