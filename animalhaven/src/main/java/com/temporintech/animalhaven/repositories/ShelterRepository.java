package com.temporintech.animalhaven.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.temporintech.animalhaven.model.ShelterModel;

@Repository
public interface ShelterRepository extends JpaRepository<ShelterModel, UUID> {

}