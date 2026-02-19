package com.temporintech.animalhaven.dtos.shelter;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ShelterDTO(
        @NotBlank String name,
        @NotBlank String address,
        @NotBlank String phoneNumber,
        @NotNull int capacity) {
}