package com.temporintech.animalhaven.controllers.animal.vaccine;

import com.temporintech.animalhaven.dtos.animal.VaccineDTO;
import com.temporintech.animalhaven.model.animal.VaccineModel;
import com.temporintech.animalhaven.services.animals.vaccine.VaccineServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/vaccine")
@RequiredArgsConstructor
    public class VaccineController implements IVaccineControllerSwagger {

    private final VaccineServiceImpl service;

    @PostMapping
    public ResponseEntity<VaccineModel> saveVaccine(@RequestBody @Valid VaccineDTO dto) {
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
                                                @RequestBody @Valid VaccineDTO dto) {
        return ResponseEntity.status(HttpStatus.OK).body(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVaccine(@PathVariable(value = "id") UUID id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}