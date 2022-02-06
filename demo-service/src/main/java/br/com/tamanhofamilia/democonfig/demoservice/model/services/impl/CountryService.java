package br.com.tamanhofamilia.democonfig.demoservice.model.services.impl;

import br.com.tamanhofamilia.democonfig.demoservice.model.entities.CountryEntity;
import br.com.tamanhofamilia.democonfig.demoservice.model.repositories.ICountryRepository;
import br.com.tamanhofamilia.democonfig.demoservice.model.services.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService implements ICountryService {
    @Autowired
    private ICountryRepository repository;

    @Override
    public List<CountryEntity> listAll() {
        return repository.findAll();
    }

    @Override
    public CountryEntity create(CountryEntity countryEntity) {
        return repository.save(countryEntity);
    }

    @Override
    public CountryEntity update(String code, CountryEntity countryEntity) {
        countryEntity.setCountryCode(code);
        return repository.save(countryEntity);
    }

    @Override
    public CountryEntity find(String id) {
        return repository.getById(id);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}
