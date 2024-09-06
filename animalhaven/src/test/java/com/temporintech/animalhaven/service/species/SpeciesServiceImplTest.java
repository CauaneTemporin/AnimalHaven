package com.temporintech.animalhaven.service.species;

import com.temporintech.animalhaven.dtos.SpeciesRecordDTO;
import com.temporintech.animalhaven.model.SpeciesModel;
import com.temporintech.animalhaven.repositories.SpeciesRepository;
import com.temporintech.animalhaven.services.animal.AnimalService;
import com.temporintech.animalhaven.services.species.SpeciesServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class SpeciesServiceImplTest {

    @InjectMocks
    private SpeciesServiceImpl speciesService;

    @Mock
    private SpeciesRepository speciesRepository;

    @Mock
    private AnimalService animalService;

    private UUID speciesId;
    private SpeciesModel speciesModel;
    private SpeciesRecordDTO speciesDTO;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        speciesId = UUID.randomUUID();
        speciesModel = new SpeciesModel();
        speciesModel.setId(speciesId);
        speciesModel.setName("Test Species");

        speciesDTO = new SpeciesRecordDTO("Test Species");
    }

    @Test
    public void testSaveSpecies() {
        when(speciesRepository.save(any(SpeciesModel.class))).thenReturn(speciesModel);
        SpeciesModel savedSpecies = speciesService.save(speciesDTO);
        assertEquals(speciesModel.getName(), savedSpecies.getName());
        verify(speciesRepository, times(1)).save(any(SpeciesModel.class));
    }

    @Test
    public void testUpdateSpeciesSuccess() {
        when(speciesRepository.findById(speciesId)).thenReturn(Optional.of(speciesModel));
        when(speciesRepository.save(any(SpeciesModel.class))).thenReturn(speciesModel);

        SpeciesModel updatedSpecies = speciesService.update(speciesId, speciesDTO);
        assertEquals(speciesModel.getName(), updatedSpecies.getName());
        verify(speciesRepository, times(1)).findById(speciesId);
        verify(speciesRepository, times(1)).save(any(SpeciesModel.class));
    }
}
