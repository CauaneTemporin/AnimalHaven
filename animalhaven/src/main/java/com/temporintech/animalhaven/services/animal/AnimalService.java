package com.temporintech.animalhaven.services.animal;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public interface AnimalService {

	boolean existsBySpeciesId(UUID speciesId);
	
    boolean existsByShelterId(UUID shelterId);
}