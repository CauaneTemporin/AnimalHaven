package com.temporintech.animalhaven.controllers.volunteers;

import com.temporintech.animalhaven.dtos.volunteers.VolunteersDTO;
import com.temporintech.animalhaven.model.shelter.ShelterModel;
import com.temporintech.animalhaven.model.volunteers.VolunteersModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@Tag(name = "Volunteers", description = "Operações relacionadas aos voluntários")
public interface IVolunteersControllerSwagger {

    @Operation(summary = "Cadastrar um novo voluntário", description = "Cria um novo voluntário no sistema.")
    @ApiResponse(
            description = "Voluntários criado com sucesso",
            responseCode = "201",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ShelterModel.class))
    )
    ResponseEntity<VolunteersModel> saveVolunteers(@RequestBody @Valid VolunteersDTO dto);

    @Operation(summary = "Listar todos os voluntário", description = "Recupera uma lista de todos os voluntário cadastrados.")
    @ApiResponse(
            description = "OK",
            responseCode = "200",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ShelterModel.class))
    )
    ResponseEntity<List<VolunteersModel>> getAllVolunteers();

    @Operation(summary = "Buscar um voluntário por ID", description = "Recupera um voluntário específico pelo seu ID.")
    @ApiResponse(
            description = "OK",
            responseCode = "200",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ShelterModel.class))
    )
    ResponseEntity<Object> getOneVolunteers(@PathVariable(value = "id") UUID id);

    @Operation(summary = "Atualizar um voluntário", description = "Atualiza os dados de um voluntário específico.")
    @ApiResponse(
            description = "Voluntário atualizado com sucesso",
            responseCode = "200",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ShelterModel.class))
    )
    ResponseEntity<Object> updateVolunteers(@PathVariable(value = "id") UUID id,
                                            @RequestBody @Valid VolunteersDTO dto);

    @Operation(summary = "Deletar um voluntário", description = "Remove um voluntário do sistema pelo seu ID.")
    @ApiResponse(
            description = "Voluntário deletado com sucesso",
            responseCode = "204",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ShelterModel.class))
    )
    ResponseEntity<Void> deleteVolunteers(@PathVariable(value = "id") UUID id);
}