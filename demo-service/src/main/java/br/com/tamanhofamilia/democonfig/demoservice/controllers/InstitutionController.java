package br.com.tamanhofamilia.democonfig.demoservice.controllers;

import br.com.tamanhofamilia.democonfig.demoservice.model.entities.InstitutionEntity;
import br.com.tamanhofamilia.democonfig.demoservice.model.services.IInstitutionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Institution Controller", description = "Operations on Finantional Institutions")
@RestController
@RequestMapping("/institution")
public class InstitutionController implements ICrudController<InstitutionEntity, Long> {
    @Autowired
    private IInstitutionService service;

    @Operation(description = "List all Institutions' data")
    @GetMapping
    @Override
    public List<InstitutionEntity> listAll() {
        return service.listAll();
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    @Operation(description = "Creates a new Institution")
    public InstitutionEntity create(@RequestBody InstitutionEntity institutionEntity) {
        return service.create(institutionEntity);
    }

    @PutMapping("/{id}")
    @Override
    @Operation(description = "Updates the institution's data, based on it's ID")
    public InstitutionEntity update(
            @Parameter(description = "Institution's id", example = "12")
            @PathVariable("id") Long id, @RequestBody InstitutionEntity countryEntity) {
        return service.update(id, countryEntity);
    }

    @GetMapping("/{id}")
    @Override
    @Operation(description = "Retrieves the Institution based on it's ID")
    public InstitutionEntity find(
            @Parameter(description = "Institution's id", example = "12")
            @PathVariable Long id) {
        return service.find(id);
    }

    @DeleteMapping("/{id}")
    @Override
    @Operation(description = "Deletes the Institution based on it's ID")
    public void delete(
            @Parameter(description = "Institution's id", example = "12")
            @PathVariable Long id) {
        service.delete(id);
    }
}
