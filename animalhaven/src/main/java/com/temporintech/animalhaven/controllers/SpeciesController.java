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

import com.temporintech.animalhaven.dtos.SpeciesRecordDTO;
import com.temporintech.animalhaven.model.SpeciesModel;
import com.temporintech.animalhaven.services.species.SpeciesServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/species")
@RequiredArgsConstructor
@Tag(name = "Species", description = "Operações relacionadas às espécies")
public class SpeciesController {

    private final SpeciesServiceImpl service;

    @Operation(summary = "Cadastrar uma nova espécie", description = "Cria uma nova espécie no sistema.")
    @ApiResponse(
            description = "Espécie criada com sucesso",
            responseCode = "201",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = SpeciesModel.class))
    )
    @PostMapping
    public ResponseEntity<SpeciesModel> saveSpecies(@RequestBody @Valid SpeciesRecordDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
    }

    @Operation(summary = "Listar todas as espécies", description = "Recupera uma lista de todas as espécies cadastradas.")
    @ApiResponse(
            description = "OK",
            responseCode = "200",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = SpeciesModel.class))
    )
    @GetMapping
    public ResponseEntity<List<SpeciesModel>> getAllSpecies() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @Operation(summary = "Buscar uma espécie por ID", description = "Recupera uma espécie específica pelo seu ID.")
    @ApiResponse(
            description = "OK",
            responseCode = "200",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = SpeciesModel.class))
    )
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneSpecies(@PathVariable(value = "id") UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

    @Operation(summary = "Atualizar uma espécie", description = "Atualiza os dados de uma espécie específica.")
    @ApiResponse(
            description = "Espécie atualizada com sucesso",
            responseCode = "200",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = SpeciesModel.class))
    )
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateSpecies(@PathVariable(value = "id") UUID id,
                                                @RequestBody @Valid SpeciesRecordDTO dto) {
        return ResponseEntity.status(HttpStatus.OK).body(service.update(id, dto));
    }

    @Operation(summary = "Deletar uma espécie", description = "Remove uma espécie do sistema pelo seu ID.")
    @ApiResponse(
            description = "Espécie deletada com sucesso",
            responseCode = "200",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = SpeciesModel.class))
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSpecies(@PathVariable(value = "id") UUID id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}