package com.temporintech.animalhaven.service.doctor;

import com.temporintech.animalhaven.dtos.DoctorRecordDTO;
import com.temporintech.animalhaven.enums.status.Status;
import com.temporintech.animalhaven.model.DoctorModel;
import com.temporintech.animalhaven.repositories.DoctorRepository;
import com.temporintech.animalhaven.services.doctor.DoctorServiceImpl;
import com.temporintech.animalhaven.services.exceptions.AssociationException;
import com.temporintech.animalhaven.services.exceptions.ResourceNotFoundException;
import com.temporintech.animalhaven.services.vaccine.VaccineServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.BeanUtils;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class DoctorServiceImplTest {

    @InjectMocks
    private DoctorServiceImpl doctorService;

    @Mock
    private DoctorRepository doctorRepository;

    @Mock
    private VaccineServiceImpl vaccineService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveDoctorSuccess() {
        DoctorRecordDTO doctorDTO = new DoctorRecordDTO("Dr. John", "Cardiology", Status.ACTIVE, null);
        DoctorModel savedDoctor = new DoctorModel();
        BeanUtils.copyProperties(doctorDTO, savedDoctor);

        when(doctorRepository.save(any(DoctorModel.class))).thenReturn(savedDoctor);

        DoctorModel result = doctorService.save(doctorDTO);

        assertNotNull(result);
        assertEquals("Dr. John", result.getName());
        verify(doctorRepository, times(1)).save(any(DoctorModel.class));
    }

    @Test
    void testDeleteDoctorThrowsAssociationException() {
        UUID doctorId = UUID.randomUUID();
        DoctorModel doctor = new DoctorModel();
        doctor.setId(doctorId);

        when(doctorRepository.findById(doctorId)).thenReturn(Optional.of(doctor));
        when(vaccineService.existsByDoctorId(doctorId)).thenReturn(true);

        AssociationException exception = assertThrows(AssociationException.class, () -> {
            doctorService.delete(doctorId);
        });

        assertEquals("Doctor with ID " + doctorId + " is associated with one or more vaccine", exception.getMessage());
        verify(doctorRepository, never()).delete(any(DoctorModel.class));
    }

    @Test
    void testDeleteDoctorSuccess() {
        UUID doctorId = UUID.randomUUID();
        DoctorModel doctor = new DoctorModel();
        doctor.setId(doctorId);

        when(doctorRepository.findById(doctorId)).thenReturn(Optional.of(doctor));
        when(vaccineService.existsByDoctorId(doctorId)).thenReturn(false);

        doctorService.delete(doctorId);

        verify(doctorRepository, times(1)).delete(doctor);
    }

    @Test
    void testFindByIdThrowsResourceNotFoundException() {
        UUID doctorId = UUID.randomUUID();

        when(doctorRepository.findById(doctorId)).thenReturn(Optional.empty());

        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class, () -> {
            doctorService.findById(doctorId);
        });

        assertEquals("Doctor with ID " + doctorId + " not found", exception.getMessage());
        verify(doctorRepository, times(1)).findById(doctorId);
    }
}
