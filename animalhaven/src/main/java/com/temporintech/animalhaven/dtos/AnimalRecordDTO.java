package com.temporintech.animalhaven.dtos;

import java.sql.Date;

import com.temporintech.animalhaven.enums.animal.Gender;
import com.temporintech.animalhaven.enums.animal.Health;
import com.temporintech.animalhaven.enums.animal.Status;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

public record AnimalRecordDTO(@NotBlank String name, @NotNull int age, @NotBlank Gender gender,
		@NotNull double weight, @NotBlank Health health, @Past Date dateEntered, @NotBlank String description,
		@NotBlank Status status, boolean castrated) {

}