package com.temporintech.animalhaven.controllers.animal.animal;

import com.temporintech.animalhaven.dtos.animal.AnimalDTO;
import com.temporintech.animalhaven.model.animal.AnimalModel;
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

@Tag(name = "Animals", description = "Operações relacionadas aos animais")
public interface IAnimalControllerSwagger {

    @Operation(summary = "Cadastrar um novo animal", description = "Cria um novo animal no sistema.")
    @ApiResponse(
            responseCode = "201",
            description = "Animal criado com sucesso",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = AnimalModel.class))
    )
    ResponseEntity<AnimalModel> saveAnimal(@RequestBody @Valid AnimalDTO dto);

    @Operation(summary = "Listar todos os animais", description = "Recupera uma lista de todos os animais cadastrados.")
    @ApiResponse(
            responseCode = "200",
            description = "OK",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = AnimalModel.class))
    )
    ResponseEntity<List<AnimalModel>> getAllAnimal();

    @Operation(summary = "Buscar um animal por ID", description = "Recupera um animal específico pelo seu ID.")
    @ApiResponse(
            responseCode = "200",
            description = "OK",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = AnimalModel.class))
    )
    ResponseEntity<Object> getOneAnimal(@PathVariable(value = "id") UUID id);

    @Operation(summary = "Atualizar um animal", description = "Atualiza os dados de um animal específico.")
    @ApiResponse(
            responseCode = "200",
            description = "Animal atualizado com sucesso",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = AnimalModel.class))
    ) ResponseEntity<Object> updateAnimal(@PathVariable(value = "id") UUID id,
                                        @RequestBody @Valid AnimalDTO dto);

    @Operation(summary = "Deletar um animal", description = "Remove um animal do sistema pelo seu ID.")
    @ApiResponse(
            responseCode = "204",
            description = "Animal deletado com sucesso",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = AnimalModel.class))
    )
    ResponseEntity<Void> deleteAnimal(@PathVariable(value = "id") UUID id);
}