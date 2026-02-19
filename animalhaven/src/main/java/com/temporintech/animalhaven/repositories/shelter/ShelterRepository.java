package com.temporintech.animalhaven.repositories.shelter;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.temporintech.animalhaven.model.shelter.ShelterModel;

@Repository
public interface ShelterRepository extends JpaRepository<ShelterModel, UUID> {

}