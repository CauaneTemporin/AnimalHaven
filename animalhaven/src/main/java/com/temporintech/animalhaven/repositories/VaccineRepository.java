package com.temporintech.animalhaven.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.temporintech.animalhaven.model.VaccineModel;

@Repository
public interface VaccineRepository extends JpaRepository<VaccineModel, UUID> {

    boolean existsByDoctorId(UUID doctorId);

}