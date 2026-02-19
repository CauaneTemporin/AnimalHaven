package com.temporintech.animalhaven.dtos.animal;

import jakarta.validation.constraints.NotBlank;

public record SpeciesDTO(
        @NotBlank String name) {
}