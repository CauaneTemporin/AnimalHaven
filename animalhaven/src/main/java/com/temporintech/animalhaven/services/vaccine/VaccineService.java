package com.temporintech.animalhaven.services.vaccine;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.temporintech.animalhaven.dtos.VaccineRecordDTO;
import com.temporintech.animalhaven.model.VaccineModel;
import com.temporintech.animalhaven.services.CrudService;

@Service
public interface VaccineService extends CrudService<VaccineModel, VaccineRecordDTO> {

	boolean existsByDoctorId(UUID doctorId);

}
