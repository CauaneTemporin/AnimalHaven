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
import com.temporintech.animalhaven.dtos.DoctorRecordDTO;
import com.temporintech.animalhaven.model.DoctorModel;
import com.temporintech.animalhaven.repositories.DoctorRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
	@Autowired
	DoctorRepository repository;

	@PostMapping
	public ResponseEntity<DoctorModel> saveDoctor(@RequestBody @Valid AnimalRecordDTO dto) {
		var model = new DoctorModel();
		BeanUtils.copyProperties(dto, model);
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(model));
	} 
	
	@GetMapping
	public ResponseEntity<List<DoctorModel>> getAllDoctor() {
		return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneDoctor(@PathVariable(value = "id") UUID id) {
		Optional<DoctorModel> doctor = repository.findById(id);
		if (doctor.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Doctor not found.");
		return ResponseEntity.status(HttpStatus.OK).body(doctor.get());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateDoctor(@PathVariable(value = "id") UUID id,
			@RequestBody @Valid DoctorRecordDTO dto) {
		Optional<DoctorModel> doctor = repository.findById(id);
		if (doctor.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Doctor not found.");
		var animalModel = doctor.get();
		BeanUtils.copyProperties(dto, animalModel);
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(animalModel));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteDoctor(@PathVariable(value = "id") UUID id) {
		Optional<DoctorModel> doctor = repository.findById(id);
		if (doctor.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Doctor not found.");
		repository.delete(doctor.get());
		return ResponseEntity.status(HttpStatus.OK).body("Doctor deleted successfully.");
	}
s
}