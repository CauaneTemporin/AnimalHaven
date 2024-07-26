package com.temporintech.animalhaven.services.animal;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.temporintech.animalhaven.dtos.AnimalRecordDTO;
import com.temporintech.animalhaven.model.AnimalModel;
import com.temporintech.animalhaven.services.CrudService;

@Service
public interface AnimalService extends CrudService<AnimalModel, AnimalRecordDTO>{

	boolean existsBySpeciesId(UUID speciesId);
	
    boolean existsByShelterId(UUID shelterId);
    
    boolean existsByVaccineId(UUID vaccineId);
}