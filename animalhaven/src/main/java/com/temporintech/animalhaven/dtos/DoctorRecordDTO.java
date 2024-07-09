package com.temporintech.animalhaven.dtos;

import com.temporintech.animalhaven.enums.animal.Status;

import jakarta.validation.constraints.NotBlank;

public record DoctorRecordDTO(@NotBlank String name, @NotBlank String specialization, Status status) {

}
