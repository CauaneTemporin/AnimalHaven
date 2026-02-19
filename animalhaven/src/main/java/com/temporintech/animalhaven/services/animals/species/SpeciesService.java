package com.temporintech.animalhaven.services.animals.species;

import org.springframework.stereotype.Service;

import com.temporintech.animalhaven.dtos.animal.SpeciesDTO;
import com.temporintech.animalhaven.model.animal.SpeciesModel;
import com.temporintech.animalhaven.services.CrudService;

@Service
public interface SpeciesService extends CrudService<SpeciesModel, SpeciesDTO> {

}