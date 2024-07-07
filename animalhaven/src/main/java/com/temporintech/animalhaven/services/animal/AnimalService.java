package com.temporintech.animalhaven.services.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.temporintech.animalhaven.model.AnimalModel;
import com.temporintech.animalhaven.repositories.AnimalRepository;

public class AnimalService {
	
	@Autowired
	AnimalRepository animalRepository;

	@Transactional(readOnly = true)
	public AnimalModel save(AnimalModel animalModel) {
		return animalRepository.save(animalModel);
	}
}