package br.com.tamanhofamilia.democonfig.demoservice.model.services;

import br.com.tamanhofamilia.democonfig.demoservice.model.entities.InstitutionEntity;

import java.util.List;

public interface IInstitutionService extends ICrudService<InstitutionEntity, Long>{
    List<InstitutionEntity> listAll();

    InstitutionEntity create(InstitutionEntity institutionEntity);

    InstitutionEntity update(Long id, InstitutionEntity countryEntity);

    InstitutionEntity find(Long id);

    void delete(Long id);
}
