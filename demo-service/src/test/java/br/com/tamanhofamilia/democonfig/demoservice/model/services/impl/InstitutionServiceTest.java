package br.com.tamanhofamilia.democonfig.demoservice.model.services.impl;

import br.com.tamanhofamilia.democonfig.demoservice.model.entities.InstitutionEntity;
import br.com.tamanhofamilia.democonfig.demoservice.model.repositories.IInstitutionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class InstitutionServiceTest {
    @InjectMocks
    InstitutionService service;

    @Mock
    IInstitutionRepository repository;

    @Test
    void listAll() {
        service.listAll();

        verify(repository).findAll();
    }

    @Test
    void create() {
        final InstitutionEntity countryEntity = new InstitutionEntity();

        service.create(countryEntity);

        verify(repository).save(countryEntity);
    }

    @Test
    void update() {
        final InstitutionEntity countryEntity = mock(InstitutionEntity.class);

        service.update(12L, countryEntity);

        verify(repository).save(countryEntity);
        verify(countryEntity).setId(12L);
    }

    @Test
    void find() {
        final InstitutionEntity countryEntity = InstitutionEntity.builder()
                .name("Bank of Boston")
                .id(7L)
                .build();

        when(repository.getById(7L))
                .thenReturn(countryEntity);

        final InstitutionEntity returned = service.find(7L);

        assertSame(countryEntity, returned);
    }

    @Test
    void delete() {
        service.delete(564L);

        verify(repository).deleteById(564L);
    }
}