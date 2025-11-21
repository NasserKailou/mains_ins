package com.atacorp.SISEAN.referentiel.formationSanitaire;

import org.springframework.data.repository.CrudRepository;

public interface TypeFormationSanitaireRepository extends CrudRepository<TypeFormationSanitaire, Integer> {

	TypeFormationSanitaire findByIdTypeFormationSanitaire(Integer idTypeFormationSanitaire);
	TypeFormationSanitaire findByLibelleTypeFormationSanitaire(String libelleTypeFormationSanitaire);
}
