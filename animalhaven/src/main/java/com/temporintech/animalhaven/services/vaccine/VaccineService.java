package com.temporintech.animalhaven.services.vaccine;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public interface VaccineService {

	boolean existsByDoctorId(UUID doctorId);

} 
