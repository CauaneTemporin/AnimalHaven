package com.temporintech.animalhaven.services.shelter;

import org.springframework.stereotype.Service;

import com.temporintech.animalhaven.dtos.ShelterRecordDTO;
import com.temporintech.animalhaven.model.ShelterModel;
import com.temporintech.animalhaven.services.CrudService;

@Service
public interface ShelterService extends CrudService<ShelterModel, ShelterRecordDTO> {

}