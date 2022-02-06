package br.com.tamanhofamilia.democonfig.demoservice.controllers;

import java.util.List;

public interface ICrudController<E, I> {
    List<E> listAll();

    E create(E entity);

    E update(I id, E entity);

    E find(I id);

    void delete(I id);
}
