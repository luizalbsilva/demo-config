package br.com.tamanhofamilia.democonfig.demoservice.model.services;

import java.util.List;

public interface ICrudService<ENTITY, ID> {
    List<ENTITY> listAll();

    ENTITY create(ENTITY entity);

    ENTITY update(ID id, ENTITY entity);

    ENTITY find(ID id);

    void delete(ID id);
}
