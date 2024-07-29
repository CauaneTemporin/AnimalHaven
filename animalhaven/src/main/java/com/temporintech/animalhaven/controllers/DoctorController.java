package com.temporintech.animalhaven.controllers;

import java.util.List;
import java.util.UUID;

import com.temporintech.animalhaven.model.ShelterModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
@RequiredArgsConstructor
@Tag(name = "Doctors", description = "Operações relacionadas aos médicos")
public class DoctorController {

    private final DoctorService service;

    @Operation(summary = "Cadastrar um novo médico", description = "Cria um novo médico no sistema.")
    @ApiResponse(
            description = "Médico criado com sucesso",
            responseCode = "201",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ShelterModel.class))
    )
    @PostMapping
    public ResponseEntity<DoctorModel> saveDoctor(@RequestBody @Valid DoctorRecordDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
    }

    @Operation(summary = "Listar todos os médicos", description = "Recupera uma lista de todos os médicos cadastrados.")
    @ApiResponse(
            description = "OK",
            responseCode = "200",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ShelterModel.class))
    )
    @GetMapping
    public ResponseEntity<List<DoctorModel>> getAllDoctor() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @Operation(summary = "Buscar um médico por ID", description = "Recupera um médico específico pelo seu ID.")
    @ApiResponse(
            description = "OK",
            responseCode = "200",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ShelterModel.class))
    )
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneDoctor(@PathVariable(value = "id") UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

    @Operation(summary = "Atualizar um médico", description = "Atualiza os dados de um médico específico.")
    @ApiResponse(
            description = "Médico atualizado com sucesso",
            responseCode = "200",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ShelterModel.class))
    )
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateDoctor(@PathVariable(value = "id") UUID id,
                                               @RequestBody @Valid DoctorRecordDTO dto) {
        return ResponseEntity.status(HttpStatus.OK).body(service.update(id, dto));
    }

    @Operation(summary = "Deletar um médico", description = "Remove um médico do sistema pelo seu ID.")
    @ApiResponse(
            description = "Médico deletado com sucesso",
            responseCode = "204",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ShelterModel.class))
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable(value = "id") UUID id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}