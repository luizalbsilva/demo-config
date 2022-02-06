package br.com.tamanhofamilia.democonfig.demoservice.model.repositories;

import br.com.tamanhofamilia.democonfig.demoservice.model.entities.InstitutionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInstitutionRepository extends JpaRepository<InstitutionEntity, Long> {
}
