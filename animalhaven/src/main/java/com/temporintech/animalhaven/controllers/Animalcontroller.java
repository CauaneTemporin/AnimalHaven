package com.temporintech.animalhaven.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.temporintech.animalhaven.dtos.AnimalRecordDTO;
import com.temporintech.animalhaven.model.AnimalModel;
import com.temporintech.animalhaven.repositories.AnimalRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/animal")
public class Animalcontroller {

	@Autowired
	AnimalRepository repository;

	@PostMapping
	public ResponseEntity<AnimalModel> saveAnimal(@RequestBody @Valid AnimalRecordDTO dto) {
		var model = new AnimalModel();
		BeanUtils.copyProperties(dto, model);
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(model));
	}
}