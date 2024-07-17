package com.temporintech.animalhaven.dtos;

import java.sql.Date;
import java.util.UUID;

import com.temporintech.animalhaven.enums.animal.Gender;
import com.temporintech.animalhaven.enums.animal.Health;
import com.temporintech.animalhaven.enums.animal.Status;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

public record AnimalRecordDTO(@NotBlank String name, @NotNull int age, Gender gender, @NotNull double weight,
		Health health, @Past Date dateEntered, @NotBlank String description, Status status, boolean castrated,
		UUID speciesId, UUID shelterId, UUID cardId) {

}