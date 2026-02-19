package com.temporintech.animalhaven.repositories.animal;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.temporintech.animalhaven.model.animal.VaccineModel;

@Repository
public interface VaccineRepository extends JpaRepository<VaccineModel, UUID> {

    boolean existsByVolunteersId(UUID doctorId);

}