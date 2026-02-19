package com.temporintech.animalhaven.services.animals.animal;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.temporintech.animalhaven.dtos.animal.AnimalDTO;
import com.temporintech.animalhaven.model.animal.AnimalModel;
import com.temporintech.animalhaven.services.CrudService;

@Service
public interface AnimalService extends CrudService<AnimalModel, AnimalDTO>{

	boolean existsBySpeciesId(UUID speciesId);
	
    boolean existsByShelterId(UUID shelterId);
    
    boolean existsByVaccineId(UUID vaccineId);
}