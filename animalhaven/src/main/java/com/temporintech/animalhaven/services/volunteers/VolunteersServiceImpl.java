package com.temporintech.animalhaven.services.volunteers;

import java.util.List;
import java.util.UUID;

import com.temporintech.animalhaven.dtos.volunteers.VolunteersDTO;
import com.temporintech.animalhaven.model.volunteers.VolunteersModel;
import com.temporintech.animalhaven.services.animals.vaccine.VaccineServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.temporintech.animalhaven.repositories.volunteers.VolunteersRepository;
import com.temporintech.animalhaven.services.exceptions.AssociationException;
import com.temporintech.animalhaven.services.exceptions.ResourceNotFoundException;

@Service
@RequiredArgsConstructor
public class VolunteersServiceImpl implements VolunteersService {

    private final VolunteersRepository repository;
    private final VaccineServiceImpl service;

    @Transactional
    public VolunteersModel save(VolunteersDTO dto) {
        VolunteersModel model = new VolunteersModel();
        BeanUtils.copyProperties(dto, model);
        return repository.save(model);
    }

    @Transactional
    public VolunteersModel update(UUID id, VolunteersDTO dto) {
        VolunteersModel volunteers = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Volunteers with ID " + id + " not found"));
        BeanUtils.copyProperties(dto, volunteers);
        return repository.save(volunteers);
    }

    public List<VolunteersModel> findAll() {
        return repository.findAll();
    }

    public VolunteersModel findById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Volunteers with ID " + id + " not found"));
    }

    @Transactional
    public void delete(UUID id) {
        VolunteersModel volunteers = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Volunteers with ID " + id + " not found"));

        boolean isAssociated = service.existsByVolunteersId(id);
        if (isAssociated) {
            throw new AssociationException("Volunteers with ID " + id + " is associated with one or more vaccine");
        }

        repository.delete(volunteers);
    }
}