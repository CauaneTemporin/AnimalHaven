package com.temporintech.animalhaven.dtos.adopter;

import com.temporintech.animalhaven.enums.util.Status;
import jakarta.validation.constraints.NotBlank;

public record AdopterDTO(
        @NotBlank String name,
        @NotBlank String specialization,
        Status status) {
}