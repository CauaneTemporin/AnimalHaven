package com.temporintech.animalhaven.controllers;

import java.util.List;
import java.util.UUID;

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

import com.temporintech.animalhaven.dtos.ShelterRecordDTO;
import com.temporintech.animalhaven.model.ShelterModel;
import com.temporintech.animalhaven.services.shelter.ShelterServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/shelter")
@RequiredArgsConstructor
@Tag(name = "Shelters", description = "Operações relacionadas aos abrigos")
public class ShelterController {

    private final ShelterServiceImpl service;

    @Operation(summary = "Cadastrar um novo abrigo", description = "Cria um novo abrigo no sistema.")
    @ApiResponse(
            description = "Abrigo criado com sucesso",
            responseCode = "201",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ShelterModel.class))
    )
    @PostMapping
    public ResponseEntity<ShelterModel> saveShelter(@RequestBody @Valid ShelterRecordDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
    }

    @Operation(summary = "Listar todos os abrigos", description = "Recupera uma lista de todos os abrigos cadastrados.")
    @ApiResponse(
            description = "OK",
            responseCode = "200",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ShelterModel.class))
    )
    @GetMapping
    public ResponseEntity<List<ShelterModel>> getAllShelter() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @Operation(summary = "Buscar um abrigo por ID", description = "Recupera um abrigo específico pelo seu ID.")
    @ApiResponse(
            description = "OK",
            responseCode = "200",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ShelterModel.class))
    )
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneShelter(@PathVariable(value = "id") UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

    @Operation(summary = "Atualizar um abrigo", description = "Atualiza os dados de um abrigo específico.")
    @ApiResponse(
            description = "Abrigo atualizado com sucesso",
            responseCode = "200",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ShelterModel.class))
    )
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateShelter(@PathVariable(value = "id") UUID id,
                                                @RequestBody @Valid ShelterRecordDTO dto) {
        return ResponseEntity.status(HttpStatus.OK).body(service.update(id, dto));
    }

    @Operation(summary = "Deletar um abrigo", description = "Remove um abrigo do sistema pelo seu ID.")
    @ApiResponse(
            description = "Abrigo deletado com sucesso",
            responseCode = "204",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ShelterModel.class))
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShelter(@PathVariable(value = "id") UUID id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}