package com.ilisi.roommatebackend.repository;

import com.ilisi.roommatebackend.model.POI;
import org.springframework.data.jpa.repository.JpaRepository;

public interface POIRepository extends JpaRepository<POI, Integer> {
}
