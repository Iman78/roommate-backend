package com.ilisi.roommatebackend.service;

import com.ilisi.roommatebackend.model.DemandeOffre;
import com.ilisi.roommatebackend.model.Offre;
import com.ilisi.roommatebackend.repository.DemandeOffreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemandeOffreService extends BasicService<DemandeOffre, Integer> {

    @Autowired
    DemandeOffreRepository demandeOffreRepository;

    @Override
    public JpaRepository<DemandeOffre, Integer> getRepository() {
        return demandeOffreRepository;
    }

    public List<DemandeOffre> findDemandeOffreByOffre(Offre offre){
        return this.demandeOffreRepository.findAllByOffre(offre);
    }
}
