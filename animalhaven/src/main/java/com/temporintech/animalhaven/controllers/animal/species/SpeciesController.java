package com.temporintech.animalhaven.controllers.animal.species;

import com.temporintech.animalhaven.dtos.animal.SpeciesDTO;
import com.temporintech.animalhaven.model.animal.SpeciesModel;
import com.temporintech.animalhaven.services.animals.species.SpeciesServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/species")
@RequiredArgsConstructor
public class SpeciesController implements ISpeciesControllerSwagger {

    private final SpeciesServiceImpl service;

    @PostMapping
    public ResponseEntity<SpeciesModel> saveSpecies(@RequestBody @Valid SpeciesDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
    }

    @GetMapping
    public ResponseEntity<List<SpeciesModel>> getAllSpecies() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneSpecies(@PathVariable(value = "id") UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateSpecies(@PathVariable(value = "id") UUID id,
                                                @RequestBody @Valid SpeciesDTO dto) {
        return ResponseEntity.status(HttpStatus.OK).body(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSpecies(@PathVariable(value = "id") UUID id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}