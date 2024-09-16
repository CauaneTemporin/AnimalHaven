package com.temporintech.animalhaven.service.vaccine;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;
import java.util.UUID;

import com.temporintech.animalhaven.services.vaccine.VaccineServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.temporintech.animalhaven.dtos.VaccineRecordDTO;
import com.temporintech.animalhaven.model.VaccineModel;
import com.temporintech.animalhaven.repositories.VaccineRepository;
import com.temporintech.animalhaven.services.animal.AnimalService;
import com.temporintech.animalhaven.services.exceptions.ResourceNotFoundException;

class VaccineServiceImplTest {

    @Mock
    private VaccineRepository repository;

    @Mock
    private AnimalService animalService;

    @InjectMocks
    private VaccineServiceImpl service;

    private VaccineModel vaccine;
    private UUID vaccineId;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        vaccineId = UUID.randomUUID();
        vaccine = new VaccineModel();
        vaccine.setId(vaccineId);
        vaccine.setName("Test Vaccine");
    }

    @Test
    void save_ShouldSaveVaccine() {
        VaccineRecordDTO dto = new VaccineRecordDTO("Test", "1 dose", "Pfizer", "12345", "Observations", null);
        when(repository.save(any(VaccineModel.class))).thenReturn(vaccine);

        VaccineModel savedVaccine = service.save(dto);

        assertNotNull(savedVaccine);
        assertEquals("Test Vaccine", savedVaccine.getName());
    }

    @Test
    void findById_ShouldReturnVaccine() {
        when(repository.findById(vaccineId)).thenReturn(Optional.of(vaccine));

        VaccineModel foundVaccine = service.findById(vaccineId);

        assertNotNull(foundVaccine);
        assertEquals("Test Vaccine", foundVaccine.getName());
    }

}