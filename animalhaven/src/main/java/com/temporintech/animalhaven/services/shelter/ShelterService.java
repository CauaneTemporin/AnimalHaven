package com.temporintech.animalhaven.services.shelter;

import org.springframework.stereotype.Service;

import com.temporintech.animalhaven.dtos.shelter.ShelterDTO;
import com.temporintech.animalhaven.model.shelter.ShelterModel;
import com.temporintech.animalhaven.services.CrudService;

@Service
public interface ShelterService extends CrudService<ShelterModel, ShelterDTO> {

}