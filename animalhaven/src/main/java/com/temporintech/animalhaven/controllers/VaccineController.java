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

import com.temporintech.animalhaven.dtos.VaccineRecordDTO;
import com.temporintech.animalhaven.model.VaccineModel;
import com.temporintech.animalhaven.repositories.VaccineRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/vaccine")
public class VaccineController {

	@Autowired
	VaccineRepository repository;

	@PostMapping
	public ResponseEntity<VaccineModel> saveVaccine(@RequestBody @Valid VaccineRecordDTO dto) {
		var model = new VaccineModel();
		BeanUtils.copyProperties(dto, model);
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(model));
	}

	@GetMapping
	public ResponseEntity<List<VaccineModel>> getAllVaccine() {
		return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneVaccine(@PathVariable(value = "id") UUID id) {
		Optional<VaccineModel> vaccine = repository.findById(id);
		if (vaccine.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vaccine not found.");

		return ResponseEntity.status(HttpStatus.OK).body(vaccine.get());
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateVaccine(@PathVariable(value = "id") UUID id,
			@RequestBody @Valid VaccineRecordDTO dto) {
		Optional<VaccineModel> vaccine = repository.findById(id);
		if (vaccine.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vaccine not found.");

		var vaccineModel = vaccine.get();
		BeanUtils.copyProperties(dto, vaccineModel);
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(vaccineModel));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteVaccine(@PathVariable(value = "id") UUID id) {
		Optional<VaccineModel> vaccine = repository.findById(id);
		if (vaccine.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vaccine not found.");

		repository.delete(vaccine.get());
		return ResponseEntity.status(HttpStatus.OK).body("Vaccine deleted successfully.");
	}
}