package com.temporintech.animalhaven.services.species;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.temporintech.animalhaven.dtos.SpeciesRecordDTO;
import com.temporintech.animalhaven.model.SpeciesModel;
import com.temporintech.animalhaven.repositories.SpeciesRepository;
import com.temporintech.animalhaven.services.exceptions.ResourceNotFoundException;

import jakarta.transaction.Transactional;

@Service
public class SpeciesServiceImpl implements SpeciesService {

    @Autowired
    private SpeciesRepository repository;

    @Transactional
    public SpeciesModel save(SpeciesRecordDTO dto) {
        var model = new SpeciesModel();
        BeanUtils.copyProperties(dto, model);
        return repository.save(model);
    }

    @Transactional
    public SpeciesModel update(UUID id, SpeciesRecordDTO dto) {
        var speciesModel = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Species not found"));
        BeanUtils.copyProperties(dto, speciesModel);
        return repository.save(speciesModel);
    }

    public List<SpeciesModel> findAll() {
        return repository.findAll();
    }

    public SpeciesModel findById(UUID id) {
        return repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Species not found"));
    }

    @Transactional
    public SpeciesModel delete(UUID id) {
        var speciesModel = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Species not found"));
        repository.delete(speciesModel);
        return speciesModel;
    }
}
