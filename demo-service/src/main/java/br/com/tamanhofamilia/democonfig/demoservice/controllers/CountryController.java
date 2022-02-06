package br.com.tamanhofamilia.democonfig.demoservice.controllers;

import br.com.tamanhofamilia.democonfig.demoservice.model.entities.CountryEntity;
import br.com.tamanhofamilia.democonfig.demoservice.model.services.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController implements ICrudController<CountryEntity, String> {
    @Autowired
    private ICountryService service;

    @GetMapping
    @Override
    public List<CountryEntity> listAll() {
        return service.listAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public CountryEntity create(@RequestBody CountryEntity countryEntity) {
        return service.create(countryEntity);
    }

    @PutMapping("/{countryCode}")
    @Override
    public CountryEntity update(@PathVariable("countryCode") String countryCode, @RequestBody CountryEntity countryEntity) {
        return service.update(countryCode, countryEntity);
    }

    @GetMapping("/{countryCode}")
    @Override
    public CountryEntity find(@PathVariable String countryCode) {
        return service.find(countryCode);
    }

    @DeleteMapping("/{countryCode}")
    @Override
    public void delete(@PathVariable String countryCode) {
        service.delete(countryCode);
    }
}
