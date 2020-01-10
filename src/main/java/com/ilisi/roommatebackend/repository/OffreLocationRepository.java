package com.ilisi.roommatebackend.repository;

import com.ilisi.roommatebackend.model.Locateur;
import com.ilisi.roommatebackend.model.Offre;
import com.ilisi.roommatebackend.model.OffreLocation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OffreLocationRepository extends JpaRepository<OffreLocation, Integer> {

    List<OffreLocation> findAllByLocateur(Locateur locateur);
}
