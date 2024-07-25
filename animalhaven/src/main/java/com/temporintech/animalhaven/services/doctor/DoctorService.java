package com.temporintech.animalhaven.services.doctor;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.temporintech.animalhaven.dtos.DoctorRecordDTO;
import com.temporintech.animalhaven.model.DoctorModel;


@Service
public interface DoctorService {

	DoctorModel save(DoctorRecordDTO dto);

	DoctorModel update(UUID id, DoctorRecordDTO dto);

	List<DoctorModel> findAll();

	DoctorModel findById(UUID id);

	void delete(UUID id);
}