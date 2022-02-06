package br.com.tamanhofamilia.democonfig.demoservice.controllers;

import br.com.tamanhofamilia.democonfig.demoservice.model.entities.CountryEntity;
import br.com.tamanhofamilia.democonfig.demoservice.model.services.ICountryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Country Controller", description = "Operations on Countries")
@RestController
@RequestMapping("/country")
public class CountryController implements ICrudController<CountryEntity, String> {
    @Autowired
    private ICountryService service;

    @Operation(description = "List all Countries data")
    @GetMapping
    @Override
    public List<CountryEntity> listAll() {
        return service.listAll();
    }

    @Operation(description = "Creates a new Country")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public CountryEntity create(@RequestBody CountryEntity countryEntity) {
        return service.create(countryEntity);
    }

    @Operation(description = "Updates a country")
    @PutMapping("/{countryCode}")
    @Override
    public CountryEntity update(
            @Parameter(description = "ISO 3166-1 alfa-3", example = "JPN")
            @PathVariable("countryCode") String countryCode, @RequestBody CountryEntity countryEntity) {
        return service.update(countryCode, countryEntity);
    }

    @Operation(description = "Find a Country by it's Id")
    @GetMapping("/{countryCode}")
    @Override
    public CountryEntity find(
            @Parameter(name = "CountryCode", description = "ISO 3166-1 alfa-3", example = "EGY")
            @PathVariable String countryCode) {
        return service.find(countryCode);
    }

    @Operation(description = "Deletes the country")
    @DeleteMapping("/{countryCode}")
    @Override
    public void delete(
            @Parameter(name = "CountryCode", description = "ISO 3166-1 alfa-3", example = "KEN")
            @PathVariable String countryCode) {
        service.delete(countryCode);
    }
}
