package com.ilisi.roommatebackend.service;

import com.ilisi.roommatebackend.model.DemandeOffre;
import org.springframework.data.jpa.repository.JpaRepository;

public class DemandeOffreService extends BasicService<DemandeOffre, Integer> {


    @Override
    public JpaRepository<DemandeOffre, Integer> getRepository() {
        return null;
    }
}
