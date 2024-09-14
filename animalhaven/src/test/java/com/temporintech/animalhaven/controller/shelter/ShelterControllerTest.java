package com.temporintech.animalhaven.controller.shelter;

import com.temporintech.animalhaven.controllers.ShelterController;
import com.temporintech.animalhaven.dtos.ShelterRecordDTO;
import com.temporintech.animalhaven.model.ShelterModel;
import com.temporintech.animalhaven.services.shelter.ShelterService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ShelterControllerTest {

    @Mock
    private ShelterService service;

    @InjectMocks
    private ShelterController controller;

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
}