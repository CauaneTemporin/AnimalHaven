package com.temporintech.animalhaven.dtos;

import jakarta.validation.constraints.NotBlank;

public record SpeciesRecordDTO(@NotBlank String name) {
	
}