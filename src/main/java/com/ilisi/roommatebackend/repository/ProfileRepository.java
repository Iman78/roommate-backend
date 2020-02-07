package com.ilisi.roommatebackend.repository;

import com.ilisi.roommatebackend.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {

    Profile findByName(String name);
}
