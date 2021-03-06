package com.ilisi.roommatebackend.repository;

import com.ilisi.roommatebackend.model.Faculte;
import com.ilisi.roommatebackend.model.Ville;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FaculteRepository extends JpaRepository<Faculte, Integer> {

    List<Faculte> findAllByVille(Ville ville);

}
