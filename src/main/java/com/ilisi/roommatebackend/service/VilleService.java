package com.ilisi.roommatebackend.service;


import com.ilisi.roommatebackend.model.Ville;
import com.ilisi.roommatebackend.repository.VilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


@Service
public class VilleService extends  BasicService<Ville, Integer>{
    @Autowired
    VilleRepository villeRepository;
    @Override
    public JpaRepository<Ville, Integer> getRepository() {
        return villeRepository ;
    }
}
