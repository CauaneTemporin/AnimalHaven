package com.temporintech.animalhaven.dtos.volunteers;

import com.temporintech.animalhaven.enums.util.Status;
import com.temporintech.animalhaven.model.animal.VaccineModel;

import jakarta.validation.constraints.NotBlank;

public record VolunteersDTO(
        @NotBlank String name,
        @NotBlank String specialization,
        Status status,
        VaccineModel vaccine) {
}