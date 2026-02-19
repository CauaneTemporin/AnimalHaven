package com.temporintech.animalhaven.dtos.sponsor;

import com.temporintech.animalhaven.enums.util.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public record SponsorDTO (
        @NotBlank String name,
        @Past LocalDate dateOfBirth,
        Gender gender,
        @NotBlank String nationalId,
        @NotBlank String documentType,
        @NotBlank String email,
        @NotBlank String phone,
        @NotBlank String secondaryPhon,
        @NotBlank String occupation
){
}