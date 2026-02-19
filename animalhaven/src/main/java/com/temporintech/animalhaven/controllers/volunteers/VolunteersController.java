package com.temporintech.animalhaven.controllers.volunteers;

import java.util.List;
import java.util.UUID;

import com.temporintech.animalhaven.dtos.volunteers.VolunteersDTO;
import com.temporintech.animalhaven.model.volunteers.VolunteersModel;
import com.temporintech.animalhaven.services.volunteers.VolunteersService;
import lombok.RequiredArgsConstructor;
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


import jakarta.validation.Valid;

@RestController
@RequestMapping("/volunteers")
@RequiredArgsConstructor
public class VolunteersController implements IVolunteersControllerSwagger {

    private final VolunteersService service;

    @PostMapping public ResponseEntity<VolunteersModel> saveVolunteers(@RequestBody @Valid VolunteersDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
    }

    @GetMapping
    public ResponseEntity<List<VolunteersModel>> getAllVolunteers() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneVolunteers(@PathVariable(value = "id") UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateVolunteers(@PathVariable(value = "id") UUID id,
                                               @RequestBody @Valid VolunteersDTO dto) {
        return ResponseEntity.status(HttpStatus.OK).body(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVolunteers(@PathVariable(value = "id") UUID id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}