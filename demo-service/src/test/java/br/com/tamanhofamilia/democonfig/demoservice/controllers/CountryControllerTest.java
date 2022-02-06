package br.com.tamanhofamilia.democonfig.demoservice.controllers;

import br.com.tamanhofamilia.democonfig.demoservice.model.entities.CountryEntity;
import br.com.tamanhofamilia.democonfig.demoservice.model.services.ICountryService;
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

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CountryControllerTest {
    public static final String VALID_PAYLOAD = "{\"country-code\": \"BRA\", \"name\": \"Brazil\" }";

    @InjectMocks
    CountryController controller;

    @Mock
    ICountryService service;

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

        mockMvc.perform(get("/country"))
                .andExpect(status().isOk())
                .andExpect(content().json("[ ]"));
    }

    @Test
    void create() throws Exception {
        when(service.create(any(CountryEntity.class)))
                .thenAnswer( a -> a.getArgument(0, CountryEntity.class) );

        mockMvc.perform(
                post("/country")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(VALID_PAYLOAD)
            )
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.country-code").value("BRA"));
    }

    @Test
    void update() throws Exception {
        final ArgumentCaptor<CountryEntity> captor = ArgumentCaptor.forClass(CountryEntity.class);
        when(service.update(eq("BRA"), captor.capture()))
                .thenReturn(CountryEntity.builder()
                        .countryCode("BRA")
                        .name("Brazil")
                        .build());

        mockMvc.perform(
                        put("/country/BRA")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(VALID_PAYLOAD)
                                .accept(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.country-code").value("BRA"))
                .andExpect(jsonPath("$.name").value("Brazil"));

        assertEquals("BRA", captor.getValue().getCountryCode());
        assertEquals("Brazil", captor.getValue().getName());
    }

    @Test
    void find() throws Exception {
        when(service.find("USA"))
                .thenReturn(CountryEntity.builder()
                        .countryCode("USA")
                        .name("United States of America")
                        .build());

        mockMvc.perform(
                    get("/country/USA")
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.country-code").value("USA"))
                .andExpect(jsonPath("$.name").value("United States of America"));

        verify(service).find("USA");
    }

    @Test
    void deleteRecord() throws Exception {
        mockMvc.perform(
                        delete("/country/BRA")
                )
                .andExpect(status().isOk());

        verify(service).delete("BRA");
    }
}