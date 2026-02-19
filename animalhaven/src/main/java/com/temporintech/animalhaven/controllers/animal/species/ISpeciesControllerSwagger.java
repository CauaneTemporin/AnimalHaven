package com.temporintech.animalhaven.controllers.animal.species;

import com.temporintech.animalhaven.dtos.animal.SpeciesDTO;
import com.temporintech.animalhaven.model.animal.SpeciesModel;
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

@Tag(name = "Species", description = "Operações relacionadas às espécies")
public interface ISpeciesControllerSwagger {

    @Operation(summary = "Cadastrar uma nova espécie", description = "Cria uma nova espécie no sistema.")
    @ApiResponse(
            description = "Espécie criada com sucesso",
            responseCode = "201",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = SpeciesModel.class))
    )
    ResponseEntity<SpeciesModel> saveSpecies(@RequestBody @Valid SpeciesDTO dto);

    @Operation(summary = "Listar todas as espécies", description = "Recupera uma lista de todas as espécies cadastradas.")
    @ApiResponse(
            description = "OK",
            responseCode = "200",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = SpeciesModel.class))
    )
    ResponseEntity<List<SpeciesModel>> getAllSpecies();

    @Operation(summary = "Buscar uma espécie por ID", description = "Recupera uma espécie específica pelo seu ID.")
    @ApiResponse(
            description = "OK",
            responseCode = "200",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = SpeciesModel.class))
    )
    ResponseEntity<Object> getOneSpecies(@PathVariable(value = "id") UUID id);

    @Operation(summary = "Atualizar uma espécie", description = "Atualiza os dados de uma espécie específica.")
    @ApiResponse(
            description = "Espécie atualizada com sucesso",
            responseCode = "200",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = SpeciesModel.class))
    )
    ResponseEntity<Object> updateSpecies(@PathVariable(value = "id") UUID id,
                                                @RequestBody @Valid SpeciesDTO dto);

    @Operation(summary = "Deletar uma espécie", description = "Remove uma espécie do sistema pelo seu ID.")
    @ApiResponse(
            description = "Espécie deletada com sucesso",
            responseCode = "200",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = SpeciesModel.class))
    )
    ResponseEntity<Void> deleteSpecies(@PathVariable(value = "id") UUID id);
}