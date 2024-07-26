package com.temporintech.animalhaven.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.temporintech.animalhaven.model.AnimalModel;

@Repository
public interface AnimalRepository extends JpaRepository<AnimalModel, UUID> {

    boolean existsBySpeciesId(UUID speciesId);

    boolean existsByShelterId(UUID shelterId);

    boolean existsByVaccineId(UUID vaccineId);

}