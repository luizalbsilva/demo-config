package br.com.tamanhofamilia.democonfig.demoservice.controllers;

import br.com.tamanhofamilia.democonfig.demoservice.model.entities.InstitutionEntity;
import br.com.tamanhofamilia.democonfig.demoservice.model.services.IInstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/institution")
public class InstitutionController implements ICrudController<InstitutionEntity, Long> {
    @Autowired
    private IInstitutionService service;

    @GetMapping
    @Override
    public List<InstitutionEntity> listAll() {
        return service.listAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public InstitutionEntity create(@RequestBody InstitutionEntity institutionEntity) {
        return service.create(institutionEntity);
    }

    @PutMapping("/{id}")
    @Override
    public InstitutionEntity update(@PathVariable("id") Long id, @RequestBody InstitutionEntity countryEntity) {
        return service.update(id, countryEntity);
    }

    @GetMapping("/{id}")
    @Override
    public InstitutionEntity find(@PathVariable Long id) {
        return service.find(id);
    }

    @DeleteMapping("/{id}")
    @Override
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
