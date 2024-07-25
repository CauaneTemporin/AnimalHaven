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
import com.temporintech.animalhaven.services.vaccine.VaccineService;
import com.temporintech.animalhaven.services.vaccine.VaccineServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/vaccine")
public class VaccineController {

	@Autowired
	VaccineServiceImpl service;

	@PostMapping
	public ResponseEntity<VaccineModel> saveVaccine(@RequestBody @Valid VaccineRecordDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
	}

	@GetMapping
	public ResponseEntity<List<VaccineModel>> getAllVaccine() {
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneVaccine(@PathVariable(value = "id") UUID id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateVaccine(@PathVariable(value = "id") UUID id,
			@RequestBody @Valid VaccineRecordDTO dto) {
		return ResponseEntity.status(HttpStatus.OK).body(service.update(id, dto));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteVaccine(@PathVariable(value = "id") UUID id) {
		service.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}