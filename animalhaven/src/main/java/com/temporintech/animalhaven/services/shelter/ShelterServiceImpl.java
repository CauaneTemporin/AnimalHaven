package com.temporintech.animalhaven.services.shelter;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.temporintech.animalhaven.dtos.ShelterRecordDTO;
import com.temporintech.animalhaven.model.ShelterModel;
import com.temporintech.animalhaven.repositories.ShelterRepository;
import com.temporintech.animalhaven.services.animal.AnimalService;
import com.temporintech.animalhaven.services.exceptions.AssociationException;
import com.temporintech.animalhaven.services.exceptions.ResourceNotFoundException;

@Service
public class ShelterServiceImpl implements ShelterService {

	private final ShelterRepository repository;
	private final AnimalService animalService;

	@Autowired
	public ShelterServiceImpl(ShelterRepository repository, AnimalService animalService) {
		super();
		this.repository = repository;
		this.animalService = animalService;
	}

	@Transactional
	public ShelterModel save(ShelterRecordDTO dto) {
		var model = new ShelterModel();
		BeanUtils.copyProperties(dto, model);
		return repository.save(model);
	}

	@Transactional
	public ShelterModel update(UUID id, ShelterRecordDTO dto) {
		var shelterModel = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Shelter with ID " + id + " not found"));
		BeanUtils.copyProperties(dto, shelterModel);
		return repository.save(shelterModel);
	}

	public List<ShelterModel> findAll() {
		return repository.findAll();
	}

	public ShelterModel findById(UUID id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Shelter with ID " + id + " not found"));
	}

	@Transactional
	public void delete(UUID id) {
		ShelterModel shelterModel = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Shelter with ID " + id + " not found"));

		boolean isAssociated = animalService.existsByShelterId(id);
		if (isAssociated) {
			throw new AssociationException("Shelter with ID " + id + " is associated with one or more animals");
		}

		repository.delete(shelterModel);
	}
}