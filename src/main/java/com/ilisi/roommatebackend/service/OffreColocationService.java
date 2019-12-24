package com.ilisi.roommatebackend.service;

import com.ilisi.roommatebackend.model.OffreColocation;
import com.ilisi.roommatebackend.repository.OffreColocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class OffreColocationService extends  BasicService<OffreColocation, Integer>{

    @Autowired
    private OffreColocationRepository offreRepository;

    @Override
    public JpaRepository<OffreColocation, Integer> getRepository() {
        return offreRepository;
    }
}

