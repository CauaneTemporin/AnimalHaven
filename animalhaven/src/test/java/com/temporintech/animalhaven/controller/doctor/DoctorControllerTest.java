package com.temporintech.animalhaven.controller.doctor;

import com.temporintech.animalhaven.controllers.DoctorController;
import com.temporintech.animalhaven.dtos.DoctorRecordDTO;
import com.temporintech.animalhaven.enums.status.Status;
import com.temporintech.animalhaven.model.DoctorModel;
import com.temporintech.animalhaven.services.doctor.DoctorService;
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

class DoctorControllerTest {

    @InjectMocks
    private DoctorController doctorController;

    @Mock
    private DoctorService doctorService;

    private DoctorModel doctorModel;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        doctorModel = new DoctorModel();
        doctorModel.setId(UUID.randomUUID());
        doctorModel.setName("Dr. John");
        doctorModel.setSpecialization("Cardiology");
        doctorModel.setStatus(Status.ACTIVE);
    }

    @Test
    void testSaveDoctorSuccess() {
        DoctorRecordDTO doctorDTO = new DoctorRecordDTO("Dr. John", "Cardiology", Status.ACTIVE, null);
        when(doctorService.save(any(DoctorRecordDTO.class))).thenReturn(doctorModel);

        ResponseEntity<DoctorModel> response = doctorController.saveDoctor(doctorDTO);

        assertNotNull(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Dr. John", response.getBody().getName());
        verify(doctorService, times(1)).save(any(DoctorRecordDTO.class));
    }
}