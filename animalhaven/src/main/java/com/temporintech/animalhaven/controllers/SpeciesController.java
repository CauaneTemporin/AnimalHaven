package com.temporintech.animalhaven.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.temporintech.animalhaven.dtos.SpeciesRecordDTO;
import com.temporintech.animalhaven.model.SpeciesModel;
import com.temporintech.animalhaven.repositories.SpeciesRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/species")
public class SpeciesController {

	@Autowired
	SpeciesRepository repository;

	@PostMapping
	public ResponseEntity<SpeciesModel> saveSpecies(@RequestBody @Valid SpeciesRecordDTO dto) {
		var model = new SpeciesModel();
		BeanUtils.copyProperties(dto, model);
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(model));
	}

	@GetMapping
	public ResponseEntity<List<SpeciesModel>> getAllSpecies() {
		return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneSpecies(@PathVariable(value = "id") UUID id) {
		Optional<SpeciesModel> species = repository.findById(id);
		if (species.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Species not found");

		return ResponseEntity.status(HttpStatus.OK).body(species.get());
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateSpecies(@PathVariable(value = "id") UUID id,
			@RequestBody @Valid SpeciesRecordDTO dto) {
		Optional<SpeciesModel> species = repository.findById(id);
		if (species.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Species not found");
		var speciesModel = species.get();
		BeanUtils.copyProperties(dto, speciesModel);
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(speciesModel));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteSpecies(@PathVariable(value = "id") UUID id) {
		Optional<SpeciesModel> species = repository.findById(id);
		if (species.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Species not found.");
		repository.delete(species.get());
		return ResponseEntity.status(HttpStatus.OK).body("Species deleted successfully.");
	}
}