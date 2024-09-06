package com.temporintech.animalhaven.service.species;

import com.temporintech.animalhaven.dtos.SpeciesRecordDTO;
import com.temporintech.animalhaven.model.SpeciesModel;
import com.temporintech.animalhaven.repositories.SpeciesRepository;
import com.temporintech.animalhaven.services.animal.AnimalService;
import com.temporintech.animalhaven.services.species.SpeciesServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.UUID;

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
}