package com.ilisi.roommatebackend.repository;

import com.ilisi.roommatebackend.model.Offre;
import com.ilisi.roommatebackend.model.OffreLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OffreLocationRepository extends JpaRepository<OffreLocation, Integer> {
}
