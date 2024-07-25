package com.temporintech.animalhaven.services.vaccine;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.temporintech.animalhaven.repositories.VaccineRepository;

@Service
public class VaccineServiceImpl implements VaccineService {

	@Autowired
	private VaccineRepository repository;

	@Transactional(readOnly = true)
	public boolean existsByDoctorId(UUID doctorId) {
		return repository.existsByDoctorId(doctorId);
	}
}