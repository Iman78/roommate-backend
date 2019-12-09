package com.ilisi.roommatebackend.service;

import com.ilisi.roommatebackend.model.Locateur;
import com.ilisi.roommatebackend.repository.ColocataireRepository;
import com.ilisi.roommatebackend.repository.LocateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LocateurService extends  BasicService<Locateur, Integer>{

    @Autowired
    private LocateurRepository locateurRepository;

    private BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

    @Override
    public Locateur create(Locateur entity) {
        if (entity == null) {
            //exception
        }
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        return getRepository().save(entity);
    }


    @Override
    public JpaRepository<Locateur, Integer> getRepository() {
        return locateurRepository;
    }
}