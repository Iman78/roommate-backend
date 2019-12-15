package com.ilisi.roommatebackend.repository;

import com.ilisi.roommatebackend.model.Faculte;
import com.ilisi.roommatebackend.model.Filiere;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface FiliereRepository extends JpaRepository<Filiere, Integer> {

    List<Filiere> findAllByFaculte(Faculte faculte);
}

