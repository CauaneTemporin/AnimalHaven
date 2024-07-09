package com.temporintech.animalhaven.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.temporintech.animalhaven.model.DoctorModel;

public interface DoctorRepository extends JpaRepository<DoctorModel, UUID>{

}