package com.temporintech.animalhaven.services.animal.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.temporintech.animalhaven.model.AnimalModel;
import com.temporintech.animalhaven.repositories.AnimalRepository;
import com.temporintech.animalhaven.services.animal.AnimalService;

public class AnimalServiceImpl implements AnimalService{
	
	@Autowired
	AnimalRepository animalRepository;

	@Override
	public AnimalModel save(AnimalModel animalModel) {
		return animalRepository.save(animalModel);
	}

}