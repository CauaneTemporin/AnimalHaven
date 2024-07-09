package com.temporintech.animalhaven.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.temporintech.animalhaven.model.VaccineModel;
import com.temporintech.animalhaven.repositories.VaccineRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/vaccine")
public class VaccineController {

	@Autowired
	VaccineRepository repository;

	@PostMapping
	public ResponseEntity<VaccineModel> saveVaccine(@RequestBody @Valid VaccineModel dto) {
		var model = new VaccineModel();
		BeanUtils.copyProperties(dto, model);
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(model));
	}

	@GetMapping
	public ResponseEntity<List<VaccineModel>> getAllVaccine() {
		return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
	}
}