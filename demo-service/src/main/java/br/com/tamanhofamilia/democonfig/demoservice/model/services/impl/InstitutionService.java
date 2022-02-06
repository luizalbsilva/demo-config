package br.com.tamanhofamilia.democonfig.demoservice.model.services.impl;

import br.com.tamanhofamilia.democonfig.demoservice.model.entities.InstitutionEntity;
import br.com.tamanhofamilia.democonfig.demoservice.model.repositories.IInstitutionRepository;
import br.com.tamanhofamilia.democonfig.demoservice.model.services.IInstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstitutionService implements IInstitutionService {
    private final IInstitutionRepository repository;

    @Autowired
    public InstitutionService(IInstitutionRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<InstitutionEntity> listAll() {
        return repository.findAll();
    }

    @Override
    public InstitutionEntity create(InstitutionEntity institutionEntity) {
        return repository.save(institutionEntity);
    }

    @Override
    public InstitutionEntity update(Long id, InstitutionEntity institutionEntity) {
        institutionEntity.setId(id);
        return repository.save(institutionEntity);
    }

    @Override
    public InstitutionEntity find(Long id) {
        return repository.getById(id);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
