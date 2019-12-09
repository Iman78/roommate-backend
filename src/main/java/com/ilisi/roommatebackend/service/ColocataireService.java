package com.ilisi.roommatebackend.service;

import com.ilisi.roommatebackend.model.Colocataire;
import com.ilisi.roommatebackend.model.Locateur;
import com.ilisi.roommatebackend.repository.ColocataireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ColocataireService extends  BasicService<Colocataire, Integer>{

    @Autowired
    private ColocataireRepository colocataireRepository;

    private BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

    @Override
    public Colocataire create(Colocataire entity) {
        if (entity == null) {
            //exception
        }
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        return getRepository().save(entity);
    }


    @Override
    public JpaRepository<Colocataire, Integer> getRepository() {
        return colocataireRepository;
    }
}
