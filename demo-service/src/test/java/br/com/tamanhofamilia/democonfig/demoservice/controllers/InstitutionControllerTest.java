package br.com.tamanhofamilia.democonfig.demoservice.controllers;

import br.com.tamanhofamilia.democonfig.demoservice.model.entities.InstitutionEntity;
import br.com.tamanhofamilia.democonfig.demoservice.model.services.IInstitutionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class InstitutionControllerTest {
    public static final String VALID_PAYLOAD_CREATE = "{\"name\": \"Bradesco\" }";
    public static final String VALID_PAYLOAD_UPDATE = "{\"id\": 15, \"name\": \"Banco do Brasil\" }";

    @InjectMocks
    InstitutionController controller;

    @Mock
    IInstitutionService service;

    MockMvc mockMvc;

    @BeforeEach
    void beforeEach() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .build();
    }

    @Test
    void listAll() throws Exception {
        when(service.listAll())
                .thenReturn(Collections.emptyList());

        mockMvc.perform(get("/institution"))
                .andExpect(status().isOk())
                .andExpect(content().json("[ ]"));
    }

    @Test
    void create() throws Exception {
        when(service.create(any(InstitutionEntity.class)))
                .thenAnswer( a -> {
                    final InstitutionEntity argument = a.getArgument(0, InstitutionEntity.class);
                    argument.setId(33L);
                    return argument;
                } );

        mockMvc.perform(
                        post("/institution")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(VALID_PAYLOAD_CREATE)
                )
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(33L));
    }

    @Test
    void update() throws Exception {
        final ArgumentCaptor<InstitutionEntity> captor = ArgumentCaptor.forClass(InstitutionEntity.class);
        when(service.update(eq(15L), captor.capture()))
                .thenReturn(InstitutionEntity.builder()
                        .id(15L)
                        .name("Banco do Brasil")
                        .build());

        mockMvc.perform(
                        put("/institution/15")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(VALID_PAYLOAD_UPDATE)
                                .accept(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(15L))
                .andExpect(jsonPath("$.name").value("Banco do Brasil"));

        assertEquals(15L, captor.getValue().getId());
        assertEquals("Banco do Brasil", captor.getValue().getName());
    }

    @Test
    void find() throws Exception {
        when(service.find(18L))
                .thenReturn(InstitutionEntity.builder()
                        .id(18L)
                        .name("Banco Itaú")
                        .build());

        mockMvc.perform(
                        get("/institution/18")
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(18))
                .andExpect(jsonPath("$.name").value("Banco Itaú"));

        verify(service).find(18L);
    }

    @Test
    void deleteRecord() throws Exception {
        mockMvc.perform(
                        delete("/institution/32")
                )
                .andExpect(status().isOk());

        verify(service).delete(32L);
    }
}