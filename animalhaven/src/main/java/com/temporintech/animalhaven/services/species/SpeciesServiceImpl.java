package com.temporintech.animalhaven.services.species;

import java.util.List;
import java.util.UUID;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.temporintech.animalhaven.dtos.SpeciesRecordDTO;
import com.temporintech.animalhaven.model.SpeciesModel;
import com.temporintech.animalhaven.repositories.SpeciesRepository;
import com.temporintech.animalhaven.services.animal.AnimalService;
import com.temporintech.animalhaven.services.exceptions.AssociationException;
import com.temporintech.animalhaven.services.exceptions.ResourceNotFoundException;

@Service
@RequiredArgsConstructor
public class SpeciesServiceImpl implements SpeciesService {

    private final SpeciesRepository repository;
    private final AnimalService animalService;

    @Transactional
    public SpeciesModel save(SpeciesRecordDTO dto) {
        SpeciesModel model = new SpeciesModel();
        BeanUtils.copyProperties(dto, model);
        return repository.save(model);
    }

    @Transactional
    public SpeciesModel update(UUID id, SpeciesRecordDTO dto) {
        SpeciesModel speciesModel = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Species with ID " + id + " not found"));
        BeanUtils.copyProperties(dto, speciesModel);
        return repository.save(speciesModel);
    }

    public List<SpeciesModel> findAll() {
        return repository.findAll();
    }

    public SpeciesModel findById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Species with ID " + id + " not found"));
    }

    @Transactional
    public void delete(UUID id) {
        SpeciesModel speciesModel = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Species with ID " + id + " not found"));

        boolean isAssociated = animalService.existsBySpeciesId(id);
        if (isAssociated) {
            throw new AssociationException("Species with ID " + id + " is associated with one or more animals");
        }

        repository.delete(speciesModel);
    }

}
