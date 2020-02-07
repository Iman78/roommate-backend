package com.ilisi.roommatebackend.service;

import com.ilisi.roommatebackend.model.Profile;
import com.ilisi.roommatebackend.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ProfileService extends BasicService<Profile, Integer> {
    @Autowired
    ProfileRepository profileRepository;

    @Override
    public JpaRepository<Profile, Integer> getRepository() {
        return profileRepository;
    }

    public Profile finByName(String name){
        return profileRepository.findByName(name);
    }
}
