package com.temporintech.animalhaven.services.vaccine;

import java.util.List;
import java.util.UUID;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.temporintech.animalhaven.dtos.VaccineRecordDTO;
import com.temporintech.animalhaven.model.VaccineModel;
import com.temporintech.animalhaven.repositories.VaccineRepository;
import com.temporintech.animalhaven.services.animal.AnimalService;
import com.temporintech.animalhaven.services.exceptions.AssociationException;
import com.temporintech.animalhaven.services.exceptions.ResourceNotFoundException;

@Service
@RequiredArgsConstructor
public class VaccineServiceImpl implements VaccineService {

    private final VaccineRepository repository;
    private final AnimalService animalService;

    @Transactional
    public VaccineModel save(VaccineRecordDTO dto) {
        VaccineModel model = new VaccineModel();
        BeanUtils.copyProperties(dto, model);
        return repository.save(model);
    }

    @Transactional
    public VaccineModel update(UUID id, VaccineRecordDTO dto) {
        VaccineModel vaccineModel = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vaccine with ID " + id + " not found"));
        BeanUtils.copyProperties(dto, vaccineModel);
        return repository.save(vaccineModel);
    }

    public List<VaccineModel> findAll() {
        return repository.findAll();
    }

    public VaccineModel findById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vaccine with ID " + id + " not found"));
    }

    @Transactional
    public void delete(UUID id) {
        VaccineModel vaccineModel = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vaccine with ID " + id + " not found"));

        boolean isAssociated = animalService.existsByVaccineId(id);
        if (isAssociated) {
            throw new AssociationException("Vaccine with ID " + id + " is associated with one or more animals");
        }

        repository.delete(vaccineModel);
    }

    @Transactional(readOnly = true)
    public boolean existsByDoctorId(UUID doctorId) {
        return repository.existsByDoctorId(doctorId);
    }
}