package com.ilisi.roommatebackend.service;

import com.ilisi.roommatebackend.model.Faculte;
import com.ilisi.roommatebackend.model.Offre;
import com.ilisi.roommatebackend.repository.FaculteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaculteService extends  BasicService<Faculte, Integer>{
    @Autowired
    FaculteRepository faculteRepository;
    @Override
    public List<Faculte> retrieve() { return getRepository().findAll();    }
    @Override
    public JpaRepository<Faculte, Integer> getRepository() {
        return faculteRepository;
    }
}
