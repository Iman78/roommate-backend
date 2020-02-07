package com.ilisi.roommatebackend.repository;

import com.ilisi.roommatebackend.model.DemandeOffre;
import com.ilisi.roommatebackend.model.Offre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DemandeOffreRepository extends JpaRepository<DemandeOffre, Integer> {

    List<DemandeOffre> findAllByOffre(Offre offre);

}
