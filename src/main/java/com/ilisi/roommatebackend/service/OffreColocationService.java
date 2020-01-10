package com.ilisi.roommatebackend.service;

import com.ilisi.roommatebackend.model.Colocataire;
import com.ilisi.roommatebackend.model.OffreColocation;
import com.ilisi.roommatebackend.repository.OffreColocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OffreColocationService extends  BasicService<OffreColocation, Integer>{

    @Autowired
    private OffreColocationRepository offreRepository;

    @Override
    public JpaRepository<OffreColocation, Integer> getRepository() {
        return offreRepository;
    }

    public List<OffreColocation> findOffreByColocataire(Colocataire colocataire){
        return this.offreRepository.findAllByColocataire(colocataire);
    }
}

