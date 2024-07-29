package com.temporintech.animalhaven.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.temporintech.animalhaven.model.AnimalModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
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

import com.temporintech.animalhaven.dtos.VaccineRecordDTO;
import com.temporintech.animalhaven.model.VaccineModel;
import com.temporintech.animalhaven.repositories.VaccineRepository;
import com.temporintech.animalhaven.services.vaccine.VaccineService;
import com.temporintech.animalhaven.services.vaccine.VaccineServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/vaccine")
@RequiredArgsConstructor
@Tag(name = "Vaccine", description = "Operações relacionadas a vacina")
public class VaccineController {

    private final VaccineServiceImpl service;

    @Operation(summary = "Cadastrar uma nova vacina", description = "Cria uma novo vacina no sistema.")
    @ApiResponse(
            responseCode = "201",
            description = "Vacina criado com sucesso",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = AnimalModel.class))
    )
    @PostMapping
    public ResponseEntity<VaccineModel> saveVaccine(@RequestBody @Valid VaccineRecordDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
    }

    @Operation(summary = "Listar todos as vacinas", description = "Recupera uma lista de todas as vacinas cadastrados.")
    @ApiResponse(
            responseCode = "200",
            description = "OK",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = AnimalModel.class))
    )
    @GetMapping
    public ResponseEntity<List<VaccineModel>> getAllVaccine() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @Operation(summary = "Buscar uma vacina por ID", description = "Recupera uma vacina específico pelo seu ID.")
    @ApiResponse(
            responseCode = "200",
            description = "OK",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = AnimalModel.class))
    )
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneVaccine(@PathVariable(value = "id") UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

    @Operation(summary = "Atualizar uma vacina", description = "Atualiza os dados de uma vacina específico.")
    @ApiResponse(
            responseCode = "200",
            description = "Vacina atualizado com sucesso",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = AnimalModel.class))
    )
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateVaccine(@PathVariable(value = "id") UUID id,
                                                @RequestBody @Valid VaccineRecordDTO dto) {
        return ResponseEntity.status(HttpStatus.OK).body(service.update(id, dto));
    }

    @Operation(summary = "Deletar uma vacina", description = "Remove uma vacina do sistema pelo seu ID.")
    @ApiResponse(
            responseCode = "204",
            description = "Vacina deletado com sucesso",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = AnimalModel.class))
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVaccine(@PathVariable(value = "id") UUID id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}