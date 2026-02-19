package com.temporintech.animalhaven.controllers.animal.vaccine;

import com.temporintech.animalhaven.dtos.animal.VaccineDTO;
import com.temporintech.animalhaven.model.animal.AnimalModel;
import com.temporintech.animalhaven.model.animal.VaccineModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Vaccine", description = "Operações relacionadas a vacina")
public interface IVaccineControllerSwagger {

    @Operation(summary = "Cadastrar uma nova vacina", description = "Cria uma novo vacina no sistema.")
    @ApiResponse(
            responseCode = "201",
            description = "Vacina criado com sucesso",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = AnimalModel.class))
    )
    ResponseEntity<VaccineModel> saveVaccine(@RequestBody @Valid VaccineDTO dto);

    @Operation(summary = "Listar todos as vacinas", description = "Recupera uma lista de todas as vacinas cadastrados.")
    @ApiResponse(
            responseCode = "200",
            description = "OK",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = AnimalModel.class))
    )
    ResponseEntity<List<VaccineModel>> getAllVaccine();

    @Operation(summary = "Buscar uma vacina por ID", description = "Recupera uma vacina específico pelo seu ID.")
    @ApiResponse(
            responseCode = "200",
            description = "OK",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = AnimalModel.class))
    )
    ResponseEntity<Object> getOneVaccine(@PathVariable(value = "id") UUID id);

    @Operation(summary = "Atualizar uma vacina", description = "Atualiza os dados de uma vacina específico.")
    @ApiResponse(
            responseCode = "200",
            description = "Vacina atualizado com sucesso",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = AnimalModel.class))
    )
    ResponseEntity<Object> updateVaccine(@PathVariable(value = "id") UUID id,
                                                @RequestBody @Valid VaccineDTO dto);

    @Operation(summary = "Deletar uma vacina", description = "Remove uma vacina do sistema pelo seu ID.")
    @ApiResponse(
            responseCode = "204",
            description = "Vacina deletado com sucesso",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = AnimalModel.class))
    )
    ResponseEntity<Void> deleteVaccine(@PathVariable(value = "id") UUID id);
}