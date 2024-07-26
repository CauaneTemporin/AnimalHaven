package com.temporintech.animalhaven.dtos;

import com.temporintech.animalhaven.enums.status.Status;
import com.temporintech.animalhaven.model.VaccineModel;

import jakarta.validation.constraints.NotBlank;

public record DoctorRecordDTO(@NotBlank String name, @NotBlank String specialization, Status status,
                              VaccineModel vaccine) {

}
