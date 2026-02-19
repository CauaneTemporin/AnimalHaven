package com.temporintech.animalhaven.services.animals.animal;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.temporintech.animalhaven.dtos.animal.AnimalDTO;
import com.temporintech.animalhaven.model.animal.AnimalModel;
import com.temporintech.animalhaven.model.animal.VaccineModel;
import com.temporintech.animalhaven.repositories.animal.AnimalRepository;
import com.temporintech.animalhaven.repositories.shelter.ShelterRepository;
import com.temporintech.animalhaven.repositories.animal.SpeciesRepository;
import com.temporintech.animalhaven.repositories.animal.VaccineRepository;
import com.temporintech.animalhaven.services.exceptions.ResourceNotFoundException;

@Service
public class AnimalServiceImpl implements AnimalService {

	private final AnimalRepository repository;
	private final SpeciesRepository speciesRepository;
	private final ShelterRepository shelterRepository;
	private final VaccineRepository vaccineRepository;

	@Autowired
	public AnimalServiceImpl(AnimalRepository repository, SpeciesRepository speciesRepository,
			ShelterRepository shelterRepository, VaccineRepository vaccineRepository) {
		super();
		this.repository = repository;
		this.speciesRepository = speciesRepository;
		this.shelterRepository = shelterRepository;
		this.vaccineRepository = vaccineRepository;
	}

	@Transactional
	public AnimalModel save(AnimalDTO dto) {
		var model = new AnimalModel();
		BeanUtils.copyProperties(dto, model);
		speciesRepository.findById(dto.speciesId()).ifPresent(model::setSpecies);
		shelterRepository.findById(dto.shelterId()).ifPresent(model::setShelter);
		List<VaccineModel> vaccines = vaccineRepository.findAllById(dto.vaccineId());
		model.setVaccine(vaccines);
		return repository.save(model);
	}

	@Transactional
	public AnimalModel update(UUID id, AnimalDTO dto) {
		var animalModel = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Animal with ID " + id + " not found"));
		BeanUtils.copyProperties(dto, animalModel);
		return repository.save(animalModel);
	}

	public List<AnimalModel> findAll() {
		return repository.findAll();
	}

	public AnimalModel findById(UUID id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Animal with ID " + id + " not found"));
	}

	@Transactional
	public void delete(UUID id) {
		AnimalModel animalModel = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Animal with ID " + id + " not found"));
		repository.delete(animalModel);
	}

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