package com.temporintech.animalhaven.services.animal;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.temporintech.animalhaven.dtos.AnimalRecordDTO;
import com.temporintech.animalhaven.model.AnimalModel;
import com.temporintech.animalhaven.model.VaccineModel;
import com.temporintech.animalhaven.repositories.AnimalRepository;
import com.temporintech.animalhaven.repositories.ShelterRepository;
import com.temporintech.animalhaven.repositories.SpeciesRepository;
import com.temporintech.animalhaven.repositories.VaccineRepository;
import com.temporintech.animalhaven.services.exceptions.ResourceNotFoundException;

@Service
public class AnimalServiceImpl implements AnimalService {

	@Autowired
	private AnimalRepository repository;

	@Autowired
	private SpeciesRepository speciesRepository;

	@Autowired
	private ShelterRepository shelterRepository;

	@Autowired
	private VaccineRepository vaccineRepository;

	@Transactional
	public AnimalModel save(AnimalRecordDTO dto) {
		var model = new AnimalModel();
		BeanUtils.copyProperties(dto, model);
		speciesRepository.findById(dto.speciesId()).ifPresent(model::setSpecies);
		shelterRepository.findById(dto.shelterId()).ifPresent(model::setShelter);
		List<VaccineModel> vaccines = vaccineRepository.findAllById(dto.vaccineId());
		model.setVaccine(vaccines);
		return repository.save(model);
	}

	@Transactional
	public AnimalModel update(UUID id, AnimalRecordDTO dto) {
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