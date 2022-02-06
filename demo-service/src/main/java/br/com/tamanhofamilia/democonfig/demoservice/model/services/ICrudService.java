package br.com.tamanhofamilia.democonfig.demoservice.model.services;

import java.util.List;

public interface ICrudService<E, I> {
    List<E> listAll();

    E create(E entity);

    E update(I id, E entity);

    E find(I id);

    void delete(I id);
}
