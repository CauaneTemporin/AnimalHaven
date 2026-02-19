package com.temporintech.animalhaven.controller.doctor;

import com.temporintech.animalhaven.controllers.volunteers.VolunteersController;
import com.temporintech.animalhaven.dtos.volunteers.VolunteersDTO;
import com.temporintech.animalhaven.enums.util.Status;
import com.temporintech.animalhaven.model.volunteers.VolunteersModel;
import com.temporintech.animalhaven.services.volunteers.VolunteersService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class VolunteersControllerTest {

    @InjectMocks
    private VolunteersController controller;

    @Mock
    private VolunteersService doctorService;

    private VolunteersModel doctorModel;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        doctorModel = new VolunteersModel();
        doctorModel.setId(UUID.randomUUID());
        doctorModel.setName("Dr. John");
        doctorModel.setSpecialization("Cardiology");
        doctorModel.setStatus(Status.ACTIVE);
    }

    @Test
    void testSaveDoctorSuccess() {
        VolunteersDTO dto = new VolunteersDTO("Dr. John", "Cardiology", Status.ACTIVE, null);
        when(doctorService.save(any(VolunteersDTO.class))).thenReturn(doctorModel);

        ResponseEntity<VolunteersModel> response = controller.saveVolunteers(dto);

        assertNotNull(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Dr. John", response.getBody().getName());
        verify(doctorService, times(1)).save(any(VolunteersDTO.class));
    }

    @Test
    void testGetAllDoctorsSuccess() {
        when(doctorService.findAll()).thenReturn(Arrays.asList(doctorModel));

        ResponseEntity<List<VolunteersModel>> response = controller.getAllVolunteers();

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
        verify(doctorService, times(1)).findAll();
    }

    @Test
    void testGetDoctorByIdSuccess() {
        UUID doctorId = doctorModel.getId();
        when(doctorService.findById(doctorId)).thenReturn(doctorModel);

        ResponseEntity<Object> response = controller.getOneVolunteers(doctorId);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(doctorModel, response.getBody());
        verify(doctorService, times(1)).findById(doctorId);
    }

    @Test
    void testUpdateDoctorSuccess() {
        UUID doctorId = doctorModel.getId();
        VolunteersDTO dto = new VolunteersDTO("Dr. Jane", "Dermatology", Status.ACTIVE, null);

        when(doctorService.update(doctorId, dto)).thenReturn(doctorModel);

        ResponseEntity<Object> response = controller.updateVolunteers(doctorId, dto);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(doctorService, times(1)).update(doctorId, dto);
    }

    @Test
    void testDeleteDoctorSuccess() {
        UUID doctorId = doctorModel.getId();

        doNothing().when(doctorService).delete(doctorId);

        ResponseEntity<Void> response = controller.deleteVolunteers(doctorId);

        assertNotNull(response);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(doctorService, times(1)).delete(doctorId);
    }
}