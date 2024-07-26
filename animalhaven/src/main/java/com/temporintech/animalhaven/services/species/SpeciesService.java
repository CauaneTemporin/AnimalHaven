package com.temporintech.animalhaven.services.species;

import org.springframework.stereotype.Service;

import com.temporintech.animalhaven.dtos.SpeciesRecordDTO;
import com.temporintech.animalhaven.model.SpeciesModel;
import com.temporintech.animalhaven.services.CrudService;

@Service
public interface SpeciesService extends CrudService<SpeciesModel, SpeciesRecordDTO> {

}