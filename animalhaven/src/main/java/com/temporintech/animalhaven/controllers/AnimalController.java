package com.temporintech.animalhaven.controllers;

import java.util.List;
import java.util.UUID;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import io.swagger.v3.oas.annotations.tags.Tag;
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

import com.temporintech.animalhaven.dtos.AnimalRecordDTO;
import com.temporintech.animalhaven.model.AnimalModel;
import com.temporintech.animalhaven.services.animal.AnimalServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/animal")
@RequiredArgsConstructor
@Tag(name = "Animals", description = "Operações relacionadas aos animais")
public class AnimalController {

    private final AnimalServiceImpl service;

    @Operation(summary = "Cadastrar um novo animal", description = "Cria um novo animal no sistema.")
    @ApiResponse(
            responseCode = "201",
            description = "Animal criado com sucesso",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = AnimalModel.class))
    )
    @PostMapping
    public ResponseEntity<AnimalModel> saveAnimal(@RequestBody @Valid AnimalRecordDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
    }

    @Operation(summary = "Listar todos os animais", description = "Recupera uma lista de todos os animais cadastrados.")
    @ApiResponse(
            responseCode = "200",
            description = "OK",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = AnimalModel.class))
    )
    @GetMapping
    public ResponseEntity<List<AnimalModel>> getAllAnimal() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @Operation(summary = "Buscar um animal por ID", description = "Recupera um animal específico pelo seu ID.")
    @ApiResponse(
            responseCode = "200",
            description = "OK",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = AnimalModel.class))
    )
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneAnimal(@PathVariable(value = "id") UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

    @Operation(summary = "Atualizar um animal", description = "Atualiza os dados de um animal específico.")
    @ApiResponse(
            responseCode = "200",
            description = "Animal atualizado com sucesso",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = AnimalModel.class))
    )
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateAnimal(@PathVariable(value = "id") UUID id,
                                               @RequestBody @Valid AnimalRecordDTO dto) {
        return ResponseEntity.status(HttpStatus.OK).body(service.update(id, dto));
    }

    @Operation(summary = "Deletar um animal", description = "Remove um animal do sistema pelo seu ID.")
    @ApiResponse(
            responseCode = "204",
            description = "Animal deletado com sucesso",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = AnimalModel.class))
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnimal(@PathVariable(value = "id") UUID id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}