package com.temporintech.animalhaven.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.temporintech.animalhaven.dtos.ShelterRecordDTO;
import com.temporintech.animalhaven.model.AnimalModel;
import com.temporintech.animalhaven.model.ShelterModel;
import com.temporintech.animalhaven.repositories.ShelterRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/shelter")
public class ShelterController {

	@Autowired
	ShelterRepository repository;

	@PostMapping
	public ResponseEntity<ShelterModel> saveShelter(@RequestBody @Valid ShelterRecordDTO dto) {
		var model = new ShelterModel();
		BeanUtils.copyProperties(dto, model);
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(model));
	}

	@GetMapping
	public ResponseEntity<List<ShelterModel>> getAllShelter() {
		return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneShelter(@PathVariable(value = "id") UUID id) {
		Optional<ShelterModel> shelter = repository.findById(id);
		if (shelter.isEmpty())
			return ResponseEntity.status(HttpStatus.OK).body(shelter.get());

		return ResponseEntity.status(HttpStatus.OK).body(shelter.get());
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateShelter(@PathVariable(value = "id") UUID id,
			@RequestBody @Valid ShelterRecordDTO dto) {
		Optional<ShelterModel> shelter = repository.findById(id);
		if (shelter.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Shelter not found");
		var shelterModel = shelter.get();
		BeanUtils.copyProperties(dto, shelterModel);
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(shelterModel));
	}
}