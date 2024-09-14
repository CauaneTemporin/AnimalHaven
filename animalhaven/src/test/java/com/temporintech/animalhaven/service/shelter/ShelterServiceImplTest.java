package com.temporintech.animalhaven.services.shelter;

import com.temporintech.animalhaven.dtos.ShelterRecordDTO;
import com.temporintech.animalhaven.model.ShelterModel;
import com.temporintech.animalhaven.repositories.ShelterRepository;
import com.temporintech.animalhaven.services.animal.AnimalService;
import com.temporintech.animalhaven.services.exceptions.AssociationException;
import com.temporintech.animalhaven.services.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ShelterServiceImplTest {

    @Mock
    private ShelterRepository repository;

    @Mock
    private AnimalService animalService;

    @InjectMocks
    private ShelterServiceImpl service;

    private UUID shelterId;
    private ShelterModel shelter;
    private ShelterRecordDTO shelterDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        shelterId = UUID.randomUUID();
        shelter = new ShelterModel();
        shelter.setId(shelterId);
        shelter.setName("Shelter A");
        shelter.setAddress("123 Street");
        shelter.setPhoneNumber("123456789");
        shelter.setCapacity(50);

        shelterDTO = new ShelterRecordDTO("Shelter A", "123 Street", "123456789", 50);
    }

    @Test
    void testSaveShelter() {
        when(repository.save(any(ShelterModel.class))).thenReturn(shelter);

        ShelterModel savedShelter = service.save(shelterDTO);

        assertNotNull(savedShelter);
        assertEquals(shelter.getId(), savedShelter.getId());
        verify(repository, times(1)).save(any(ShelterModel.class));
    }

    @Test
    void testUpdateShelter_Success() {
        when(repository.findById(shelterId)).thenReturn(Optional.of(shelter));
        when(repository.save(any(ShelterModel.class))).thenReturn(shelter);

        ShelterModel updatedShelter = service.update(shelterId, shelterDTO);

        assertNotNull(updatedShelter);
        assertEquals(shelterDTO.name(), updatedShelter.getName());
        verify(repository, times(1)).save(shelter);
    }


    @Test
    void testUpdateShelter_NotFound() {
        when(repository.findById(shelterId)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> service.update(shelterId, shelterDTO));
        verify(repository, never()).save(any(ShelterModel.class));
    }

    @Test
    void testFindById_Success() {
        when(repository.findById(shelterId)).thenReturn(Optional.of(shelter));

        ShelterModel foundShelter = service.findById(shelterId);

        assertNotNull(foundShelter);
        assertEquals(shelter.getName(), foundShelter.getName());
    }

    @Test
    void testFindById_NotFound() {
        when(repository.findById(shelterId)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> service.findById(shelterId));
    }

    @Test
    void testDeleteShelter_Success() {
        when(repository.findById(shelterId)).thenReturn(Optional.of(shelter));
        when(animalService.existsByShelterId(shelterId)).thenReturn(false);

        service.delete(shelterId);

        verify(repository, times(1)).delete(shelter);
    }

    @Test
    void testDeleteShelter_AssociationExists() {
        when(repository.findById(shelterId)).thenReturn(Optional.of(shelter));
        when(animalService.existsByShelterId(shelterId)).thenReturn(true);

        assertThrows(AssociationException.class, () -> service.delete(shelterId));
        verify(repository, never()).delete(shelter);
    }

    @Test
    void testFindAll() {
        when(repository.findAll()).thenReturn(List.of(shelter));

        List<ShelterModel> shelters = service.findAll();

        assertFalse(shelters.isEmpty());
        assertEquals(1, shelters.size());
        assertEquals(shelter.getName(), shelters.get(0).getName());
    }
}