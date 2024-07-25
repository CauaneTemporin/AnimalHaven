package com.temporintech.animalhaven.services.animal;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.temporintech.animalhaven.repositories.AnimalRepository;

@Service
public class AnimalServiceImpl implements AnimalService {

	@Autowired
	private AnimalRepository repository;

	@Transactional(readOnly = true)
	public boolean existsBySpeciesId(UUID speciesId) {
		return repository.existsBySpeciesId(speciesId);
	}

	@Transactional(readOnly = true)
	public boolean existsByShelterId(UUID shelterId) {
		return repository.existsByShelterId(shelterId);
	}
	
	@Transactional(readOnly = true)
	public boolean existsByVaccineId(UUID vaccineId) {
		return repository.existsByVaccineId(vaccineId);
	}
}