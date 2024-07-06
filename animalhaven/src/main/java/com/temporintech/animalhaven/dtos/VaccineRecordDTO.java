package com.temporintech.animalhaven.dtos;

import java.sql.Date;
import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;

public record VaccineRecordDTO(@NotBlank String name, @Past Date applicationDate, @NotBlank String manufacturer,
		@NotBlank String lotNumber, @NotBlank String responsibleVeterinarian) {

}