package br.com.tamanhofamilia.democonfig.demoservice.controllers;

import java.util.List;

public interface ICrudController<ENTITY, ID> {
    List<ENTITY> listAll();

    ENTITY create(ENTITY entity);

    ENTITY update(ID id, ENTITY entity);

    ENTITY find(ID id);

    void delete(ID id);
}
