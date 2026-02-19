package com.temporintech.animalhaven.services.adopter;

import com.temporintech.animalhaven.dtos.adopter.AdopterDTO;
import com.temporintech.animalhaven.model.adopter.AdopterModel;
import com.temporintech.animalhaven.model.shelter.ShelterModel;
import com.temporintech.animalhaven.repositories.adopter.AdopterRepository;
import com.temporintech.animalhaven.services.exceptions.AssociationException;
import com.temporintech.animalhaven.services.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AdopterServiceImpl implements AdopterService{

    private final AdopterRepository repository;

    @Override
    public AdopterModel save(AdopterDTO dto) {
        AdopterModel model = new AdopterModel();
        BeanUtils.copyProperties(dto, model);
        return repository.save(model);
    }

    @Override
    public AdopterModel update(UUID id, AdopterDTO dto) {
        AdopterModel model =  repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Adopter with ID " + id + " not found"));
        BeanUtils.copyProperties(dto, model);
        return repository.save(model);
    }

    @Override
    public List<AdopterModel> findAll() {
        return repository.findAll();
    }

    @Override
    public AdopterModel findById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Adopter with ID " + id + " not found"));
    }

    @Override
    public void delete(UUID id) {
        AdopterModel model = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Adopter with ID " + id + " not found"));

        repository.delete(model);
    }
}