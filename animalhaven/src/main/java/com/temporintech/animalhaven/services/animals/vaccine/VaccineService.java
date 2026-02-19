package com.temporintech.animalhaven.services.animals.vaccine;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.temporintech.animalhaven.dtos.animal.VaccineDTO;
import com.temporintech.animalhaven.model.animal.VaccineModel;
import com.temporintech.animalhaven.services.CrudService;

@Service
public interface VaccineService extends CrudService<VaccineModel, VaccineDTO> {

    boolean existsByVolunteersId(UUID doctorId);

}
