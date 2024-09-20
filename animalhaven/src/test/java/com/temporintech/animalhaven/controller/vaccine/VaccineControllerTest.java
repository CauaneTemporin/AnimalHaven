package com.temporintech.animalhaven.controller.vaccine;


package com.temporintech.animalhaven.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.temporintech.animalhaven.controllers.VaccineController;
import com.temporintech.animalhaven.controllers.advice.GlobalExceptionHandler;
import com.temporintech.animalhaven.dtos.VaccineRecordDTO;
import com.temporintech.animalhaven.model.VaccineModel;
import com.temporintech.animalhaven.services.vaccine.VaccineServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class VaccineControllerTest {

    private MockMvc mockMvc;

    @Mock
    private VaccineServiceImpl vaccineService;

    @InjectMocks
    private VaccineController vaccineController;

    private ObjectMapper objectMapper;
    private UUID vaccineId;
    private VaccineModel vaccineModel;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(vaccineController)
                .setControllerAdvice(new GlobalExceptionHandler()) // Para capturar exceções personalizadas
                .build();
        objectMapper = new ObjectMapper();

        vaccineId = UUID.randomUUID();
        vaccineModel = new VaccineModel();
        vaccineModel.setId(vaccineId);
        vaccineModel.setName("Vacina Teste");
        vaccineModel.setDose("1 dose");
        vaccineModel.setManufacturer("Fabricante Teste");
        vaccineModel.setLotNumber("Lote 12345");
        vaccineModel.setObservation("Observação de Teste");
    }

    @Test
    void testSaveVaccine_Success() throws Exception {
        VaccineRecordDTO dto = new VaccineRecordDTO("Vacina Teste", "1 dose", "Fabricante Teste", "Lote 12345", "Observação", null);

        when(vaccineService.save(any(VaccineRecordDTO.class))).thenReturn(vaccineModel);

        mockMvc.perform(post("/vaccine")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Vacina Teste"));
    }

}