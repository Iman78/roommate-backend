package com.ilisi.roommatebackend.service;

import com.ilisi.roommatebackend.model.Locateur;
import com.ilisi.roommatebackend.repository.ColocataireRepository;
import com.ilisi.roommatebackend.repository.LocateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class LocateurService extends  BasicService<Locateur, Integer>{

    @Autowired
    private LocateurRepository locateurRepository;


    @Override
    public JpaRepository<Locateur, Integer> getRepository() {
        return locateurRepository;
    }
}