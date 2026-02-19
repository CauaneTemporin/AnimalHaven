package com.temporintech.animalhaven.dtos.animal;

import com.temporintech.animalhaven.model.volunteers.VolunteersModel;
import jakarta.validation.constraints.NotBlank;

public record VaccineDTO(
        @NotBlank String name,
        @NotBlank String dose,
        @NotBlank String manufacturer,
        @NotBlank String lotNumber,
        @NotBlank String observation,
        VolunteersModel volunteers) {
}