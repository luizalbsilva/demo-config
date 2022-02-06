package br.com.tamanhofamilia.democonfig.demoservice.model.repositories;

import br.com.tamanhofamilia.democonfig.demoservice.model.entities.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICountryRepository extends JpaRepository<CountryEntity, String> {
}
