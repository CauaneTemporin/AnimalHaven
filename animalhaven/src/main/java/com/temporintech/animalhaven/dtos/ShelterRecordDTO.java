package com.temporintech.animalhaven.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ShelterRecordDTO(@NotBlank String name, @NotBlank String address, @NotBlank String phoneNumber,
		@NotNull int capacity) {

}