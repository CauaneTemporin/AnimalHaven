package com.temporintech.animalhaven.services.species;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.temporintech.animalhaven.dtos.SpeciesRecordDTO;
import com.temporintech.animalhaven.model.SpeciesModel;

@Service
public interface SpeciesService {

	SpeciesModel save(SpeciesRecordDTO dto);

	SpeciesModel update(UUID id, SpeciesRecordDTO dto);

	List<SpeciesModel> findAll();

	SpeciesModel findById(UUID id);

	Object delete(UUID id);
}