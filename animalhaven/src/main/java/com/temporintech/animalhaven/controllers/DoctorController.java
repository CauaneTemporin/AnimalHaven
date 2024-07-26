package com.temporintech.animalhaven.controllers;

import java.util.List;
import java.util.UUID;

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

import com.temporintech.animalhaven.dtos.DoctorRecordDTO;
import com.temporintech.animalhaven.model.DoctorModel;
import com.temporintech.animalhaven.services.doctor.DoctorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

	private final DoctorService service;

	@Autowired
	public DoctorController(DoctorService service) {
		super();
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<DoctorModel> saveDoctor(@RequestBody @Valid DoctorRecordDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
	}

	@GetMapping
	public ResponseEntity<List<DoctorModel>> getAllDoctor() {
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneDoctor(@PathVariable(value = "id") UUID id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateDoctor(@PathVariable(value = "id") UUID id,
			@RequestBody @Valid DoctorRecordDTO dto) {
		return ResponseEntity.status(HttpStatus.OK).body(service.update(id, dto));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteDoctor(@PathVariable(value = "id") UUID id) {
		service.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}