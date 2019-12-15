package com.ilisi.roommatebackend.service;

import com.ilisi.roommatebackend.model.Faculte;
import com.ilisi.roommatebackend.model.Filiere;
import com.ilisi.roommatebackend.repository.FaculteRepository;
import com.ilisi.roommatebackend.repository.FiliereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FiliereService extends  BasicService<Filiere, Integer> {

    @Autowired
    FiliereRepository filiereRepository;

    @Override
    public JpaRepository<Filiere, Integer> getRepository() {
        return filiereRepository;
    }

    public List<Filiere> getByFaculte(Faculte faculte){
        return filiereRepository.findAllByFaculte(faculte);
    }
}
