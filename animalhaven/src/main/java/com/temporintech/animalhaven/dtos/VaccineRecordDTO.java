package com.temporintech.animalhaven.dtos;

import com.temporintech.animalhaven.model.DoctorModel;

import jakarta.validation.constraints.NotBlank;

public record VaccineRecordDTO(@NotBlank String name, @NotBlank String dose, @NotBlank String manufacturer,
                               @NotBlank String lotNumber, @NotBlank String observation, DoctorModel doctor) {
}