package com.temporintech.animalhaven.controllers.animal.animal;

import com.temporintech.animalhaven.dtos.animal.AnimalDTO;
import com.temporintech.animalhaven.model.animal.AnimalModel;
import com.temporintech.animalhaven.services.animals.animal.AnimalServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/animal")
@RequiredArgsConstructor
public class AnimalController implements IAnimalControllerSwagger {

    private final AnimalServiceImpl service;

    @PostMapping
    public ResponseEntity<AnimalModel> saveAnimal(@RequestBody @Valid AnimalDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
    }

    @GetMapping
    public ResponseEntity<List<AnimalModel>> getAllAnimal() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneAnimal(@PathVariable(value = "id") UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateAnimal(@PathVariable(value = "id") UUID id,
                                               @RequestBody @Valid AnimalDTO dto) {
        return ResponseEntity.status(HttpStatus.OK).body(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnimal(@PathVariable(value = "id") UUID id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}