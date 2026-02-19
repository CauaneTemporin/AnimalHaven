package com.temporintech.animalhaven.controllers.shelter;

import com.temporintech.animalhaven.dtos.shelter.ShelterDTO;
import com.temporintech.animalhaven.model.shelter.ShelterModel;
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

@Tag(name = "Shelters", description = "Operações relacionadas aos abrigos")
public interface IShelterControllerSwagger {

    @Operation(summary = "Cadastrar um novo abrigo", description = "Cria um novo abrigo no sistema.")
    @ApiResponse(
            description = "Abrigo criado com sucesso",
            responseCode = "201",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ShelterModel.class))
    )
    public ResponseEntity<ShelterModel> saveShelter(@RequestBody @Valid ShelterDTO dto);

    @Operation(summary = "Listar todos os abrigos", description = "Recupera uma lista de todos os abrigos cadastrados.")
    @ApiResponse(
            description = "OK",
            responseCode = "200",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ShelterModel.class))
    )
    public ResponseEntity<List<ShelterModel>> getAllShelter();

    @Operation(summary = "Buscar um abrigo por ID", description = "Recupera um abrigo específico pelo seu ID.")
    @ApiResponse(
            description = "OK",
            responseCode = "200",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ShelterModel.class))
    )
    public ResponseEntity<Object> getOneShelter(@PathVariable(value = "id") UUID id);

    @Operation(summary = "Atualizar um abrigo", description = "Atualiza os dados de um abrigo específico.")
    @ApiResponse(
            description = "Abrigo atualizado com sucesso",
            responseCode = "200",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ShelterModel.class))
    )
    public ResponseEntity<Object> updateShelter(@PathVariable(value = "id") UUID id,
                                                @RequestBody @Valid ShelterDTO dto);
    @Operation(summary = "Deletar um abrigo", description = "Remove um abrigo do sistema pelo seu ID.")
    @ApiResponse(
            description = "Abrigo deletado com sucesso",
            responseCode = "204",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ShelterModel.class))
    )
    public ResponseEntity<Void> deleteShelter(@PathVariable(value = "id") UUID id);
}