package br.com.tamanhofamilia.democonfig.demoservice.model.services.impl;

import br.com.tamanhofamilia.democonfig.demoservice.model.entities.CountryEntity;
import br.com.tamanhofamilia.democonfig.demoservice.model.repositories.ICountryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class CountryServiceTest {
    @InjectMocks
    CountryService countryService;

    @Mock
    ICountryRepository countryRepository;

    @Test
    void listAll() {
        countryService.listAll();

        verify(countryRepository).findAll();
    }

    @Test
    void create() {
        final CountryEntity countryEntity = new CountryEntity();

        countryService.create(countryEntity);

        verify(countryRepository).save(countryEntity);
    }

    @Test
    void update() {
        final CountryEntity countryEntity = mock(CountryEntity.class);

        countryService.update("EGY", countryEntity);


        verify(countryRepository).save(countryEntity);
        verify(countryEntity).setCountryCode("EGY");
    }

    @Test
    void find() {
        final CountryEntity countryEntity = CountryEntity.builder()
                .countryCode("ZWE")
                .name("Zimbabwe")
                .build();
        when(countryRepository.getById("ZWE"))
                .thenReturn(countryEntity);

        final CountryEntity returned = countryService.find("ZWE");

        assertSame(countryEntity, returned);
    }

    @Test
    void delete() {
        countryService.delete("BWA");

        verify(countryRepository).deleteById("BWA");
    }
}