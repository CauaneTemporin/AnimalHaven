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

import com.temporintech.animalhaven.dtos.AnimalRecordDTO;
import com.temporintech.animalhaven.model.AnimalModel;
import com.temporintech.animalhaven.model.VaccineModel;
import com.temporintech.animalhaven.repositories.AnimalRepository;
import com.temporintech.animalhaven.repositories.ShelterRepository;
import com.temporintech.animalhaven.repositories.SpeciesRepository;
import com.temporintech.animalhaven.repositories.VaccineRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/animal")
public class AnimalController {

	@Autowired
	AnimalRepository repository;
	
	@Autowired
    private SpeciesRepository speciesRepository;

    @Autowired
    private ShelterRepository shelterRepository;

    @Autowired
    private VaccineRepository vaccineRepository;

	@PostMapping
	public ResponseEntity<AnimalModel> saveAnimal(@RequestBody @Valid AnimalRecordDTO dto) {
		var model = new AnimalModel();
		BeanUtils.copyProperties(dto, model);
        speciesRepository.findById(dto.speciesId()).ifPresent(model::setSpecies);
        shelterRepository.findById(dto.shelterId()).ifPresent(model::setShelter);
        List<VaccineModel> vaccines = vaccineRepository.findAllById(dto.vaccineId());
        model.setVaccine(vaccines);

		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(model));
	} 

	@GetMapping
	public ResponseEntity<List<AnimalModel>> getAllAnimal() {
		return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneAnimal(@PathVariable(value = "id") UUID id) {
		Optional<AnimalModel> animal = repository.findById(id);
		if (animal.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Animal not found.");

		return ResponseEntity.status(HttpStatus.OK).body(animal.get());
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateAnimal(@PathVariable(value = "id") UUID id,
			@RequestBody @Valid AnimalRecordDTO dto) {
		Optional<AnimalModel> animal = repository.findById(id);
		if (animal.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Animal not found.");

		var animalModel = animal.get();
		BeanUtils.copyProperties(dto, animalModel);
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(animalModel));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteAnimal(@PathVariable(value = "id") UUID id) {
		Optional<AnimalModel> animal = repository.findById(id);
		if (animal.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Animal not found.");

		repository.delete(animal.get());
		return ResponseEntity.status(HttpStatus.OK).body("Animal deleted successfully.");
	}

}