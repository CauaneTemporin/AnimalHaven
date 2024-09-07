package com.temporintech.animalhaven.controller.species;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.temporintech.animalhaven.controllers.SpeciesController;
import com.temporintech.animalhaven.dtos.SpeciesRecordDTO;
import com.temporintech.animalhaven.model.SpeciesModel;
import com.temporintech.animalhaven.services.species.SpeciesServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SpeciesController.class)
public class SpeciesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SpeciesServiceImpl speciesService;

    @Autowired
    private ObjectMapper objectMapper;

    private SpeciesModel speciesModel;
    private SpeciesRecordDTO speciesDTO;
    private UUID speciesId;

    @BeforeEach
    public void setup() {
        speciesId = UUID.randomUUID();
        speciesModel = new SpeciesModel();
        speciesModel.setId(speciesId);
        speciesModel.setName("Test Species");

        speciesDTO = new SpeciesRecordDTO("Test Species");
    }

    @Test
    public void testSaveSpecies() throws Exception {
        when(speciesService.save(any(SpeciesRecordDTO.class))).thenReturn(speciesModel);

        mockMvc.perform(post("/species")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(speciesDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value(speciesModel.getName()));
    }

    @Test
    public void testGetAllSpecies() throws Exception {
        when(speciesService.findAll()).thenReturn(Arrays.asList(speciesModel));

        mockMvc.perform(get("/species"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value(speciesModel.getName()));
    }

    @Test
    public void testGetOneSpecies() throws Exception {
        when(speciesService.findById(speciesId)).thenReturn(speciesModel);

        mockMvc.perform(get("/species/{id}", speciesId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(speciesModel.getName()));
    }

    @Test
    public void testUpdateSpecies() throws Exception {
        when(speciesService.update(eq(speciesId), any(SpeciesRecordDTO.class))).thenReturn(speciesModel);

        mockMvc.perform(put("/species/{id}", speciesId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(speciesDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(speciesModel.getName()));
    }

    @Test
    public void testDeleteSpecies() throws Exception {
        doNothing().when(speciesService).delete(speciesId);

        mockMvc.perform(delete("/species/{id}", speciesId))
                .andExpect(status().isNoContent());
    }
}