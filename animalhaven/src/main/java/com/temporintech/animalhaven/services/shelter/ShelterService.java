package com.temporintech.animalhaven.services.shelter;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.temporintech.animalhaven.dtos.ShelterRecordDTO;
import com.temporintech.animalhaven.model.ShelterModel;

@Service
public interface ShelterService {

	ShelterModel save(ShelterRecordDTO dto);

	ShelterModel update(UUID id, ShelterRecordDTO dto);

	List<ShelterModel> findAll();

	ShelterModel findById(UUID id);

	void delete(UUID id);
}