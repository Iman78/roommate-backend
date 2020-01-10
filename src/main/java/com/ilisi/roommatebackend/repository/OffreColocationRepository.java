package com.ilisi.roommatebackend.repository;

import com.ilisi.roommatebackend.model.Colocataire;
import com.ilisi.roommatebackend.model.OffreColocation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OffreColocationRepository extends JpaRepository<OffreColocation, Integer> {

    List<OffreColocation> findAllByColocataire(Colocataire colocataire);


}
