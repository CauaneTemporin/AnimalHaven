package com.temporintech.animalhaven.services.vaccine;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.temporintech.animalhaven.dtos.VaccineRecordDTO;
import com.temporintech.animalhaven.model.VaccineModel;

@Service
public interface VaccineService {
	
	VaccineModel save(VaccineRecordDTO dto);

	VaccineModel update(UUID id, VaccineRecordDTO dto);

	List<VaccineModel> findAll();

	VaccineModel findById(UUID id);

	void delete(UUID id);

	boolean existsByDoctorId(UUID doctorId);

} 
